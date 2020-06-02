import Ccode.GenerateCode;
import javacc.MicroblazeParser;
import javacc.Node;
import javacc.SimpleNode;
import nodes.CfgNode;
import nodes.InstructionNode;
import nodes.PathEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.dot.DOTExporter;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	static Graph<CfgNode, PathEdge> cfGraph = new DefaultDirectedGraph<>(PathEdge.class);
	static Graph<InstructionNode, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

	static private int FUNCTION_ISOLATION = 6;

	public static void main(String[] args) throws IOException {
		//[TO TEST]
		CfgNode rootnode =  loadGraph("./input/fir-O2.txt");
		GenerateCode code = new GenerateCode(cfGraph,rootnode,"output.c", true);
		GenerateCode code2 = new GenerateCode(cfGraph,rootnode,"output2.c", false);
		code.exportCode();
		code2.exportCode();
		// [PROPER USE]
		//checkArgs(args);
		//loadGraph(args[0]);
		visualizeGraph();
	}

	/**
	 * Checks program parameters and provides "Usage" prompt if wrong number
	 * 
	 * @param args parameters to be checked
	 */
	private static void checkArgs(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: Main <filename>");
			System.exit(0);
		}
	}

	/**
	 * Opens file, parses its content with jjtree and javacc, and builds a graph
	 * (Graph<InstructionNode, DefaultEdge> graph) based on the work: 
	 * 
	 * "Limits of Parallelism Using Dynamic Dependency Graphs" by: 
	 * 
	 * Jonathan Mak University of
	 * Cambridge Computer Laboratory William Gates Building, 15 JJ Thomson Avenue
	 * Cambridge CB3 0FD, United Kingdom Jonathan.Mak@cl.cam.ac.uk 
	 * 
	 * & 
	 * 
	 * Alan Mycroft
	 * University of Cambridge Computer Laboratory William Gates Building, 15 JJ
	 * Thomson Avenue Cambridge CB3 0FD, United Kingdom~ Alan.Mycroft@cl.cam.ac.uk
	 * 
	 * Note: Complete publication in folder "./docs"
	 * 
	 * @param fileName File to be parsed
	 * 
	 */
	private static CfgNode loadGraph(String fileName) {
		File f = new File(fileName);
		CfgNode rootNode = null;
		if (f.isFile() && f.canRead()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				try {
					MicroblazeParser trace = new MicroblazeParser(fis);
					try {
						SimpleNode root = trace.Expression(); // returns reference to root node
						 //root.dump(""); // prints the tree on the screen

						rootNode = traceToCFG(root);

					} catch (Exception e) {
						System.err.print(e);
					}
				} finally {
					fis.close();
				}
			} catch (IOException ex) {
				System.err.println(ex);
				System.exit(-1);
			}
		}
		return rootNode;
	}

	/**
	 * Takes the contents of the graph generated by javacc and creates the jgrapht
	 * Graph
	 * 
	 * @param root node of javacc graph created by the parser
	 * 
	 */
	private static void cfgToGraph(CfgNode cfgRoot) {
		CfgNode curNode = cfgRoot;
		HashMap<String, InstructionNode> lastToAlter = new HashMap<String, InstructionNode>();
		int decisionPath = 0;
		while (true) {

			String address;
			String instruction;
			/*
			if (javaccNode instanceof SimpleNode) {
				SimpleNode javaccSimpleNode = ((SimpleNode) javaccNode);

				address = javaccSimpleNode.getAddress();
				instruction = javaccSimpleNode.getInstruction();

				InstructionNode vertex = new InstructionNode(address, instruction);
				graph.addVertex(vertex);
				
				//adding destination operand to HashMap
				if(javaccSimpleNode.getRegister1()!=null){
					lastToAlter.put(javaccSimpleNode.getRegister1(), vertex);
				}

				//Ingoing Edge (source operand a)
				if(javaccSimpleNode.getRegister2()!=null){
					if(lastToAlter.containsKey(javaccSimpleNode.getRegister2())){
						graph.addEdge(
							lastToAlter.get(javaccSimpleNode.getRegister2()), 
							vertex);
					}
				}

				//Ingoing Edge (source operand b)
				if(javaccSimpleNode.getRegister3()!=null){
					if(lastToAlter.containsKey(javaccSimpleNode.getRegister3())){
						graph.addEdge(
							lastToAlter.get(javaccSimpleNode.getRegister3()), 
							vertex);
					}
				}
			}
*/
			if(cfGraph.outgoingEdgesOf(curNode).isEmpty()) break;
			//else (cfGraph.outgoingEdgesOf(curNode).size() == 1) curNode = cfGraph.getEdgeTarget();
		}
	}

	/**
	 * Exports Graph<InstructionNode, DefaultEdge> graph as a DOT file
	 * for vizualization 
	 * https://stackoverflow.com/questions/16998608/jgrapht-export-to-dot-file
	 */

	
	private static void visualizeGraph() {
		DOTExporter<CfgNode,PathEdge>exporter = new DOTExporter<>((v->"A"+v.getAddress()));
		exporter.setVertexAttributeProvider((v)->{
			Map<String, Attribute> map=new LinkedHashMap<>();
			map.put("label", DefaultAttribute.createAttribute(v.getAddress() + " " + v.getInstruction()));return map;});
		exporter.setEdgeAttributeProvider((e)->{
			Map<String, Attribute> map=new LinkedHashMap<>();
			map.put("label", DefaultAttribute.createAttribute(e.toString()));return map;});
		Writer writer=new StringWriter();
		exporter.exportGraph(cfGraph,writer);

		System.out.println(writer.toString());
		try {
			FileWriter myWriter = new FileWriter("output.dot");
			myWriter.write(writer.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	private static CfgNode traceToCFG(SimpleNode root) {
		int numChildren = root.jjtGetNumChildren();
		HashMap<String, CfgNode> nodes = new HashMap<String, CfgNode>();
		CfgNode cfgRoot = new CfgNode(-1, "start", "START");
		cfGraph.addVertex(cfgRoot);
		String lastAddress = null;
		System.out.println(numChildren);

		int decisionPath = 0;

		for (int i = parseFunction(root); i < numChildren; i++) {
			String address;
			Node javaccNode = root.jjtGetChild(i);
			if (javaccNode instanceof SimpleNode) {
				SimpleNode javaccSimpleNode = ((SimpleNode) javaccNode);
				address = javaccSimpleNode.getAddress();

				if (!nodes.containsKey(address)) {
					CfgNode vertex = new CfgNode(i, address, javaccSimpleNode.getInstruction());

					setRegisters(javaccSimpleNode, vertex);

					cfGraph.addVertex(vertex);
					nodes.put(address, vertex);
					if (lastAddress != null) {
						cfGraph.addEdge(nodes.get(lastAddress), vertex);
						if (cfGraph.outgoingEdgesOf(nodes.get(lastAddress)).size() > 1) {
							cfGraph.getEdge(nodes.get(lastAddress), vertex).addPath(decisionPath);
							decisionPath++;
						}
					} else {
						cfGraph.addEdge(cfgRoot, vertex);
					}
				} else {
					if (!cfGraph.containsEdge(nodes.get(lastAddress), nodes.get(address))) {
						cfGraph.addEdge(nodes.get(lastAddress), nodes.get(address)).addPath(decisionPath);
						decisionPath++;
					} else {
						if (!cfGraph.getEdge(nodes.get(lastAddress), nodes.get(address)).isPathEmpty()) {
							cfGraph.getEdge(nodes.get(lastAddress), nodes.get(address)).addPath(decisionPath);
							decisionPath++;
						}
					}
				}
				lastAddress = address;
			}
		}

		CfgNode cfgEnd = new CfgNode(-2, "end", "END");
		cfGraph.addVertex(cfgEnd);
		cfGraph.addEdge(nodes.get(lastAddress), cfgEnd);

		return cfgRoot;

	}






	private static void setRegisters(SimpleNode node, CfgNode vertex){
		if(node.getRegister1() != null) vertex.setRegister1(node.getRegister1());
		if(node.getRegister2() != null) vertex.setRegister2(node.getRegister2());
		if(node.getRegister3() != null) vertex.setRegister3(node.getRegister3());
		if(node.getLiteral() != null) vertex.setLiteral(node.getLiteral());
	}


	private static int parseFunction(SimpleNode root){
		int iterator = 0;
		int count = 0;
		while(count < FUNCTION_ISOLATION && iterator < root.jjtGetNumChildren()){
			Node javaccNode = root.jjtGetChild(iterator);
			if (javaccNode instanceof SimpleNode) {
				SimpleNode javaccSimpleNode = ((SimpleNode) javaccNode);
				if(javaccSimpleNode.getInstruction().equals("brlid")) {count++;}
			}
			iterator++;
		}
		return iterator;
	}
}

