package singlesourceshortestpath;
import java.util.ArrayList;
import java.util.LinkedList;
public class ssspAM {
    public static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;
        public GraphNode parent;
        
        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    public ssspAM(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
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

    // get neighbours
    public ArrayList<GraphNode> getNeighbours(GraphNode node) {
        // taking node index and checking if any columns have the node
        ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    // BFS Internal
    public void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbours(currentNode);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    // BFS
    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }
    //Print path of each of the vertex from source
 public static void pathPrint(GraphNode node) {
    if(node.parent!=null) {
     pathPrint(node.parent);
   }
    System.out.print(node.name+" ");
  }
 
  public void BFSForSSSPP(GraphNode node) {
    LinkedList<GraphNode> queue = new LinkedList<>();
    queue.add(node);
    while(!queue.isEmpty()) {
      GraphNode currentNode = queue.remove(0);
      currentNode.isVisited = true;
      System.out.print("Printing path for node "+currentNode.name+": ");
      pathPrint(currentNode);
      System.out.println();
      ArrayList<GraphNode> neighbours = getNeighbours(currentNode);
      for (GraphNode neighbour : neighbours) {
        if (!neighbour.isVisited) {
          queue.add(neighbour);
          neighbour.isVisited = true;
          neighbour.parent = currentNode;
        }
      }
 
    }
  }
 
 

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        ssspAM bfs = new ssspAM(nodeList);//create graph based on nodelist
        bfs.addUndirectedEdge(0, 1); //A -> B
        bfs.addUndirectedEdge(0, 2); //A -> C
        bfs.addUndirectedEdge(1, 3); //B -> D
        bfs.addUndirectedEdge(1,6);  //B -> G
        bfs.addUndirectedEdge(2, 3); //C -> D
        bfs.addUndirectedEdge(2, 4); //C -> E
        bfs.addUndirectedEdge(3, 5); //D -> F
        bfs.addUndirectedEdge(4, 5); //E -> F
        bfs.addUndirectedEdge(5, 6); //F -> G
        bfs.BFSForSSSPP(nodeList.get(0));

    }
}
