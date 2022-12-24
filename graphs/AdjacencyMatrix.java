package graphs;
import java.util.ArrayList;

public class AdjacencyMatrix {
    public static class GraphNode{
        public String name;
        public int index;
    
        public GraphNode(String name, int index){
            this.name = name;
            this.index = index;
        }
    }
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    public AdjacencyMatrix(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }
    public void addUndirectedEdge(int i, int j){
    adjacencyMatrix[i][j] = 1;
    adjacencyMatrix[j][i] = 1;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + ": ");
          for (int j : adjacencyMatrix[i]) {
            s.append((j) + " ");
          }
          s.append("\n");
        }
        return s.toString();
      }
    public static void main(String[] args){
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        AdjacencyMatrix am = new AdjacencyMatrix(nodeList);
        am.addUndirectedEdge(0, 1);
        am.addUndirectedEdge(0, 2);
        am.addUndirectedEdge(0, 3);
        am.addUndirectedEdge(1, 0);
        am.addUndirectedEdge(1, 4);
        am.addUndirectedEdge(2, 3);
        am.addUndirectedEdge(3, 4);
        System.out.println(am.toString());
    }
}
