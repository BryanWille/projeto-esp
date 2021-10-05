package projeto;

import java.util.ArrayList;

public class testeArray2d {
    public static void main(String[] args){
        int vertexCount = 3;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i=0; i < vertexCount; i++) {
            graph.add(new ArrayList());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(1).add(0);
        graph.get(2).add(1);
        graph.get(0).add(2);
        System.out.println(graph);

    }
}
