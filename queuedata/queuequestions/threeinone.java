package queuedata.queuequestions;

public class threeinone {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public void ThreeInOne(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    //isFull
    public boolean isFull(int stackNum){//takes parameter stackNum because one stack might be empty another one might not be
         if(sizes[stackNum] == stackCapacity){
            return true;
         }else{
            return false;
         }
    }
     //isEmpty
     public boolean isEmpty(int stackNum){//stackNum is index of stacks
        if(sizes[stackNum] == 0){
           return true;
        }else{
           return false;
        }
   }
   private int indexOfTop(int stackNum){
    int offset = stackNum * stackCapacity;
    int size = sizes[stackNum];
    return offset + size - 1;

   }
   //push
   public void push(int stackNum, int value){
   if(isFull(stackNum)){
    System.out.println("stack is full");
}else{
    sizes[stackNum]++;
    values[indexOfTop(stackNum)] = value;
}
   }
   //pop
    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("Stack is Empty");
            return -1;
        }else{
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }
    }
    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("Stack is Empty");
            return -1;
        }else{
            return values[indexOfTop(stackNum)];
        }
    }

    public static void main(String[] args){
    threeinone t = new threeinone();
    t.ThreeInOne(3);
    t.push(0,1);
    t.push(0, 2);
    t.push(1,4);
    t.push(1, 5);
    t.push(2,8);
    int result = t.pop(1);
    int result2 = t.peek(1);
    System.out.println(result);
    System.out.println(result2);
    

    }
}
