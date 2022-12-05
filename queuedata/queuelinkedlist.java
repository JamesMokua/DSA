package queuedata;

public class queuelinkedlist {
    class Node{
        public int value;
        public Node next;
    }

    public Node head;
    public Node tail;
    public int size;

    public void creatQueueLL(int nodeValue){
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        System.out.println("Queue created:" +nodeValue);

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
    public void enQueue(int value){
        Node tempNode = head;
        Node newNode = new Node();
        newNode.value = value;
     for(int i=0; i < size-1;i++){
       tempNode = tempNode.next;
     }
     tempNode.next = newNode;
     newNode.next = null;
     tail = newNode;
     size++;


    }
    public boolean isEmpty(){
        if(head==null){
           return true;
        }else{
            return false;
        }
    }
    public int peek(){
        if(head==null){
            System.out.println("Queue is empty");
            return -1;
        }else{
            return head.value;
        }
    }
    public int deQueue(){
        if(head==null){
            System.out.println("queue is empty");
            return -1;
        }else{
            int result = head.value;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return result;
        }
    }
    public void deleteQueue(){
        head = null;
        tail = null;
        System.out.println("Queue deleted");
    }
    
    public static void main(String[] args){
        queuelinkedlist q = new queuelinkedlist();
        q.creatQueueLL(5);
        q.enQueue(6);
        q.enQueue(7);
        q.enQueue(8);
    //     q.traverseSinglyLinkedList();
    //    int result = q.peek();
    //    System.out.println(result);
    // q.traverseSinglyLinkedList();
    //   int result2= q.deQueue();
    //   System.out.println(result2);
    //   q.traverseSinglyLinkedList();
    //   int result3= q.deQueue();
    //   System.out.println(result3);
    //   q.traverseSinglyLinkedList();
    //  q.deleteQueue();
    //  q.traverseSinglyLinkedList();

    }
}
