package recursion;
public class gcd {
    public static void main (String[] args) {
        System.out.println(gcdtwo(3,12));
    }
    static int gcdtwo(int a, int b){
        if(b == 0){
            return a;
        }
        return gcdtwo(b, a%b);
    }
}
