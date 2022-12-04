package arrays;

public class isUnique {
    public static void main(String[] args) {
        int[] arr ={10,20,30,40,50};
        boolean result = isUniquetwo(arr);
        System.out.println(result);
   
    
}

public static boolean isUniquetwo(int[] array){
    for(int i = 0; i < array.length; i++){
        for(int j = i+1; j< array.length;j++){
            if(array[i] == array[j]){
              return false;
            }
        }

    }
    return true;
}
}
