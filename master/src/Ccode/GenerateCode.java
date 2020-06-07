package Ccode;

import Ccode.CodeBlocks.*;
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
        CodeBlock codeBlock;
        switch (node.getInstruction()){
            case "START":
                 codeBlock = new CodeRoot();
                break;
            case "addi":
                  codeBlock = new CodeAddi(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getLiteral()));
                break;
            case "addik":
                 codeBlock = new CodeAddik(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getRegister3()));
                break;
            case "addk":
                 codeBlock = new CodeAddk(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getRegister3()));
                break;
            case "beqid":
                 codeBlock = new CodeBeqid(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getLiteral()));
                break;
            case "bgeid":
                 codeBlock = new CodeBgeid(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getLiteral()));
                break;
            case "bleid":
                 codeBlock = new CodeBleid(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getLiteral()));
                break;
            case "bneid":
                 codeBlock = new CodeBneid(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getLiteral()));
                break;
            case "brai":
                 codeBlock = new CodeBrai(Integer.parseInt(node.getLiteral()));
                break;
            case "brlid":
                 codeBlock = new CodeBrlid(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getLiteral()));
                break;
            case "bslli":
                 codeBlock = new CodeBslli(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getLiteral()));
                break;
            case "lw":
                 codeBlock = new CodeLw(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getRegister3()));
                break;
            case "lwi":
                 codeBlock = new CodeLwi(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getLiteral()));
                break;
            case "mul":
                 codeBlock = new CodeMul(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getRegister3()));
                break;
            case "or":
                 codeBlock = new CodeOr(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getRegister3()));
                break;
            case "rsubk":
                 codeBlock = new CodeRsubk(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getRegister3()));
                break;
            case "sw":
                 codeBlock = new CodeSw(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getRegister3()));
                break;
            case "swi":
                 codeBlock = new CodeSwi(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getLiteral()));
                break;
            case "xori":
                 codeBlock = new CodeXori(Integer.parseInt(node.getRegister1()),Integer.parseInt(node.getRegister2()),Integer.parseInt(node.getLiteral()));
                break;
            case "END":
                 codeBlock = new CodeEnd();
                break;
            default:
                codeBlock = new CodeBlock(0,0,0,0);
                break;
        }
        return codeBlock;
    }

    private CfgNode nextNode(CfgNode node) {
        List<PathEdge> outgoingEdges = new ArrayList<PathEdge>(cfGraph.outgoingEdgesOf(node));
        if(outgoingEdges.size() == 1)
            return cfGraph.getEdgeTarget(outgoingEdges.get(0));
        else{



        }
        return node;
    }


}
