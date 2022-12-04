package recursion;
public class sumofdigits {
    public static void main (String[] args) {
       sum(12345);
    }
    static int sum(int n){
      if(n==0){
        return 0;
      }else{
        int sum = n%10 + sum(n/10);
        System.out.println(sum);
        return sum;
      }
    }
    
}
