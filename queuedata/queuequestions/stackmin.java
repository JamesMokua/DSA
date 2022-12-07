package queuedata.queuequestions;

import recursion.recursion;

public class stackmin {
    class Node {
        public int value;
        public Node next;
    }

    public Node head;
    public Node tail;
    public int size;

    public void createStack(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        System.out.println("Stack created with value: " + nodeValue);
    }

    public void push(int value) {

        if (head == null) {
            System.out.println("Stack is empty!");
        } else {
            Node newNode = new Node();
            newNode.value = value;
            newNode.next = head;
            head = newNode;
            size++;
        }

    }
    public int pop(){
        int result = head.value;
        head = head.next;
        size--;
        return result;

    }
    public int stackMin(){
     
    }

    public void traversestack() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.println(tempNode.value);
                if (i < size - 1) {
                    System.out.println("---");
                }
                tempNode = tempNode.next;
            }

        }
    }

    public static void main(String[] args) {
        stackmin s = new stackmin();
        s.createStack(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        // s.traversestack();
        // s.pop();
       int result = s.stackMin();
       System.out.println(result);
       

    }
}
