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
import java.util.HashMap;
import java.util.List;

public class GenerateCode {

    static Graph<CfgNode, PathEdge> cfGraph = new DefaultDirectedGraph<>(PathEdge.class);
    static CfgNode rootNode;
    static String outputFileName;
    private int decision; //temporary way to manage loops
    private boolean mode;
    private boolean newNode = false;


    public GenerateCode(Graph<CfgNode, PathEdge> cfGraph, CfgNode rootNode, String outputFileName, boolean mode) {
        GenerateCode.cfGraph = cfGraph;
        GenerateCode.rootNode = rootNode;
        GenerateCode.outputFileName = outputFileName;
        this.decision = 0;
        this.mode = mode;
    }

    public void exportCode() throws IOException {

        HashMap<CfgNode, Boolean> nodes= new HashMap<CfgNode, Boolean>();
        boolean firstNode = true;
        FileWriter fileWriter = new FileWriter(outputFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String labeler;
        var node = rootNode;
        while (true){
            if(mode){
                var codeBlock = generateCodeBlock(node);
                printWriter.print(codeBlock.output() + "\n");
            }
            else{
                if(!nodes.containsKey(node)){
                    var codeBlock = generateCodeBlock(node);
                    if(firstNode){printWriter.print(codeBlock.output() + "\n"); firstNode = false;}
                    else {
                        labeler = node.getAddress();
                        printWriter.print(labeler+":\n\t" + codeBlock.output() + "\n");
                    }
                    nodes.put(node, true);
                    newNode = true;
                }
            }
            if (node.getInstruction() == "END") break;
            else node = nextNode(node, printWriter);
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
                  codeBlock = new CodeAddi(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getLiteral()));
                break;
            case "addik":
                 codeBlock = new CodeAddik(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getLiteral()));
                break;
            case "addk":
                 codeBlock = new CodeAddk(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getRegister3()));
                break;
            case "beqid":
                 codeBlock = new CodeBeqid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()));
                break;
            case "bgeid":
                 codeBlock = new CodeBgeid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()));
                break;
            case "bleid":
                 codeBlock = new CodeBleid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()));
                break;
            case "bneid":
                 codeBlock = new CodeBneid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()));
                break;
            case "brai":
                 codeBlock = new CodeBrai(registerToInt(node.getLiteral()));
                break;
            case "brlid":
                 codeBlock = new CodeBrlid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()));
                break;
            case "bslli":
                 codeBlock = new CodeBslli(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getLiteral()));
                break;
            case "lw":
                 codeBlock = new CodeLw(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getRegister3()));
                break;
            case "lwi":
                 codeBlock = new CodeLwi(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getLiteral()));
                break;
            case "mul":
                 codeBlock = new CodeMul(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getRegister3()));
                break;
            case "or":
                 codeBlock = new CodeOr(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getRegister3()));
                break;
            case "rsubk":
                 codeBlock = new CodeRsubk(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getRegister3()));
                break;
            case "sw":
                 codeBlock = new CodeSw(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getRegister3()));
                break;
            case "swi":
                 codeBlock = new CodeSwi(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getLiteral()));
                break;
            case "xori":
                 codeBlock = new CodeXori(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getLiteral()));
                break;
            case "imm":
                codeBlock = new CodeImm(registerToInt(node.getLiteral()));
                break;
            case "rtsd":
                codeBlock = new CodeRtsd(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()));
                break;
            case "cmp":
                codeBlock = new CodeCmp(registerToInt(node.getRegister1()),registerToInt(node.getRegister2()),registerToInt(node.getRegister3()));
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

    private int registerToInt(String register) {
        if(register.charAt(0) == 'r') return Integer.parseInt(register.substring(1));
        else return Integer.parseInt(register);
    }

    private CfgNode nextNode(CfgNode node, PrintWriter printWriter) {
        //TODO: return correct unique, connected, and priority node
        List<PathEdge> outgoingEdges = new ArrayList<PathEdge>(cfGraph.outgoingEdgesOf(node));
        if(cfGraph.incomingEdgesOf(node).size()>1) {
            if(mode) printWriter.println("// ------- wile(CONDITION) -------");
            else if(newNode){
                printWriter.println("// ------- wile(CONDITION) -------");
                newNode = false;
            }
        }
        if(outgoingEdges.size() == 1)
            return cfGraph.getEdgeTarget(outgoingEdges.get(0));
        else{
            for (PathEdge outgoingEdge: outgoingEdges) {
                if(!outgoingEdge.isPathEmpty()){
                    if(outgoingEdge.pathContains(decision)){
                        decision++;
                        return cfGraph.getEdgeTarget(outgoingEdge);
                    }
                }
            }
            for (PathEdge outgoingEdge: outgoingEdges) {
                if(outgoingEdge.isPathEmpty()){
                    return cfGraph.getEdgeTarget(outgoingEdges.get(0));
                }
            }
        }
        System.err.println("ERROR - Couldn't traverse cfg while generating code");
        return cfGraph.getEdgeTarget(outgoingEdges.get(0));
    }



}
