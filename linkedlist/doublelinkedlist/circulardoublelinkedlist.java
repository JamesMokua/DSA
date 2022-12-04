package linkedlist.doublelinkedlist;

public class circulardoublelinkedlist {
    class Node{
        public int value;
        public Node next;
        public Node prev;
    }
    public Node head;
    public Node tail;
    public int size;
    public void createCircularDoubleLinkedList(int nodeValue){
        Node node = new Node();
        node.value = nodeValue; 
        node.next = node;
        node.prev = node;
        head = node;
        tail = node;
        size = 1;

    }
    public void insertCircularDoubleLinkedList(int nodeValue,int location){
        Node newNode = new Node();
        newNode.value = nodeValue;
        if(head==null){
            createCircularDoubleLinkedList(nodeValue);
            return;
        }else if(location==0){
            newNode.next = head; 
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
           
        }else if (location>=size){
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail=newNode;
        }else{
            Node tempNode = head;
            int index = 0;
            while(index < location-1){
                tempNode = tempNode.next;
                index++;
            }
            newNode.next=tempNode.next;
            newNode.prev = tempNode;
            tempNode.next = newNode;
            tempNode.next.prev = newNode;
        }
        size++;
    }
    public void traverseCircularDoubleLinkedList(){
        if(head==null){
            System.out.println("CDLL does not exist");
        }
        Node tempNode = head;
        for(int i = 0; i < size; i++){
            System.out.print(tempNode.value);
            if(i!=size-1){
                System.out.print("->");
            }
            tempNode = tempNode.next;
        }
        System.out.println();
    }
    public void reverseTraverseCircularDoubleLinkedList(){
       if(head!=null){
        Node tempNode = tail;
        for(int i = 0; i < size; i++){
            System.out.print(tempNode.value);
            if(i != size-1){
                System.out.print("<-");
            }
            tempNode= tempNode.prev;
        }
       }else{
        System.out.println("CDLL does not exist");
       }
    }
    public void searchCircularDoubleLinkedList(int nodeValue){
        if(head==null){
            System.out.println("CDLL does not exist");
        }
        Node tempNode = head;
        for(int i = 0; i < size; i++){
         if(tempNode.value == nodeValue){
            System.out.println("\nFound node at index "+i);
         }
         tempNode = tempNode.next;
        }

    }
    public void deleteCircularDoubleLinkedListNode(int location){
        if(head==null){
            System.out.println("CDLL does not exist");
        }else if(location==0){
            if(size==1){
                head.prev=null;
                head.next=null;
                head=null;
                tail=null;
                size--;
            }else{
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        }else if(location>=size){
            if(size==1){
                head.prev=null;
                head.next=null;
                head=null;
                tail=null;
                size--;
            }else{
                tail=tail.prev;
                tail.next=head;
                head.prev=tail;
                size--;
            }
        }else{
            Node tempNode = head;
            int index = 0;
            while(index < location-1){
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }
    public void deleteCircularDoubleLinkedList(){
      
        Node tempNode = head;
        for(int i = 0; i < size; i++){
         tempNode.prev = null;
         tempNode = tempNode.next;
        }
        
        head = null;
        tail = null;
        System.out.println("DLL has been deleted");
    }
    public static void main(String[] args){
   circulardoublelinkedlist dll = new circulardoublelinkedlist();
   dll.createCircularDoubleLinkedList(5);
//    System.out.println(dll.head.value);
  dll.insertCircularDoubleLinkedList(6, 1);
  dll.insertCircularDoubleLinkedList(7, 2);
  dll.insertCircularDoubleLinkedList(8, 3);
  dll.insertCircularDoubleLinkedList(9, 4);
  dll.insertCircularDoubleLinkedList(10, 5);
  dll.traverseCircularDoubleLinkedList();
//   dll.reverseTraverseCircularDoubleLinkedList();
//   dll.searchCircularDoubleLinkedList(9);
// dll.deleteCircularDoubleLinkedListNode(4);
dll.deleteCircularDoubleLinkedList();
dll.traverseCircularDoubleLinkedList();
    }
}
