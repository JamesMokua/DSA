package arrays;

import java.util.Arrays;

public class maxproduct {
    public static void main(String[] args) {
         int[] arr = {10,20,30,40,50};
         int max = 0;
         int maxp = 0;
         int[] pairs = new int[2];
         for(int i =0; i < arr.length; i++){
            for(int j = i+1; j< arr.length; j++){
               max = arr[i] * arr[j];
               if(max > maxp){
                maxp = max;
                pairs = new int[] {arr[i],arr[j]};
               }
               
            }
         }
         System.out.println(Arrays.toString(pairs));
        
    }
    
}
