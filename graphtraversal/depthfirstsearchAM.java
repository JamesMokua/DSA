package graphtraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class depthfirstsearchAM {
    public static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    public depthfirstsearchAM(ArrayList<GraphNode> nodeList) {
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
    public void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbours(currentNode);
            for(GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited =  true;
                }
            }
        }
    }
    public void dfs(){
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {//if node is not visited
                dfsVisit(node);
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
        depthfirstsearchAM dfs = new depthfirstsearchAM(nodeList);
        dfs.addUndirectedEdge(0, 1);
        dfs.addUndirectedEdge(0, 2);
        dfs.addUndirectedEdge(0, 3);
        dfs.addUndirectedEdge(1, 4);
        dfs.addUndirectedEdge(2, 3);
        dfs.addUndirectedEdge(3, 4);
        System.out.println(dfs.toString());

        dfs.dfs();

    }
}
