package binaryheap;

public class binaryheap {
    int arr[];
    int sizeOfTree;

    public binaryheap(int size){
        arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap has been created");
    }
    public boolean isEmpty(){
        if(sizeOfTree == 0){
            return true;
        }else{
            return false;
        }
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Binary Heap is empty");
            return -1;
        }else{
            return arr[1];
        }
    }
    public int sizeOfBH(){
        return sizeOfTree;
    }
    public void levelOrder(){
      for(int i = 1; i<=sizeOfTree;i++){
        System.out.print(arr[i] + " ") ;
      }
      System.out.println();
    }

    // Heapify for Insert
    public void heapifyBottomToTop(int index, String heapType){
        int parent = index/2;
        if(index <= 1){
            return;
        }
        if(heapType == "Min"){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }else if(heapType == "Max"){
            if(arr[index] > arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }

        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String typeHeap){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, typeHeap);
    }
    
     // heapifyTopToBottom
  public void heapifyTopToBottom(int index, String heapType) {
    int left = index*2;
    int right = index*2 + 1;
    int swapChild = 0;
    if (sizeOfTree < left) {
      return;
    }
    if (heapType == "Max") {
      if (sizeOfTree == left) {
        if (arr[index] < arr[left]) {
          int tmp = arr[index];
          arr[index] = arr[left];
          arr[left] = tmp;
        }
        return;
      } else {
        if (arr[left]>arr[right]) {
          swapChild = left;
        } else {
          swapChild = right;
        }
        if (arr[index] < arr[swapChild]) {
          int tmp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = tmp;
        }
      }
    } else if (heapType == "Min") {
      if (sizeOfTree == left) {
        if (arr[index] > arr[left]) {
          int tmp = arr[index];
          arr[index] = arr[left];
          arr[left] = tmp;
        }
        return;
      } else {
        if (arr[left] < arr[right]) {
          swapChild = left;
        } else {
          swapChild = right;
        }
        if (arr[index] > arr[swapChild]) {
          int tmp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = tmp;
        }
      }
    }
    heapifyTopToBottom(swapChild, heapType);
  }

  public int extractHeadOfBP(String heapType) {
    if (isEmpty()) {
      return -1;
    } else {
      int extractedValue = arr[1];
      arr[1] = arr[sizeOfTree];
      sizeOfTree--;
      heapifyTopToBottom(1, heapType);
      return extractedValue;
    }
  }

  // delete
  public void deleteBH() {
    arr = null;
    System.out.println("BH has been successfully deleted");
  }

    public static void main(String[] args){
        binaryheap bh = new binaryheap(5);
        bh.insert(10, "Min");
        bh.insert(5, "Min");
        bh.insert(15,"Min");
        bh.insert(1, "Min");
        bh.levelOrder();
        // bh.insert(10, "Max");
        // bh.insert(5, "Max");
        // bh.insert(15,"Max");
        // bh.insert(1, "Max");
        // bh.levelOrder();
        bh.extractHeadOfBP("Min");
        bh.levelOrder();
        
    }
}
