import Ccode.GenerateCode;
import javacc.MicroblazeParser;
import javacc.Node;
import javacc.SimpleNode;
import nodes.CfgNode;
import nodes.InstructionNode;
import nodes.PathEdge;
import nodes.RegisterEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DirectedPseudograph;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.dot.DOTExporter;

import java.io.*;
import java.util.*;

import static javacc.MicroblazeParser.Expression;

public class Main {

	static Graph<CfgNode, PathEdge> cfGraph = new DefaultDirectedGraph<>(PathEdge.class);
	static Graph<InstructionNode, RegisterEdge> graph = new DirectedPseudograph<>(RegisterEdge.class);
	static Map <String, String> controlFlowEdges = new HashMap<>();

	static private int FUNCTION_ISOLATION = 6;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Write the name of the file you want to analyze: ");
		String filename = scanner.next();
		System.out.println("Say the mode to analyze the file:\n 1- Control Flow Graph(CFG) dot;\n 2- Control and Data Flow Graph(CDFG) dot \n 3- Simple C code generation" +
				"\n 4- Previous and C code with labels \n 5- Previous and C code with final Labels \n 6- Final C code \n 7- Logging of memory" );
		String mode = scanner.next();

		CfgNode rootnode =  loadGraph("./input/" + filename+"-O2.txt");


		switch (mode){
			case "1":
				visualizeCfg("output/" + filename +"/CFG.dot");
				break;
			case "2":
				visualizeGraph("output/" + filename +"/CDFG.dot");
				break;
			case "3":
				GenerateCode code = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v1.c", true, 4);
				code.exportCode();
				break;
			case "4":
				GenerateCode code2 = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v2.c", false, 4);
				code2.exportCode();
				break;
			case "5":
				GenerateCode code3 = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v2.c", false, 4);
				code3.exportCode();
				code3.filterLabels("output/"+ filename+ "/v3.c");
				break;
			case "6":
				GenerateCode code4 = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v2.c", false, 4);
				code4.exportCode();
				code4.filterLabels("output/"+ filename+"/v4.c");
				code4.gotoElimination("output/"+ filename+"/v4.c");
				break;
			case "7":
				System.out.println("Feature not yet implemented!");
				break;
			default:
				System.out.println("Wrong choice, please select 1,2,3,4,5,6 or 7!");
				break;
		}



		//[TO TEST]
		//CfgNode rootnode =  loadGraph("./input/autcor-O2.txt");
		//GenerateCode code = new GenerateCode(cfGraph,rootnode,"output/output.c", true);
		//GenerateCode code2 = new GenerateCode(cfGraph,rootnode,"output/autcor/v1.c", false, 4);
		//code.exportCode();
		//code2.exportCode();
		//code2.filterLabels("output/autcor/v2.c");
		//code2.gotoElimination("output/autcor/v3.c");
		//loadGraphFromTrace("./input/fir-O2.txt");
		//visualizeGraph();
		// [PROPER USE]
		//checkArgs(args);
		//loadGraph(args[0]);
		//visualizeGraph();
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
						SimpleNode root = Expression(); // returns reference to root node
						 //root.dump(""); // prints the tree on the screen

						rootNode = traceToCFG(root);
						traceToGraph(root);

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
	 * Exports Graph<InstructionNode, DefaultEdge> graph as a DOT file
	 * for vizualization 
	 * https://stackoverflow.com/questions/16998608/jgrapht-export-to-dot-file
	 */

	
	private static void visualizeCfg(String outputFileName) {
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
			FileWriter myWriter = new FileWriter(outputFileName);
			myWriter.write(writer.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static void visualizeGraph(String outputFileName) {
		DOTExporter<InstructionNode, RegisterEdge>exporter = new DOTExporter<>((v->"A"+v.getAddress()));
		exporter.setVertexAttributeProvider((v)->{
			Map<String, Attribute> map=new LinkedHashMap<>();
			map.put("label", DefaultAttribute.createAttribute(v.toString()));
			return map;});
		exporter.setEdgeAttributeProvider((e)->{
			Map<String, Attribute> map=new LinkedHashMap<>();
			if(e.isCfEdge()){
				map.put("color", DefaultAttribute.createAttribute("red"));
				map.put("penwidth", DefaultAttribute.createAttribute("5"));
			}else{
				map.put("label", DefaultAttribute.createAttribute(e.toString()));
			}
			return map;});
		Writer writer=new StringWriter();
		exporter.exportGraph(graph,writer);

		System.out.println(writer.toString());
		try {
			FileWriter myWriter = new FileWriter(outputFileName);
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
						controlFlowEdges.put(lastAddress, address);
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
						controlFlowEdges.put(lastAddress, address);
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



	private static void traceToGraph(SimpleNode root) {
		int numChildren = root.jjtGetNumChildren();
		HashMap<String, InstructionNode> nodes = new HashMap<String, InstructionNode>();
		HashMap<String, InstructionNode> lastToAlter = new HashMap<String, InstructionNode>();
		HashMap<String, InstructionNode> literalNodes = new HashMap<String, InstructionNode>();
		for (int i = parseFunction(root); i < numChildren; i++) {
			String address;
			String instruction;
			System.out.println(numChildren);
			Node javaccNode = root.jjtGetChild(i);
			if (javaccNode instanceof SimpleNode) {
				SimpleNode javaccSimpleNode = ((SimpleNode) javaccNode);
				address = javaccSimpleNode.getAddress();
				instruction = javaccSimpleNode.getInstruction();
				InstructionNode vertex;
				if (!nodes.containsKey(address)) {
					vertex = new InstructionNode(address, instruction);
					graph.addVertex(vertex);
					nodes.put(address, vertex);
				}else{
					vertex = nodes.get(address);
				}

				//adding destination operand to HashMap
				if(javaccSimpleNode.getRegister1()!=null){
					lastToAlter.put(javaccSimpleNode.getRegister1(), vertex);
				}

				//Ingoing Edge (source operand a)
				if(javaccSimpleNode.getRegister2()!=null){
					if(lastToAlter.containsKey(javaccSimpleNode.getRegister2())){
						if (graph.getAllEdges(lastToAlter.get(javaccSimpleNode.getRegister2()),
								vertex).size() == 0) {
							graph.addEdge(
									lastToAlter.get(javaccSimpleNode.getRegister2()),
									vertex).setRegName(javaccSimpleNode.getRegister2());
						}
					}
				}

				//Ingoing Edge (source operand b)
				if(javaccSimpleNode.getRegister3()!=null){
					if(lastToAlter.containsKey(javaccSimpleNode.getRegister3())){
						if (graph.getAllEdges(lastToAlter.get(javaccSimpleNode.getRegister3()),
								vertex).size() == 0){
							graph.addEdge(
									lastToAlter.get(javaccSimpleNode.getRegister3()),
									vertex).setRegName(javaccSimpleNode.getRegister3());
						}
					}
				}

				//Literals
				if(javaccSimpleNode.getLiteral()!=null){
					InstructionNode newVertex;
					if(literalNodes.containsKey(address)){
						newVertex = literalNodes.get(address);
					}else {
						newVertex = new InstructionNode(
								"LITERAL" + address,
								javaccSimpleNode.getLiteral());
						graph.addVertex(newVertex);
						graph.addEdge(newVertex, vertex).setRegName("lit");
						literalNodes.put(address, newVertex);
					}
					newVertex.addLiterals(Integer.parseInt(javaccSimpleNode.getLiteral()));
				}
			}
		}

		Iterator it = controlFlowEdges.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			graph.addEdge(nodes.get(pair.getKey()),nodes.get(pair.getValue())).setCfEdge(true);
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
}

