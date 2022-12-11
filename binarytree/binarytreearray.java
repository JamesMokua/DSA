package binarytree;

public class binarytreearray {
    String[] arr;
    int lastUsedIndex;

    public void createBTA(int size) {
        arr = new String[size + 1];// since we dont start at the zero index we add this to make it start from 1
        this.lastUsedIndex = 0;
        System.out.println("Blank Tree of size " + size + " has been made");
    }

    // isFull
    public boolean isFull() {
        if (arr.length - 1 == lastUsedIndex) {
            return true;
        } else {
            return false;
        }
    }

    public void insertBTA(String value) {
        if (!isFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("The value of " + value + " has been inserted");
        } else {
            System.out.println("The BT is full");
        }

    }

    // PreOrder Traversal
    public void preOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder((index * 2) + 1);

    }

    // PostOrder Traversal
    public void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        postOrder(index * 2);
        postOrder((index * 2) + 1);
        System.out.print(arr[index] + " ");

    }

    // InOrder Traversal
    public void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);
    }

    // LevelOrder Traversal
    public void levelOrder() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // search
    public int search(String value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i] == value) {
                System.out.println("Node found at index: " + i);
                return i;
            }
        }
        System.out.println("Node not found in BT");
        return -1;
    }

    // delete node from binary tree
    public void deleteBTNode(String value) {
        // int location = search(value);//used level traversal to find the location of
        // node we want to delete
        // if(location==-1){
        // return;
        // }else{
        // arr[location] = arr[lastUsedIndex];//move deepest node to the node we want to
        // delete
        // lastUsedIndex--;
        // System.out.println("Node successfully deleted");
        // }
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i] == value) {
                arr[i] = arr[lastUsedIndex];
                lastUsedIndex--;
            }
        }
    }

    public void deleteBT() {
        try {
            arr = null;
            System.out.println("Binary Tree has been deleted");
        } catch (Exception e) {
            System.out.println("There was an error deleting the tree");
        }

    }

    public static void main(String[] args) {
        binarytreearray bta = new binarytreearray();
        bta.createBTA(9);
        bta.insertBTA("N1");
        bta.insertBTA("N2");
        bta.insertBTA("N3");
        bta.insertBTA("N4");
        bta.insertBTA("N5");
        bta.insertBTA("N6");
        bta.insertBTA("N7");
        bta.insertBTA("N8");
        bta.insertBTA("N9");
        bta.levelOrder();
        System.out.println();
        bta.deleteBT();
    }
}
