package binarysearchtree;

import java.util.Queue;
import java.util.LinkedList;

public class binarysearchtree {
    public binarysearchtree left;
    public binarysearchtree right;
    public binarysearchtree root;
    public int value;
    public int height;

    binarysearchtree() {
        root = null;

    }

    // Insert Method
    private binarysearchtree insert(binarysearchtree currentNode, int value) {
        if (currentNode == null) {
            binarysearchtree newNode = new binarysearchtree();
            newNode.value = value;
            // System.out.println("The value is successfully inserted");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    // PreOrder Traversal
    public void preOrder(binarysearchtree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");// print root node value
        preOrder(node.left);// print left subtree
        preOrder(node.right);// traverse right subtree
    }

    // InOrder Traversal
    public void inOrder(binarysearchtree node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

    }

    // PostOrder traversal
    public void postOrder(binarysearchtree node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // LevelOrder traversal
    public void levelOrder() {
        Queue<binarysearchtree> q = new LinkedList<binarysearchtree>();
        q.add(root);
        while (!q.isEmpty()) {
            binarysearchtree presentNode = q.remove();// remove first element from the queue
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
    public binarysearchtree search(binarysearchtree node, int value) {
        if (node == null) {
            System.out.println("Value does not exist in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value found in BST");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Minimum node
    public static binarysearchtree minimumNode(binarysearchtree root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    public binarysearchtree deleteNode(binarysearchtree root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                // check if the current node has two children and we want to
                // delete the root node which is the current node
                binarysearchtree temp = root;
                binarysearchtree minNodeForRight = minimumNode(temp.right);// get minimum element from the right subtree
                root.value = minNodeForRight.value;// set root value to minimum value
                root.right = deleteNode(root.right, minNodeForRight.value);// delete min node from right subtree
            } else if (root.left != null) {
                root = root.left;// has only left child then delete root node and update the link to the previous
                                 // node
            } else if (root.right != null) {// has only right child then delete root node and update the link to the
                                            // previous node
                root = root.right;
            } else {// if node we want to delete is a leaf node then simply set it to null
                root = null;
            }
        }

        return root;

    }

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }

    public static void main(String[] args) {
        binarysearchtree bst = new binarysearchtree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);
        bst.levelOrder();
        System.out.println();
        bst.deleteNode(bst.root, 50);
        bst.levelOrder();
    }
}
