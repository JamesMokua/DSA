package searchingalgorithms;

public class linearsearch{


 public int linearSearch(int arr[], int value){
 for(int i = 0; i < arr.length;i++){
    if(arr[i] == value){
        System.out.println("The element is found at index "+i);
        return i;
    }
 }
 System.out.println("The element "+value+" is not found");
 return -1;
 }

 public static void main(String[] args){
int[] arr = {1,3,2,10,23,11};
linearsearch ls = new linearsearch();
ls.linearSearch(arr, 3);
 }
}