package stackdata;

public class stackstructure {
    int[] arr;
    int topOfStack;

    public void createStack(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The Stack was created with size of: " + size);
    }

    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (topOfStack == arr.length - 1) {
            System.out.println("Stack if full!");
            return true;
        } else {
            return false;
        }
    }

    public void push(int value) {
        if (topOfStack == arr.length - 1) {
            System.out.println("Cannot insert! Stack is full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("Value is successfully inserted!");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            int topStack = arr[topOfStack];
            topOfStack--;
            return topStack;
        }
        return -1;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            return arr[topOfStack];

        }
        return -1;
    }
    public void deleteStack(){
        arr = null;
        System.out.println("Stack is deleted");
    }

    public static void main(String[] args) {
        stackstructure newStack = new stackstructure();
        newStack.createStack(4);
        // boolean result = newStack.isFull();
        // System.out.println(result);
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        // int result = newStack.peek();
        // System.out.println(result);
        newStack.deleteStack();

    }

}