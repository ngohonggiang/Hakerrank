public class DynamicProgramming_Recursion {
    /**
     * fibonacci
     */
    // Recursion
    // top-down
    int fi(int n) {
        if (n <= 1) return n;
        return fi(n - 1) + fi(n - 2);
    }

    // DynamicProgramming
    // bottom-up
    int fib(int n) {
        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    /**
     * knapsack
     */
    // Recursion
    // TH1: ko lay -> knapsack(weightMax, w, val, n - 1)
    // TH2: lay -> val[n - 1] + knapsack(weightMax - w[n - 1], w, val, n - 1)
    static int knapsack (int weightMax, int[] w, int[] val, int n) {
        if (n == 0 || weightMax == 0) return 0;
        return Math.max(knapsack(weightMax, w, val, n - 1),
                val[n - 1] + knapsack(weightMax - w[n - 1], w, val, n - 1));
    }

    // DynamicProgramming
    static int knapsackDP (int weightMax, int[] w, int[] val, int n) {
        int[][] a = new int[n + 1][ weightMax + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= weightMax; j++) {
                if (i == 0 || j == 0) a[i][j] = 0;
                else {
                    if (w[i - 1] <= j) {
                        a[i][j] = Math.max(a[i - 1][j], val[i - 1] + a[i - 1][j - w[i - 1]]);
                    } else a[i][j] = a[i - 1][j];
                }
            }
        }
        return a[n][weightMax];
    }

    /**
     * length of longest common substring
     */
    // DynamicProgramming
    static int lcs(String s1, String s2, int n, int m) {
        int[][] str = new int[n + 1][m + 1];
        int result = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) str[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        str[i][j] = 1 + str[i - 1][j - 1];
                        result = Math.max(result, str[i][j]);
                    } else str[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*int val[] = new int[] { 10, 15, 40 };
        int wt[] = new int[] { 1, 2, 3 };
        int W = 6;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
        System.out.println(knapsackDP(W, wt, val, n));*/

        String a = "abab";
        String b = "baba";

        System.out.println(lcs(a, b, a.length(), b.length()));

    }
}
