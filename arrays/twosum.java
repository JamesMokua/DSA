package arrays;
import java.util.*;

public class twosum {
    public static void main(String[] args){
        int val = 7;
        int[] arr = {3,4,5,2,6,1};
        for(int i =0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] + arr[j] == val){
                    System.out.println(Arrays.toString(new int[] {i, j}));
                }
            }
        }
    }
    
}
