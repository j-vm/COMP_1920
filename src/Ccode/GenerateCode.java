package Ccode;

import Ccode.CodeBlocks.CodeRoot;
import nodes.CfgNode;
import nodes.PathEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GenerateCode {

    static Graph<CfgNode, PathEdge> cfGraph = new DefaultDirectedGraph<>(PathEdge.class);
    static CfgNode rootNode;
    static String outputFileName;

    public GenerateCode(Graph<CfgNode, PathEdge> cfGraph, CfgNode rootNode, String outputFileName) {
        this.cfGraph = cfGraph;
        this.rootNode = rootNode;
        this.outputFileName = outputFileName;
    }

    public void exportCode() throws IOException {
        FileWriter fileWriter = new FileWriter(outputFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        var node = rootNode;
        while (true){
            var codeBlock = generateCodeBlock(node);
            printWriter.print(codeBlock.output() + "\n");
            if (node.getInstruction() == "END") break;
            else node = nextNode(node);
        }

        //printWriter.print("Some String");
        //printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();

    }

    private CodeBlock generateCodeBlock(CfgNode node) {
        switch (node.getInstruction()){
            case "START":
                CodeRoot codeBlock = new CodeRoot();
                break;
            case "addi":
                break;
            case "addik":
                break;
            case "..":
                break;
            case "...":
                break;
            case "END":
                break;
            default:
                break;
        }
        return codeBlock;
    }

    private CfgNode nextNode(CfgNode node) {
        //TODO: return correct unique, connected, and priority node
        List<PathEdge> outgoingEdges = new ArrayList<PathEdge>(cfGraph.outgoingEdgesOf(node));
        if(outgoingEdges.size() == 1)
            return cfGraph.getEdgeTarget(outgoingEdges.get(0));
        else{



        }
        return node;
    }


}
