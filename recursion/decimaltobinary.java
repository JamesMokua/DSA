package recursion;
public class decimaltobinary {
    public static void main (String[] args) {
        System.out.println(decimaltobinarytwo(23));
    }
    static int decimaltobinarytwo(int n){
        if(n == 0){
            return 0;
        }
        return n%2 + 10 * decimaltobinarytwo(n/2);
    }
}
