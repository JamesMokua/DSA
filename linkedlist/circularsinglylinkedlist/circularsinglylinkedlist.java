package linkedlist.circularsinglylinkedlist;

public class circularsinglylinkedlist {
    class Node {
        public int value;
        public Node next;
    }

    public Node head;
    public Node tail;
    public int size;

    public void createCircularLinkedList(int nodeValue) {// Create a circular linked list
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
    }

    public void insertInCircularLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createCircularLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head;

        } else if (location >= size) {
            node.next = head;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;// insert new node between current and next node
            int index = 0;
            while (index < location - 1) {// get to the node before the location to insert
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;// reference new node to the next node
            tempNode.next = node;// reference current node(node before location to insert) to the new node
        }
        size++;
    }

    public void traverseCircularLinkedList() {
        if (head == null) {
            System.out.println("Circular Linked List does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println();
    }

    public void searchCircularLinkedList(int nodeValue) {
        if (head == null) {
            System.out.println("Circular Linked List does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location: " + i);
                    return;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found in the list");
    }
    public void deleteCircularLinkedListNode(int location) {
        if (head == null) {
            System.out.println("Circular Linked List does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;

            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
    public void deleteCircularLinkedList(){
        if(head==null){
            System.out.println("Circular Linked List does not exist");
        }else{
            head.next=null;
            head=tail=null;
            System.out.println("Circular Linked List deleted successfully");
        }
    }

    public static void main(String[] args) {
        circularsinglylinkedlist circularsinglylinkedlist = new circularsinglylinkedlist();
        circularsinglylinkedlist.createCircularLinkedList(5);
        // System.out.println(circularsinglylinkedlist.head.value);
        circularsinglylinkedlist.insertInCircularLinkedList(6, 1);
        circularsinglylinkedlist.insertInCircularLinkedList(7, 2);
        circularsinglylinkedlist.insertInCircularLinkedList(8, 3);
        circularsinglylinkedlist.traverseCircularLinkedList();
        // circularsinglylinkedlist.searchCircularLinkedList(7);
        // circularsinglylinkedlist.deleteCircularLinkedListNode(1);
        circularsinglylinkedlist.deleteCircularLinkedList();
        circularsinglylinkedlist.traverseCircularLinkedList();

    }
}
