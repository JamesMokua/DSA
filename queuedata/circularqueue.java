package queuedata;


public class circularqueue {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;//needed for enqueue and dequeue

    public void createCircularQueue(int size){
    this.arr = new int[size];
    this.size = size;
    this.topOfQueue = -1;
    this.beginningOfQueue = -1;
    System.out.println("Queue is successfully created with size of: "+size);
    }

    //is Empty
    public boolean isEmpty(){
        if(topOfQueue==-1){
           return true;
        }else{
            return false;
        }
    }
    //isFull
    public boolean isFull(){
        if(topOfQueue+1 == beginningOfQueue){
            return true;
        }else if(beginningOfQueue==0 && topOfQueue+1==size){
            return true;
        }else{
            return false;
        }
    }
    //enQueue
    public void enQueue(int value){
    if(isFull()){
        System.out.println("Queue is full!");
    }else if(isEmpty()){
        beginningOfQueue = 0;
        topOfQueue++;
        arr[topOfQueue] =  value;
        System.out.println("Successfully inserted in the Queue: " +value);
    }else{
        if(topOfQueue+1==size){//means topofqueue is located in the last cell though there is space at the beginning
         topOfQueue=0;
        }else{
        topOfQueue++;
        }
        arr[topOfQueue] = value;
        System.out.println("Successfully inserted: "+value);
    }
    }
    //deQueue
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Circular queue is empty");
            return -1;
        }else{
            int result = arr[beginningOfQueue];
            arr[beginningOfQueue] = 0;
            if(beginningOfQueue==topOfQueue){
                //if we only have one element in the queue
                beginningOfQueue = topOfQueue = -1;
            }else if(beginningOfQueue+1 == size){//if beginningofqueue has reached the end of array we start back at the first cell
              beginningOfQueue = 0;

            }else{
                beginningOfQueue++;
            }
            return result;
        }
    }
    //peek
    public int peek(){
        if(isEmpty()){
            System.out.println("circular queue is empty");
            return -1;
        }else{
        return arr[beginningOfQueue];
        }
    }
    //delete queue
    public void deleteQueue(){
        arr = null;
        System.out.println("deleted queue");
    }
    public static void main(String[] args){
        circularqueue q =  new circularqueue();
        q.createCircularQueue(5);
        // boolean result = q.isEmpty();
        // System.out.println(result);
        // boolean result2 = q.isFull();
        // System.out.println(result2);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        // int result3 = q.deQueue();
        // System.out.println(result3);
        // int result4 = q.peek();
        // System.out.println(result4);
        // q.deleteQueue();
       

    }
}
