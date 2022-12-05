package queuedata;

public class queuedata {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public void QueueArray(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Queue created with size of: " + size);
    }

    public boolean isFull() {
        if (topOfQueue == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (beginningOfQueue == -1 || beginningOfQueue == arr.length) {
            return true;
        } else {
            return false;
        }

    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Value has been inserted: " + value);

        } else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted: " + value);
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if (beginningOfQueue > topOfQueue) {// if its the last element in the queue
                beginningOfQueue = -1;
                topOfQueue = -1;
            }
            return result;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[beginningOfQueue];
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public void delete() {
        arr = null;
        System.out.println("Queue is successfully deleted");
    }

    public static void main(String[] args) {
        queuedata q = new queuedata();
        q.QueueArray(5);
        // boolean result = q.isEmpty();
        // System.out.println(result);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        // int result= q.peek();
        // System.out.println(result );
        // q.delete();
    }
}
