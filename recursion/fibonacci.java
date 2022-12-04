package recursion;

public class fibonacci {
    static int n1 = 0, n2 = 1, n3 = 0;

    static void fibonaccitwo(int n) {

        // if(n == 0 || n == 1){
        // return n;
        // }
        // return fibonaccitwo(n-1) + fibonaccitwo(n-2);
        if (n > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.println(" " + n3);
            fibonaccitwo(n - 1);
        }

    }

    public static void main(String[] args) {
        // System.out.println(fibonaccitwo(12));
        System.out.println(n1 + " " + n2);
        fibonaccitwo(100 - 2);
    }

}
