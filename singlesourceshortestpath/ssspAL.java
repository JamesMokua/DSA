package singlesourceshortestpath;
import java.util.ArrayList;
import java.util.LinkedList;
public class ssspAL {
    public static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;
        public GraphNode parent;
        public ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }
    public ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public ssspAL(ArrayList<GraphNode> nodeList) {
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
      // BFS Internal
      public void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (GraphNode neighbour : currentNode.neighbours) {
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
            if (!node.isVisited) {//if node is not visited
                bfsVisit(node);
            }
        }
    }
    public static void pathPrint(GraphNode node) {//prints out path to console
        if (node.parent  != null) {
          pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
      }
    public void BFSForSSSPP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);//add starting node to the queue
        while(!queue.isEmpty()) {
          GraphNode currentNode = queue.remove(0);//remove first element of queue
          currentNode.isVisited = true;//set the node to show its been visited
          System.out.print("Printing path for node " + currentNode.name + ": ");
          pathPrint(currentNode);
          System.out.println();
          for (GraphNode neighbour : currentNode.neighbours) {//check the neighbours of the current node
            if (!neighbour.isVisited) {//if neighbour is not visited
              queue.add(neighbour);//add the neighbour to the queue
              neighbour.isVisited = true;
              neighbour.parent = currentNode;
            }
          }
     
        }
      }
     
    public static void main(String[] args){
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        ssspAL bfs = new ssspAL(nodeList);//create graph based on nodelist
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
