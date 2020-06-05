package Ccode;

import Ccode.CodeBlocks.*;
import nodes.CfgNode;
import nodes.PathEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateCode {

    static Graph<CfgNode, PathEdge> cfGraph = new DefaultDirectedGraph<>(PathEdge.class);
    static CfgNode rootNode;
    static String outputFileName;
    static String outputFileName2;
    static String outputFileName3;
    private int decision;
    private boolean mode;
    private boolean newNode = false;
    private List<Integer> labels = new ArrayList<>();
    private List<Integer> jmps = new ArrayList<>();
    private int numOfInputs;



    public GenerateCode(Graph<CfgNode, PathEdge> cfGraph, CfgNode rootNode, String outputFileName, boolean mode, int numOfInputs) {
        GenerateCode.cfGraph = cfGraph;
        GenerateCode.rootNode = rootNode;
        GenerateCode.outputFileName = outputFileName;
        this.decision = 0;
        this.mode = mode;
        this.numOfInputs = numOfInputs;
    }

    public void exportCode() throws IOException {

        HashMap<CfgNode, Boolean> nodes= new HashMap<>();
        boolean firstNode = true;
        FileWriter fileWriter = new FileWriter(outputFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        CodeBlock delayed = null;
        String delayedAddress = null;
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
                    if(firstNode || node.getInstruction().equals("END")){printWriter.print(codeBlock.output() + "\n"); firstNode = false;}
                    else {
                        if(codeBlock instanceof CodeBeqid ||
                                codeBlock instanceof CodeBgeid ||
                                codeBlock instanceof CodeBleid ||
                                codeBlock instanceof CodeBneid ||
                                codeBlock instanceof CodeBrlid){
                            delayed = codeBlock;
                            delayedAddress = Integer.toString(parseAddress(node.getAddress()));
                        }else {
                            labeler = "L" + parseAddress(node.getAddress());
                            printWriter.print(labeler + ":\n\t" + codeBlock.output() + "\n");
                            if(delayed != null){
                                labeler = "L" + delayedAddress;
                                printWriter.print(labeler + ":\n\t" + delayed.output() + "\n");
                                delayed = null;
                                if(codeBlock instanceof CodeRtsd){break;}
                            }
                        }
                    }
                    nodes.put(node, true);
                    newNode = true;
                }
            }
            if (node.getInstruction().equals("END")) break;
            else node = nextNode(node, printWriter);
        }

        //printWriter.print("Some String");
        //printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);

        printWriter.close();

    }

    public void filterLabels(String newOutputFileName) throws IOException {
        System.out.println(outputFileName);
        BufferedReader reader = new BufferedReader(new FileReader(outputFileName));
        outputFileName2 = newOutputFileName;
        try{
            String line = "", code = "";
            while((line = reader.readLine()) != null)
            {
                code += line + "\r\n";
            }
            reader.close();

            String gotoRegex = "goto L([0-9]+)";
            Pattern pattern = Pattern.compile(gotoRegex);
            Matcher matcher = pattern.matcher(code);
            while(matcher.find()){
                jmps.add(Integer.parseInt(matcher.group(1)));
            }
            String labelRegex = "L([0-9]+):\\s";
            Pattern labelPattern = Pattern.compile(labelRegex);
            Matcher labelMatcher = labelPattern.matcher(code);

            while(labelMatcher.find()){
                labels.add(Integer.parseInt(labelMatcher.group(1)));
            }

            labels.removeAll(jmps);

            for (int label: labels) {
                code = code.replaceAll("L"+ label +":\\s\\s", "");
            }

            FileWriter writer = new FileWriter(newOutputFileName);
            writer.write(code);writer.close();

        } catch (IOException e) {
            reader.close();
            e.printStackTrace();
        }
    }



    private static int parseAddress(String address){
        String[] tokens = address.split("x");
        String hex = tokens[1];

        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }



    public void gotoElimination(String newOutputFileName) throws IOException {
        File inputFile = new File(outputFileName2);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line = "", oldText = "";
        while((line = reader.readLine()) != null)
        {
            oldText += line + "\r\n";
        }
        reader.close();
        String newText = removeUnconditionalGotos(oldText);
        newText = structureCode(newText);
        FileWriter writer = new FileWriter(newOutputFileName);
        writer.write(newText);writer.close();
    }

    public String removeUnconditionalGotos(String oldText) throws IOException {
        return oldText.replaceAll("goto (L[0-9]+);\\r\\n\\1:", "//removed unconditional goto");
    }

    public String structureCode(String oldText) throws IOException {
        List<MatchedGotoLabelPair> pairInfo = new ArrayList<>();
        String gotoRegex = "if \\((.+)\\) \\{\\s+goto (L[0-9]+);\\s+}";
        Pattern pattern = Pattern.compile(gotoRegex);
        Matcher matcher = pattern.matcher(oldText);

        while(matcher.find()){
            String label = matcher.group(2)+":";
            Pattern labelPattern = Pattern.compile(label);
            Matcher labelMatcher = labelPattern.matcher(oldText);

            labelMatcher.find();
            pairInfo.add(new MatchedGotoLabelPair(matcher.start(), matcher.end(),
                            labelMatcher.start(), labelMatcher.end(),
                            matcher.group(1), matcher.group(2), matcher.group(), labelMatcher.group()));

        }
        calcInternalGoto(pairInfo, oldText);
        int gotoPriority = 0;
        while (pairInfo.size() != 0){
            boolean changed = false;
            for (MatchedGotoLabelPair pair:pairInfo) {
                if(pair.getMatchesInside() == gotoPriority){
                    oldText = structureBlock(pair, oldText);
                    pairInfo.remove(pair);
                    calcInternalGoto(pairInfo, oldText);
                    changed = true;
                    break;
                }
            }
            if(changed){
                gotoPriority=0;
            }
            else{
                gotoPriority++;
            }
        }
        for (MatchedGotoLabelPair pair:pairInfo) {
            System.out.println(pair.getMatchesInside());
        }
        return oldText;
    }

    private String structureBlock(MatchedGotoLabelPair pair, String oldText) {
        String newText;
        switch (pair.getMatchesInside()){
            case 0:
                if(pair.isGotoBeforeLabel()){
                    newText = oldText.replace(
                            pair.getGotoSubstring(),
                            "\nif(!(" + pair.getConditional() + ")){\n");
                    newText = newText.replace(
                            pair.getLabelSubstring(),
                            "\n}\n");
                }
                else{
                    newText = oldText.replace(
                            pair.getLabelSubstring(),
                            "\ndo {\n");
                    newText = newText.replace(
                            pair.getGotoSubstring(),
                            "\n} while( " + pair.getConditional() + ");\n");
                }
                break;
            default:
                System.out.println(pair.getMatchesInside());
                System.err.println("Maximum goto complexity reached. Not handling interlocking goto statements");
                newText = oldText;

        }
        return newText;
    }

    private void calcInternalGoto(List <MatchedGotoLabelPair> pairs, String text){
        for (MatchedGotoLabelPair pair:pairs) {
            String internalCode;
            if(pair.isGotoBeforeLabel())
                internalCode = text.substring(
                        text.indexOf(pair.getGotoSubstring())+pair.getGotoSubstring().length(),
                        text.indexOf(pair.getLabelSubstring()));
            else
                internalCode = text.substring(
                        text.indexOf(pair.getLabelSubstring())+pair.getLabelSubstring().length(),
                        text.indexOf(pair.getGotoSubstring()));

            String gotoRegex = "goto L[0-9]+";
            Pattern pattern = Pattern.compile(gotoRegex);
            Matcher matcher = pattern.matcher(internalCode);
            int nGotos = (int)matcher.results().count();

            String labelRegex = "L[0-9]+:";
            Pattern labelPattern = Pattern.compile(labelRegex);
            Matcher labelMatcher = labelPattern.matcher(internalCode);
            int nLabels = (int)labelMatcher.results().count();

            pair.setMatchesInside(nGotos + nLabels);
        }
    }

    private CodeBlock generateCodeBlock(CfgNode node) {
        CodeBlock codeBlock;
        switch (node.getInstruction()){
            case "START":
                 codeBlock = new CodeRoot(this.numOfInputs);
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
                 codeBlock = new CodeBeqid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()),parseAddress(node.getAddress()));
                break;
            case "bgeid":
                 codeBlock = new CodeBgeid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()),parseAddress(node.getAddress()));
                break;
            case "bleid":
                 codeBlock = new CodeBleid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()),parseAddress(node.getAddress()));
                break;
            case "bneid":
                 codeBlock = new CodeBneid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()),parseAddress(node.getAddress()));
                break;
            case "brai":
                 codeBlock = new CodeBrai(registerToInt(node.getLiteral()),parseAddress(node.getAddress()));
                break;
            case "brlid":
                 codeBlock = new CodeBrlid(registerToInt(node.getRegister1()),registerToInt(node.getLiteral()),parseAddress(node.getAddress()));
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
