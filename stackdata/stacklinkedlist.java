package stackdata;

public class stacklinkedlist {
    class Node {
        public int value;
        public Node next;
    }

    public Node head;
    public Node tail;
    public int size;

    public void createLLStack(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;

    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Push(int stackValue) {
        Node newNode = new Node();
        newNode.value = stackValue;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int Pop() {
        int topOfStack = head.value;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        System.out.println(topOfStack);
        return topOfStack;

    }

    public int Peek() {
        int topOfStack = head.value;
        System.out.println(topOfStack);
        return topOfStack;
    }
    public void deleteStack(){
        head = null;
        tail = null;
        System.out.println("Stack is deleted");
    }

    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist!");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        stacklinkedlist newStack = new stacklinkedlist();
        newStack.createLLStack(5);
        newStack.Push(6);
        newStack.Push(7);
        newStack.Push(8);
        // newStack.traverseSinglyLinkedList();
        // newStack.Pop();
        // newStack.traverseSinglyLinkedList();
        // newStack.deleteStack();
        // boolean result = newStack.isEmpty();
        // System.out.println(result);


    }
}
