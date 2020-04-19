import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream fis = new FileInputStream(args[0]);

		MicroblazeParser trace = new MicroblazeParser(fis);
		
		try {
		SimpleNode root = trace.Expression(); // returns reference to root node
        	
		root.dump(""); // prints the tree on the screen
		
		}catch(Exception e) {
			System.err.print(e);
		}
	}
	
}