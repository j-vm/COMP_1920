package javacc.nodes;

import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.List;

public class PathEdge
        extends
        DefaultEdge
{

    private List<Integer> path = new ArrayList<Integer>();

    public PathEdge(int decisionId)
    {
        path.add(decisionId);
    }

    public PathEdge(){}

    public void addPath(int decisionId)
    {
        path.add(decisionId);
    }

    public boolean isPathEmpty(){
        return path.isEmpty();
    }

    @Override
    public String toString()
    {
        if(path.size()==0) return "";
        if(path.size()>10){
            String string = new String();
            string = "[";
            for (int i = 0; i < 10; i++) {
                string += path.get(i).toString() + ',';
            }
            string += "...]";
            return string;
        }
        return path.toString();
    }

}
