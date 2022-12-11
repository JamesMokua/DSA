package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class binarynode {
    public String value;
    public binarynode left;
    public binarynode right;
    public int height;
    binarynode root;

    public void binarytree() {
        this.root = null;
    }

    // PreOrder Traversal
    public void preOrder(binarynode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");// print root node value
        preOrder(node.left);// print left subtree
        preOrder(node.right);// traverse right subtree
    }

    // InOrder Traversal
    public void inOrder(binarynode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

    }

    // PostOrder traversal
    public void postOrder(binarynode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // LevelOrder traversal
    public void levelOrder() {
        Queue<binarynode> q = new LinkedList<binarynode>();
        q.add(root);
        while (!q.isEmpty()) {
            binarynode presentNode = q.remove();// remove first element from the queue
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                q.add(presentNode.left);
            }
            if (presentNode.right != null) {
                q.add(presentNode.right);
            }
        }

    }

    // Search method
    public void search(String value) {
        Queue<binarynode> q = new LinkedList<binarynode>();
        q.add(root);
        while (!q.isEmpty()) {
            binarynode presentNode = q.remove();
            if (presentNode.value == value) {
                System.out.println("Value is found in the tree!");
                return;
            } else {
                if (presentNode.left != null) {
                    q.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    q.add(presentNode.right);
                }

            }
        }
        System.out.println("Value is not found");
    }

    // Insert Node
    public void insert(String value) {
        binarynode newNode = new binarynode();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            System.out.println("Inserted new node at root");
            return;
        }
        Queue<binarynode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            binarynode presentNode = q.remove();
            if (presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("Successfully inserted");
                break;
            } else if (presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("Successfully added");
                break;
            } else {
                q.add(presentNode.left);
                q.add(presentNode.right);
            }
        }
    }

    // Get Deepest Node
    public binarynode getDeepestNode() {
        Queue<binarynode> q = new LinkedList<binarynode>();
        q.add(root);
        binarynode presentNode = null;
        while (!q.isEmpty()) {
            presentNode = q.remove();
            if (presentNode.left != null) {
                q.add(presentNode.left);
            }
            if (presentNode.right != null) {
                q.add(presentNode.right);
            }
        }
        return presentNode;
    }

    // Delete Deepest Node
    public void deleteDeepestNode() {
        Queue<binarynode> q = new LinkedList<binarynode>();
        q.add(root);
        binarynode previousNode;
        binarynode presentNode = null;
        while (!q.isEmpty()) {
            previousNode = presentNode;
            presentNode = q.remove();

            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            q.add(presentNode.left);
            q.add(presentNode.right);
        }
    }

    // delete givem node
    public void deleteNode(String value) {
        Queue<binarynode> q = new LinkedList<binarynode>();
        q.add(root);
        while (!q.isEmpty()) {
            binarynode presentNode = q.remove();
            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("Node is deleted");
                return;
            } else {
                if (presentNode.left != null) {
                    q.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    q.add(presentNode.right);
                }
                
            }
        }
        System.out.println("Node does not exist");
    }

    // Delete entire binary tree
    public void deleteBT(){
        root = null;
        System.out.println("BT has been successfully deleted");
    }

    public static void main(String[] args) {
        binarynode bn = new binarynode();
        // bn.binarytree();
        // binarynode N1 = new binarynode();
        // N1.value = "N1";
        // binarynode N2 = new binarynode();
        // N2.value = "N2";
        // binarynode N3 = new binarynode();
        // N3.value = "N3";
        // binarynode N4 = new binarynode();
        // N4.value = "N4";
        // binarynode N5 = new binarynode();
        // N5.value = "N5";
        // binarynode N6 = new binarynode();
        // N6.value = "N6";
        // binarynode N7 = new binarynode();
        // N7.value = "N7";
        // binarynode N8 = new binarynode();
        // N8.value = "N8";
        // binarynode N9 = new binarynode();
        // N9.value = "N9";

        // N1.left = N2;
        // N1.right = N3;
        // N2.left = N4;
        // N2.right = N5;
        // N3.left = N6;
        // N3.right = N7;
        // N4.left = N8;
        // N4.right = N9;
        // bn.root = N1;

        // bn.postOrder(bn.root);
        // bn.search("N10");
        bn.insert("N1");
        bn.insert("N2");
        bn.insert("N3");
        bn.insert("N4");
        bn.insert("N5");
        bn.insert("N6");
        bn.levelOrder();
        bn.deleteNode("N3");
        System.out.println();
        bn.deleteBT(); 
        // System.out.println();
        // System.out.println(bn.getDeepestNode().value);

    }
}
