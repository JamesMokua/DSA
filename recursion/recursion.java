package recursion;
public class recursion {
    public static void main (String[] args) {
      
        hello(10);
    }
     static int hello(int n){
        // int i = 0;
        // int power = 1;
        // while(i < n){
        //     power = power * 2;
        //     i = i + 1;
        // }
        //  System.out.println(power);
      if(n == 0){
        return 1;
      }else{
        int power = 2 * hello(n-1);
        System.out.println(power);
        return power;
      }
      

    }
}