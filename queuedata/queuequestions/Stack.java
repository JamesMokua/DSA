package queuedata.queuequestions;
import java.util.*;
public class Stack {
    class Node {
        int value;
        Node above;
        Node below;

        public Node(int value) {
            this.value = value;
        }
    }

    private int capacity;
    public Node top;
    public Node bottom;
    public int size = 0;

    public void Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void join(Node above, Node below) {
        if (below != null) {
            below.above = above;// create link from below node to above node
        }
        if (above != null) {
            above.below = below; // create link from above node to below node
        }
    }

    public boolean push(int v) {
        if (size >= capacity) {
            return false;
        }
        size++;
        Node newNode = new Node(v);
        if (size == 1) {
            bottom = newNode;
        }
        join(newNode, top);
        top = newNode;
        return true;
    }

    public int pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        int result = top.value;
        top = top.below;
        size--;
        return result;
    }
    
//setofstacks
ArrayList<Stack> stacks = new ArrayList<Stack>();
public void SetOfStacks(int capacity){
    this.capacity = capacity;
}

//get last stack
public Stack getLastStack(){
 if (stacks.size() == 0){
    return null;
 }
 return stacks.get(stacks.size()-1);
}

public void pushSetOfStacks(int v){
    Stack last = getLastStack();
    if(last != null && !last.isFull()){
        last.push(v);
    }else{
        Stack stack = new Stack();
        stack.Stack(capacity);
        stack.push(v);
        stacks.add(stack);
    }
}

public int popSetOfStacks(){
    Stack last = getLastStack();
    if(last == null) {
        throw new EmptyStackException();
    }
    int result =last.pop();
    if(last.size == 0){
        stacks.remove(stacks.size()-1);

    }
    return result;
    
}
public int removeBottom(){
    Node b = bottom;
    bottom = bottom.above;
    if(bottom != null){
        bottom.below = null;
    }
    size--;
    return b.value;

}

//helper leftShift
public int leftShift(int index, boolean removeTop){
    Stack stack = stacks.get(index);
    int removedItem;
    if(removeTop){
        removedItem = stack.pop();
    }else{
        removedItem = stack.removeBottom();
    }

    if(stack.size == 0){
        stacks.remove(index);

    }else if(stacks.size() > index +1){
        int v = leftShift(index + 1, false);
        stack.push(v);
    }
    return removedItem;
}

public int popAt(int index){
    return leftShift(index, true);
}
    public static void main(String[] args) {
       Stack s = new Stack();
       s.Stack(3);
       s.pushSetOfStacks(1);
       s.pushSetOfStacks(2);
       s.pushSetOfStacks(3);
       s.pushSetOfStacks(4);
       s.pushSetOfStacks(5);
       System.out.println(s.popAt(0));
       System.out.println(s.popAt(0));
    }
}
