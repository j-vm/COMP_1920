import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.Renderer;
import javacc.nodes.InstructionNode;
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
	
	static Graph<InstructionNode, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

	public static void main(String[] args) throws FileNotFoundException {
		//[TO TEST]
		loadGraph("./input/fir-O2.txt");
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
	private static void loadGraph(String fileName) {
		File f = new File(fileName);
		if (f.isFile() && f.canRead()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				try {
					MicroblazeParser trace = new MicroblazeParser(fis);
					try {
						SimpleNode root = trace.Expression(); // returns reference to root node
						System.out.println("HI!");
						 //root.dump(""); // prints the tree on the screen

						traceToGraph2(root);

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
	}

	/**
	 * Takes the contents of the graph generated by javacc and creates the jgrapht
	 * Graph
	 * 
	 * @param fileName root node of javacc graph created by the parser
	 * 
	 */
	private static void traceToGraph(SimpleNode root) {
		int numChildren = root.jjtGetNumChildren();
		HashMap<String, InstructionNode> lastToAlter = new HashMap<String, InstructionNode>();
		for (int i = 0; i < numChildren; i++) {
			String address;
			String instruction;

			Node javaccNode = root.jjtGetChild(i);
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

		}
	}

	/**
	 * Exports Graph<InstructionNode, DefaultEdge> graph as a DOT file
	 * for vizualization 
	 * https://stackoverflow.com/questions/16998608/jgrapht-export-to-dot-file
	 */

	
	private static void visualizeGraph() {
		DOTExporter<InstructionNode,DefaultEdge>exporter = new DOTExporter<>(v->"A"+v.getAddress());
		exporter.setVertexAttributeProvider((v)->{
			Map<String, Attribute> map=new LinkedHashMap<>();
			map.put("label", DefaultAttribute.createAttribute(v.getAddress() + " " + v.getInstruction()));return map;});
		Writer writer=new StringWriter();
		exporter.exportGraph(graph,writer);
		//System.out.println(writer.toString());
		try {
			FileWriter myWriter = new FileWriter("output.dot");
			myWriter.write(writer.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		File f = new File("output.dot");
		try {

			Renderer g = Graphviz.fromFile(f).render(Format.PNG);
			File f2 = new File("output.png");
			g.toFile(f2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}




	private static void traceToGraph2(SimpleNode root) {
		int numChildren = root.jjtGetNumChildren();

		HashMap<String, InstructionNode> lastToAlter = new HashMap<String, InstructionNode>();
		System.out.println(numChildren);
		for (int i = 0; i < numChildren; i++) {
			String address;
			String instruction;

			Node javaccNode = root.jjtGetChild(i);

			if (javaccNode instanceof SimpleNode) {
				SimpleNode javaccSimpleNode = ((SimpleNode) javaccNode);
				SimpleNode previous = ((SimpleNode) previousNode);

				address = javaccSimpleNode.getAddress();
				instruction = javaccSimpleNode.getInstruction();

				InstructionNode vertex = new InstructionNode(address, instruction);
				graph.addVertex(vertex);

				if(javaccSimpleNode.getAddress()!=null){
					lastToAlter.put(javaccSimpleNode.getAddress(), vertex);
				}
				

			}
		}
		System.out.println(lastToAlter.size());
	}
}