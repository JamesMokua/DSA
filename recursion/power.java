package recursion;
public class power {
    public static void main (String[] args) {
      
       System.out.println(hello(10,2)); 
    }
     static int hello(int base, int exp){
       if(exp < 0){
        return -1;
       }
       if(exp == 0 || exp == 1){
        return base;
       }
      
       return base * hello(base, exp-1);

      
    }
}
