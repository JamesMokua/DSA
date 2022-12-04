package linkedlist.doublelinkedlist;

public class doublelinkedlist {
    class Node {
        public int value;
        public Node next;
        public Node prev;
    }

    public Node head;
    public Node tail;
    public int size;

    public void createDoubleLinkedList(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        node.prev = null;
        head = node;
        tail = node;
        size = 1;
    }

    public void insertDoubleLinkedList(int nodeValue, int location) {
        Node newNode = new Node();
        newNode.value = nodeValue;

        if (head == null) {
            createDoubleLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    public void traverseDoubleLinkedList() {
        if (head == null) {
            System.out.println("Double Linked List does not exist");
        }
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            if (i != size - 1) {
                System.out.print("->");
            }
            tempNode = tempNode.next;
        }

        System.out.println();
    }

    public void reverseDoublyLinkedList() {
        if (head == null) {
            System.out.println("DLL does not exist");
        }
        Node tempNode = tail;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            if (i != size - 1) {
                System.out.print("<-");
            }
            tempNode = tempNode.prev;
        }
        System.out.println();
    }

    public void searchDoubleLinkedList(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found node at index " + i);
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("Node does not exist");
        }

    }

    public void deleteDoubleLinkedListNode(int location) {
        if (head == null) {
            System.out.println("DLL does not exist");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = null;
                size--;

            }
        } else if (location >= size) {
            Node tempNode = tail.prev;
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            } else {

                tempNode.next = null;
                tail = tempNode;
                size--;
            }

        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;

            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }
    public void deleteDoubleLinkedList(){
       Node tempNode = head;
       for(int i = 0; i < size; i++){
        tempNode.prev = null;
        tempNode = tempNode.next;
       }
       
       head = null;
       tail = null;
       System.out.println("DLL has been deleted");

    }

    public static void main(String[] args) {
        doublelinkedlist dll = new doublelinkedlist();
        dll.createDoubleLinkedList(2);
        // System.out.println(dll.head.value);
        dll.insertDoubleLinkedList(5, 0);
        dll.insertDoubleLinkedList(6, 1);
        dll.insertDoubleLinkedList(7, 2);
        dll.insertDoubleLinkedList(8, 3);
        dll.insertDoubleLinkedList(9, 0);
        dll.insertDoubleLinkedList(10, 5);
         dll.traverseDoubleLinkedList();
        //  dll.deleteDoubleLinkedListNode(0);
        dll.deleteDoubleLinkedList();
         dll.traverseDoubleLinkedList();
        // dll.reverseDoublyLinkedList();
        // dll.searchDoubleLinkedList(7);

    }
}
