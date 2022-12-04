package linkedlist;

public class singlylinkedlist { 
    //  public static class Node{
    //     public int value;
    //     public Node next;
    //     public Node head;
    //     public Node tail;
    //     public int size;
    //   creating singly linked list takes O(1) T.C
    //     public  Node createSinglyLinkedList(int nodeValue){
    //         head= new Node();//O(1)
    //         Node node = new Node();//O(1)
    //         node.next = null;//O(1)
    //         node.value = nodeValue;//O(1)
    //         head =node;//setting the reference of head and tail to the created node
    //         tail=node;
    //         size=5;
    //         return head;
    //     }
    // }
    Node head; // head of list
 
    /* Linked list Node*/
   static class Node {
        int data;
        Node next;
 
        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) { data = d; }
    }
   
   public static void main(String[] args) {
        Node sLL = new Node(6);
        System.out.println(sLL.data);
    }
}
