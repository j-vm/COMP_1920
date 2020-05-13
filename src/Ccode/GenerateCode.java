package Ccode;

import nodes.CfgNode;
import nodes.PathEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;

public class GenerateCode {

    static Graph<CfgNode, PathEdge> cfGraph = new DefaultDirectedGraph<>(PathEdge.class);
    static String outputFileName;

    public GenerateCode(Graph<CfgNode, PathEdge> cfGraph, String outputFileName) {
        this.cfGraph = cfGraph;
        this.outputFileName = outputFileName;
    }


    /*try {
			FileWriter myWriter = new FileWriter("output.dot");
			myWriter.write(writer.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		*/
}
