package graphtraversal;

import java.util.ArrayList;
import java.util.LinkedList;

public class breadthfirstsearchAL {
    public static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;
        public ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }
    public ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public breadthfirstsearchAL(ArrayList<GraphNode> nodeList) {
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
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        breadthfirstsearchAL bfs = new breadthfirstsearchAL(nodeList);
        bfs.addUndirectedEdge(0, 1);
        bfs.addUndirectedEdge(0, 2);
        bfs.addUndirectedEdge(0, 3);
        bfs.addUndirectedEdge(1, 4);
        bfs.addUndirectedEdge(2, 3);
        bfs.addUndirectedEdge(3, 4);
        System.out.println(bfs.toString());

        bfs.bfs();

    }
}
