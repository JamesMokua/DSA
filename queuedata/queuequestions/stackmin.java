package queuedata.queuequestions;


public class stackmin {
    class Node{
        int value;
        Node next;
        
        public Node (int value, Node next) {
    this.value = value;
    this.next = next;
  }
    }
    Node top;
    Node min;
   

    public void StackMin() {
      top = null;
      min = null;
    }
  
    public int min() {
      return min.value;
    }
  
    public void push(int value) {
      if (min == null) {
        min = new Node(value, min);
      } else if (min.value < value) {
        min = new Node(min.value, min);
      } else {
        min = new Node(value, min);
      }
      top = new Node(value, top);
    }
  
    public int pop() {
      min = min.next;
      int result = top.value;
      top = top.next;
      return result;
    }

    public static void main(String[] args) {
        stackmin s = new stackmin();
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(1 );
        // s.traversestack();
        // s.pop();
       int result = s.min();
       System.out.println(result);
       

    }
}
