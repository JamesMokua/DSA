package AVLtree;
import java.util.Queue;
import java.util.LinkedList;

public class AVLtree {
    public AVLtree left;
    public AVLtree right;
    public AVLtree root;
    public int value;
    public int height;
    AVLtree(){
        root = null;
        this.height = 0;
    }
     // PreOrder Traversal
     public void preOrder(AVLtree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");// print root node value
        preOrder(node.left);// print left subtree
        preOrder(node.right);// traverse right subtree
    }

    // InOrder Traversal
    public void inOrder(AVLtree node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

    }

    // PostOrder traversal
    public void postOrder(AVLtree node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // LevelOrder traversal
    public void levelOrder() {
        Queue<AVLtree> q = new LinkedList<AVLtree>();
        q.add(root);
        while (!q.isEmpty()) {
            AVLtree presentNode = q.remove();// remove first element from the queue
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
    public AVLtree search(AVLtree node, int value) {
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
    //  getHeight
  public int getHeight(AVLtree node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  // rotateRight
  private AVLtree rotateRight(AVLtree disbalancedNode) {
    AVLtree newRoot = disbalancedNode.left;
    disbalancedNode.left = disbalancedNode.left.right;
    newRoot.right = disbalancedNode;
    disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    //to count the height of this node plus for the left or right child we add 1
    newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
  }

  // rotateLeft
  private AVLtree rotateLeft(AVLtree disbalancedNode) {
    AVLtree newRoot = disbalancedNode.right;
    disbalancedNode.right = disbalancedNode.right.left;
    newRoot.left = disbalancedNode;
    disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
  }

  // getBalance
  public int getBalance(AVLtree node) {
    if (node == null) {
      return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  // insertNode Method
  private AVLtree insertNode(AVLtree node, int nodeValue) {
    if (node == null) {
      AVLtree newNode = new AVLtree();
      newNode.value = nodeValue;
      newNode.height = 1;
      return newNode;
    } else if (nodeValue < node.value) {
      node.left = insertNode(node.left, nodeValue);
    } else {
      node.right = insertNode(node.right, nodeValue);
    }
    //update the height of this new tree since we're adding a new node
    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    //take the balance between the difference of the subtrees
    int balance = getBalance(node);
    //using the balance we identify which condition of 
    //AVL trees is required(LL,LR,RR,RL)
    //LL
    if (balance > 1 && nodeValue < node.left.value) {
      return rotateRight(node);
    }
    //LR
    if (balance > 1 && nodeValue > node.left.value) {
      node.left = rotateLeft(node.left);
      return rotateRight(node);
    }
    //RR
    if (balance < -1 && nodeValue > node.right.value) {
      return rotateLeft(node);
    }
    //RL
    if (balance < - 1 && nodeValue < node.right.value) {
      node.right = rotateRight(node.right);
      return rotateLeft(node);
    }

    return node;

  }

  public void insert(int value) {
    root = insertNode(root, value);
  }

  // Minimum node
  public static AVLtree minimumNode(AVLtree root) {
    //since values less than root are on the left
    //we recursively call the left side in order to find the minimum
    if (root.left == null) {
      return root;
    } else {
      return minimumNode(root.left);
    }
  }
    // Delete node
 public AVLtree deleteNode(AVLtree node, int value) {
    if (node == null) {
      System.out.println("Value not found in AVL");
      return node;
    }
    if (value < node.value) {
        //continue to the left subtree
      node.left = deleteNode(node.left, value);
    } else if (value > node.value) {
        //continue to the right subtree
      node.right = deleteNode(node.right, value);
    } else {
        //if node has two children
      if (node.left != null && node.right != null) {
        AVLtree temp = node;
        AVLtree minNodeForRight = minimumNode(temp.right);//minimum node of right subtree
        node.value = minNodeForRight.value;//update minimum node of right to the value we want to delete
        node.right = deleteNode(node.right, minNodeForRight.value);//delete minimum node from the tree
      } else if (node.left != null) {
        node = node.left;//delete left child if we only have left child
      } else if (node.right != null) {
        node = node.right;//delete right child if we only have right child
      } else {
        node = null;
      }
    }
    // Case 2 - rotation required
 
    // System.out.println("1");
    // System.out.println(previous.value);
 
    // node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    int balance = getBalance(node);
    //LL
    if (balance > 1 && getBalance(node.left) >= 0) {
      return rotateRight(node);
    }
    //LR
    if (balance > 1 && getBalance(node.left) < 0) {
      node.left = rotateLeft(node.left);
      return rotateRight(node);
    }
    //RR
    if (balance < -1 && getBalance(node.right) <= 0) {
      return rotateLeft(node);
    }
    //RL
    if (balance < -1 && getBalance(node.right) > 0) {
      node.right = rotateRight(node.right);
      return rotateLeft(node);
    }
 
    return node;
 
  }
 
  public void delete(int value) {
    root = deleteNode(root, value);
  }
 
  public void deleteAVL() {
    root = null;
  }
    public static void main(String[] args){
        AVLtree avl = new AVLtree();
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(50);
        avl.levelOrder();
        avl.delete(5);
        System.out.println();
        avl.levelOrder();
    }
}
