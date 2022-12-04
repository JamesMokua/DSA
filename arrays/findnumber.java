package arrays;

public class findnumber {
    public static void main(String[] args) {
        int value = 6;
        int[] arr = {1,9,8,3,4,6,2,5};     
        for(int i =0; i < arr.length; i++){
            if(arr[i] == value){
              System.out.println("The value is: " +arr[i]+" found at index: " +i);
            }
        }   
      
    }
}
