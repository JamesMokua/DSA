package graphs;

import java.util.ArrayList;

public class AdjacencyList {
    public static class GraphNode {
        public String name;
        public int index;

        public ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    public ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public AdjacencyList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }
    // For printing Graph to the console

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size() - 1) {
                    s.append((nodeList.get(i).neighbours.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        AdjacencyList al = new AdjacencyList(nodeList);
        al.addUndirectedEdge(0, 1);
        al.addUndirectedEdge(0, 2);
        al.addUndirectedEdge(0, 3);
        al.addUndirectedEdge(1, 4);
        al.addUndirectedEdge(2, 3);
        al.addUndirectedEdge(3, 4);
        System.out.println(al.toString());
    }
}
