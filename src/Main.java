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
	static Map<String, List<String>> controlFlowEdges = new HashMap<String, List<String>>();

	static private int FUNCTION_ISOLATION = 6;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Write the name of the file you want to analyze ( fir, autcor, dotprod) : ");
		String filename = scanner.next();

		while (!filename.equals("fir") && !filename.equals("dotprod") && !filename.equals("autcor")){
			System.out.println("File doesnt exist!\n Choose from fir , dotprod or autcor!\n");
			System.out.println("Write the name of the file you want to analyze ( fir, autcor, dotprod) : ");
			filename  = scanner.next();
		}


		System.out.println("Provide the isolation degree you want (-1 for the default value)");
		String isolation = scanner.next();
		if(!isolation.equals("-1"))
			FUNCTION_ISOLATION = Integer.parseInt(isolation);

		System.out.println("Say the mode to analyze the file:\n 1- Control Flow Graph(CFG) dot;\n 2- Control and Data Flow Graph(CDFG) dot \n 3- Simple C code generation" +
				"\n 4- Previous and C code with labels \n 5- Previous and C code with final Labels \n 6- Final C code \n 7- Logging of memory" );
		String mode = scanner.next();

		while (!mode.equals("1") && !mode.equals("2") && !mode.equals("3") && !mode.equals("4") && !mode.equals("5") && !mode.equals("6") && !mode.equals("7")){
			System.out.println("Wrong mode choise!\n Choose from 1 to 7!\n " +
					"Say the mode to analyze the file:");
			mode = scanner.next();
		}

		File file = new File("output/"+filename);
		file.mkdir();

		CfgNode rootnode =  loadGraph("./input/" + filename + ".txt");
		String numInputs;

		switch (mode){

			case "1":
				visualizeCfg("output/" + filename +"/CFG.dot");
				System.out.println("Success! File at output/" + filename + "/CFG.dot");
				break;
			case "2":
				visualizeGraph("output/" + filename +"/CDFG.dot");
				System.out.println("Success! File at output/" + filename + "/CDFG.dot");
				break;
			case "3":
				System.out.println("Provide the number of inputs of the isolated function you want to analyze:");
				numInputs = scanner.next();

				GenerateCode code = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v1.c", true, Integer.parseInt(numInputs));
				code.exportCode();

				System.out.println("Success! File at output/" + filename + "/v1.c");
				break;
			case "4":
				System.out.println("Provide the number of inputs of the isolated function you want to analyze:");
				numInputs = scanner.next();

				GenerateCode code2 = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v2.c", false, Integer.parseInt(numInputs));
				code2.exportCode();
				System.out.println("Success! File at output/" + filename + "/v2.c");
				break;
			case "5":
				System.out.println("Provide the number of inputs of the isolated function you want to analyze:");
				numInputs = scanner.next();

				GenerateCode code3 = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v2.c", false, Integer.parseInt(numInputs));
				code3.exportCode();
				code3.filterLabels("output/"+ filename+ "/v3.c");
				System.out.println("Success! File at output/" + filename + "/v3.c");
				break;
			case "6":
				System.out.println("Provide the number of inputs of the isolated function you want to analyze:");
				numInputs = scanner.next();

				GenerateCode code4 = new GenerateCode(cfGraph,rootnode,"output/" + filename +"/v2.c", false, Integer.parseInt(numInputs));
				code4.exportCode();
				code4.filterLabels("output/"+ filename+"/v4.c");
				code4.gotoElimination("output/"+ filename+"/v4.c");
				System.out.println("Success! File at output/" + filename + "/v4.c");
				break;
			case "7":
				System.out.println("Feature not yet implemented!");
				break;
			default:
				System.out.println("Wrong choice, please select 1,2,3,4,5,6 or 7!");
				break;
		}
	}

	private static CfgNode loadGraph(String fileName) {
		File f = new File(fileName);
		CfgNode rootNode = null;
		if (f.isFile() && f.canRead()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				try {
					MicroblazeParser trace = new MicroblazeParser(fis);
					try {
						SimpleNode root = Expression();


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

		try {
			FileWriter myWriter = new FileWriter(outputFileName);
			myWriter.write(writer.toString());
			myWriter.close();
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
			if (v.getliteralNode()) {
				map.put("shape", DefaultAttribute.createAttribute("polygon"));
				map.put("sides", DefaultAttribute.createAttribute("4"));
			}
			return map;});
		exporter.setEdgeAttributeProvider((e)->{
			Map<String, Attribute> map=new LinkedHashMap<>();
			switch (e.isCfEdge()){
				case 0:
					map.put("label", DefaultAttribute.createAttribute(e.toString()));
					if(e.getReg().equals("A")){
						map.put("color", DefaultAttribute.createAttribute("blue"));
					}else if(e.getReg().equals("B")){
						map.put("color", DefaultAttribute.createAttribute("green"));
					}
					break;
				case 1:
					map.put("color", DefaultAttribute.createAttribute("red"));
					map.put("penwidth", DefaultAttribute.createAttribute("5"));
					break;
				default:
					break;
			}

			return map;});
		Writer writer=new StringWriter();
		exporter.exportGraph(graph,writer);

		try {
			FileWriter myWriter = new FileWriter(outputFileName);
			myWriter.write(writer.toString());
			myWriter.close();
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

		int decisionPath = 0;

		for (int i = parseFunction(root); i < numChildren; i++) {
			String address;
			Node javaccNode = root.jjtGetChild(i);
			if (javaccNode instanceof SimpleNode) {
				SimpleNode javaccSimpleNode = ((SimpleNode) javaccNode);
				address = javaccSimpleNode.getAddress();
				if(lastAddress != null)
					if(!controlFlowEdges.containsKey(lastAddress)){
						List<String> destAddresses = new ArrayList<>();
						destAddresses.add(address);
						controlFlowEdges.put(lastAddress, destAddresses);
					}else{
						List<String> destAddresses = controlFlowEdges.get(lastAddress);
						if (!destAddresses.contains(address)){
							destAddresses.add(address);
						}
					}
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

	private static void traceToGraph(SimpleNode root) {
		int numChildren = root.jjtGetNumChildren();
		HashMap<String, InstructionNode> nodes = new HashMap<String, InstructionNode>();
		HashMap<String, InstructionNode> lastToAlter = new HashMap<String, InstructionNode>();
		HashMap<String, InstructionNode> literalNodes = new HashMap<String, InstructionNode>();
		for (int i = parseFunction(root); i < numChildren; i++) {
			String address;
			String instruction;
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
				RegisterEdge edge;
				//Ingoing Edge (source operand a)
				if(javaccSimpleNode.getRegister2()!=null){
					if(lastToAlter.containsKey(javaccSimpleNode.getRegister2())){
						if (graph.getAllEdges(lastToAlter.get(javaccSimpleNode.getRegister2()),
								vertex).size() == 0) {
							edge = graph.addEdge(
									lastToAlter.get(javaccSimpleNode.getRegister2()),
									vertex);
							edge.setRegName(javaccSimpleNode.getRegister2());
							edge.setReg(RegisterEdge.InputReg.A);
						}
					}
				}

				//Ingoing Edge (source operand b)
				if(javaccSimpleNode.getRegister3()!=null){
					if(lastToAlter.containsKey(javaccSimpleNode.getRegister3())){
						if (graph.getAllEdges(lastToAlter.get(javaccSimpleNode.getRegister3()),
								vertex).size() == 0){
							edge = graph.addEdge(
									lastToAlter.get(javaccSimpleNode.getRegister3()),
									vertex);

							edge.setRegName(javaccSimpleNode.getRegister2());
							edge.setReg(RegisterEdge.InputReg.B);
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
			List<String> addressList = (List<String>) pair.getValue();
			for(String address : addressList){
				graph.addEdge(nodes.get(pair.getKey()),nodes.get(address)).setCfEdge(1);
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
}

