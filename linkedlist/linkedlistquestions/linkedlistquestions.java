package linkedlist.linkedlistquestions;

import java.util.HashSet;

public class linkedlistquestions {
    class Node{
        public int value;
        public Node next;
        public Node prev;
    }
    public Node head;
    public Node tail;
    public int size;

    public void createLinkedList(int nodeValue){
    Node node = new Node();
    node.value = nodeValue;
    node.next = null;
    head=node;
    tail=node;
    size=1;
    }
    public void insertNode(int nodeValue){
        if(head==null){
            createLinkedList(nodeValue);
            return;
        }
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail=newNode;
        size++;
    }
    public void traverseLinkedList(){
        Node tempNode = head;
        for(int i = 0; i<size; i++){
            System.out.print(tempNode.value);
            if(i!=size-1){
                System.out.print("->");
            }
            tempNode=tempNode.next;
        }
        System.out.println();
    }
    public void deleteDuplicates(linkedlistquestions ll){
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while(current != null){
            int currentValue = current.value;
            if(hs.contains(currentValue)){
                prev.next = current.next;//deletes duplicates value and assigns previous node next reference to the next node reference
                ll.size--;
            }else{
                hs.add(currentValue);
                prev = current;//goes to the next node
            }
            current = current.next;
        }

    }
  Node nthToLast(linkedlistquestions ll, int n){
    Node slow = ll.head;
    Node fast = ll.head;
    for(int i = 0; i<n; i++){
        if(fast==null){
            return null;
        }else{
            fast = fast.next;
        }
    }
    while(fast != null){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
  }
  Node middleNode(linkedlistquestions ll){
    Node slow = ll.head;
    Node fast = ll.head;
    if(head!=null){
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
      
        
    }return slow; 
  }
  linkedlistquestions partition(linkedlistquestions ll, int x){
    Node curNode = ll.head;
    ll.tail = ll.head;//set value of head to tail
    while(curNode != null){//continues till end of linked list
        Node next = curNode.next;
        if(curNode.value < x){//add the value to the beginning of the linked list
            curNode.next = ll.head;
            ll.head = curNode;
        }else{//add it to the end of the linked list
            ll.tail.next = curNode;
            ll.tail = curNode;
        }
        //continues to the next node
        curNode = next;
    }
    //set last node to null
    ll.tail.next = null;
    return ll;
  }
  //reverse linked list
//   Node reverse(Node node)
//   {
//       Node prev = null;
//       Node current = node;
//       Node next = null;
//       while (current != null) {
//           next = current.next;
//           current.next = prev;
//           prev = current;
//           current = next;
//       }
//       node = prev;
//       return node;
//   }
  linkedlistquestions sumList(linkedlistquestions ll,linkedlistquestions mm){
  Node n1 =ll.head;
  Node n2 = mm.head;
  int carry = 0;
  linkedlistquestions resultLL = new linkedlistquestions();
  while(n1!=null || n2!=null){
    int result = carry;
    if(n1!=null){
        result += n1.value;
        n1 = n1.next;
    }
    if(n2!=null){
        result += n2.value;
        n2 = n2.next;
    }
    resultLL.insertNode(result%10);
    carry = result/10;
  }
  return resultLL;
  }

  //intersection
  //getKthNode
  Node getKthNode(Node head, int k){
    Node current = head;
    while(k>0 && current != null ){
        current = current.next;
        k--;
    }
    return current;
  }

  //intersection method
  Node findIntersection(linkedlistquestions ll, linkedlistquestions mm){
   if(ll.head == null || mm.head == null){
    return null;
   }
   if(ll.tail != mm.tail){
    return null;
   }
   Node shorter = new Node();
   Node longer = new Node();
   if(ll.size > mm.size){
    longer = ll.head;
    shorter = mm.head;
   }else{
    longer = mm.head;
    shorter =ll.head;
   }
   longer = getKthNode(longer, Math.abs(ll.size - mm.size));//abs converts it to positive number
   while (shorter != longer){
    shorter = shorter.next;
    longer = longer.next;
   }
   return longer;
  }

  //add same node
  public void addSameNode(linkedlistquestions ll,linkedlistquestions mm, int nodeValue){
 Node newNode = new Node();
 newNode.value = nodeValue;
 ll.tail.next = newNode;
 ll.tail = newNode;
 mm.tail.next = newNode;
 mm.tail = newNode;
  }


    public static void main(String[] args){
     linkedlistquestions ll = new linkedlistquestions();
     linkedlistquestions mm = new linkedlistquestions();
    //  ll.createLinkedList(1);
    //  ll.insertNode(2);
    //  ll.insertNode(3);
    //  ll.insertNode(4);
     ll.insertNode(3);
     ll.insertNode(1);
     ll.insertNode( 5);
     ll.insertNode(9);
     mm.insertNode(2);
     mm.insertNode(4);
     mm.insertNode(6);
    //  ll.traverseLinkedList();
    //  mm.traverseLinkedList();
    //  ll.deleteDuplicates(ll);
    // Node n = ll.nthToLast(ll, 3);
    // System.out.println(n.value);
    // Node m = ll.middleNode(ll);
    // System.out.println(m.value);
    // ll.partition(ll, 4);
    linkedlistquestions q = new linkedlistquestions();
    q.addSameNode(ll, mm, 7);
    q.addSameNode(ll, mm, 2);
    q.addSameNode(ll, mm, 1);
    Node inter = q.findIntersection(ll, mm);
    System.out.println(inter.value);
//    linkedlistquestions result= ll.sumList(ll, mm);
//     result.traverseLinkedList();
    }
}
