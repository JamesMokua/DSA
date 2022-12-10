package queuedata.queuequestions;
import java.util.Stack;
public class Queueviastacks {
     Stack<Integer> stackNewest, stackOldest;

     public Queueviastacks(){
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
     }

     public int size(){
        return stackNewest.size() + stackOldest.size();
     }
     public void enqueue(int value){
        stackNewest.push(value);
     }

     private void shiftStacks() {
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                int poppedOut = stackNewest.pop();
                stackOldest.push(poppedOut);
            }
        }
     }
     public int dequeue() {
        shiftStacks();
        return stackOldest.pop();
     }

     public int peek(){
        shiftStacks();
        return stackOldest.peek();
     }

     public static void main(String[] args){
        Queueviastacks q = new Queueviastacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
     }
}
