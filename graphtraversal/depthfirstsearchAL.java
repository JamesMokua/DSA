package graphtraversal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class depthfirstsearchAL {
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

    public depthfirstsearchAL(ArrayList<GraphNode> nodeList) {
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
    public void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNode neighbour : currentNode.neighbours){
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
        depthfirstsearchAL dfs = new depthfirstsearchAL(nodeList);
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
