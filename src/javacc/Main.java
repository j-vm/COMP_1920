
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import javacc.nodes.InstructionNode;
import jdk.jshell.execution.LoaderDelegate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	private Graph<InstructionNode, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

	public Graph<InstructionNode,DefaultEdge> getGraph() {
		return this.graph;
	}

	public void setGraph(Graph<InstructionNode,DefaultEdge> graph) {
		this.graph = graph;
	}

	public static void main(String[] args) throws FileNotFoundException {
		checkArgs(args);
		loadGraph(args[0]);
	}

	/**
	 * Checks program parameters and provides "Usage" prompt if wrong number
	 * 
	 * @param args parameters to be checked
	 */
	private static void checkArgs(String[] args) {
		if(args.length != 1){
			System.out.println("Usage: Main <filename>");
        		System.exit(0);
		}
	}

	/**
	 * Opens file, parses its content with jjtree and javacc, and builds a
	 * graph (Graph<InstructionNode, DefaultEdge> graph) based on the work: 
	 * 	"Limits of Parallelism Using Dynamic Dependency Graphs" by:
	 * 		Jonathan Mak
	 * 		University of Cambridge Computer Laboratory
	 * 		William Gates Building, 15 JJ Thomson Avenue
	 * 		Cambridge CB3 0FD, United Kingdom
	 * 		Jonathan.Mak@cl.cam.ac.uk
	 * 		&
	 * 		Alan Mycroft
	 * 		University of Cambridge Computer Laboratory
	 * 		William Gates Building, 15 JJ Thomson Avenue
	 * 		Cambridge CB3 0FD, United Kingdom~
	 * 		Alan.Mycroft@cl.cam.ac.uk
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
						 
						//root.dump(""); // prints the tree on the screen
						
					}catch(Exception e) {
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
}