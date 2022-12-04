package recursion;

public class reversestring {
    static void reverse(String str){
        if(str.length() == 0){
            return;
        }
        // reverse(str.substring(1));
        // System.out.print(str.charAt(0));
       char arr [] = str.toCharArray();      
         for(int i = arr.length-1; i>=0; i--){
              System.out.print(arr[i]);
         }
    }
    public static void main(String[] args) {
        String str = "Hello World";
    reverse(str);
    }
  
}
