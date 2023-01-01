package dijkstrasalgorithm;
import java.util.*;
public class dijkstrasalgo {
    public static class WeightedNode implements Comparable<WeightedNode> {
        public String name;
        public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
        public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
        public boolean isVisited = false;
        public WeightedNode parent;
        public int distance;
        public int index;
      
        public WeightedNode(String name, int index) {
          this.name = name;
          distance = Integer.MAX_VALUE;//set the value of nodes to infinity
          this.index = index;
        }
      
        @Override
        public String toString() {
          return name;
        }
      
        @Override
        public int compareTo(WeightedNode o) {
          return this.distance - o.distance;
        }
    }  
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

  public dijkstrasalgo(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
  }

  void dijkstra(WeightedNode node) {
    PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
    node.distance = 0;//set initial node value to zero
    queue.addAll(nodeList);//add all nodes to priority queue
    while(!queue.isEmpty()) {
      WeightedNode currentNode = queue.remove();
      for (WeightedNode neighbor : currentNode.neighbors) {
        if(queue.contains(neighbor)) {//if neighbour is not visited
          if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
            neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
            neighbor.parent = currentNode;
            //refresh the priority queue
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }

    for (WeightedNode nodeToCheck : nodeList) {
      System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
      pathPrint(nodeToCheck);
      System.out.println();
    }
  }

  public static void pathPrint(WeightedNode node) {
   if (node.parent  != null) {
     pathPrint(node.parent);
   }
   System.out.print(node.name + " ");
 }

  public void addWeightedEdge(int i, int j, int d) {
    WeightedNode first = nodeList.get(i);
    WeightedNode second = nodeList.get(j);
    first.neighbors.add(second);
    first.weightMap.put(second,d);
  }    
    public static void main(String[] args){
     ArrayList<WeightedNode> nodeList = new ArrayList<>();
     nodeList.add(new WeightedNode("A", 0));
     nodeList.add(new WeightedNode("B", 1));
     nodeList.add(new WeightedNode("C", 2));
     nodeList.add(new WeightedNode("D", 3));
     nodeList.add(new WeightedNode("E", 4));
     nodeList.add(new WeightedNode("F", 5));
     nodeList.add(new WeightedNode("G", 6));
     dijkstrasalgo da = new dijkstrasalgo(nodeList);
     da.addWeightedEdge(0, 1, 2);
     da.addWeightedEdge(0, 2, 5);
     da.addWeightedEdge(1, 2, 6);
     da.addWeightedEdge(1, 3, 1);
     da.addWeightedEdge(1, 4, 3);
     da.addWeightedEdge(2, 5, 8);
     da.addWeightedEdge(2, 4, 4);
     da.addWeightedEdge(4, 6, 9);
     da.addWeightedEdge(5, 6, 7);
     System.out.println("Printing Dijkstra from source: A");
     da.dijkstra(nodeList.get(0));
    }
}
