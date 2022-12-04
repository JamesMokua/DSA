package recursion;

public class factorial {
    public static void main (String[] args) {
        System.out.println(factorialtwo(4));
    }
    static int factorialtwo(int n){
        if(n == 0){
            return 1;
        }
        return n * factorialtwo(n-1);
    }
}
