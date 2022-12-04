package arrays;

public class missingnumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14,15,16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
                29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
        int sum1 = 0;
        int sum2 = 0;
        int n = 40;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];

        }
        for (int j = 1; j <= n; j++) {
            sum2 += j;
        }
        int ans = sum2 - sum1;
        System.out.println(ans);
    }

}
