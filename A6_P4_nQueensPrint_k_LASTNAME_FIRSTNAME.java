public class A6_P4_nQueensPrint_k_LASTNAME_FIRSTNAME {

    public static String name = "LASTNAME_FIRSTNAME";

    public static void nQueens_Print_k_solns(int n, int k) {

        int[] col = new int[n + 1];
        nQueens_Print_k_solns_Rec(0, col, n, k);
    }

    // WRITE THIS ONE!
    // helper
    public static boolean check_col(int i, int[] col) {
        for (int x_1 = i; x_1 > 0; x_1--) {
            int y_1 = col[x_1];
            for (int x_2 = x_1 - 1; x_2 > 0; x_2--) {
                int y_2 = col[x_2];
                // same column
                if (y_1 == y_2)
                    return false;
                // same diagonal
                if (Math.abs(x_1 - x_2) == Math.abs(y_1 - y_2))
                    return false;
            }
        }
        return true;
    }

    public static void nQueens_Print_k_solns_Rec(int i, int[] col, int n, int k) {
        if (check_col(i, col)) {
            if (i < n) {
                for (int next = 1; next < n + 1; next++) {
                    col[i + 1] = next;
                    if (col[0] < k)
                        nQueens_Print_k_solns_Rec(i + 1, col, n, k);
                    else
                        return;
                }
            }
            else {
                col[0]++;
                printArray(n, col);
            }
        }
    }

    // ********************************************************************
    // DO NOT CHANGE ANYTHING BELOW THIS LINE!!!
    // *********************************************************************

    public static void main(String[] args) {

        System.out.println("\n" + name);
        System.out.println("A6_P4: nQueens, print k solutions.\n");

        for (int i = 4; i <= 11; i++) {
            for (int k = 1; k <= 7; k = 2 * k + 1) {
                System.out.println("\nCall to nQueens_Print_k_solns(" + i + ", " + k + "): \n ");
                nQueens_Print_k_solns(i, k);
            }
            System.out.println();
        }

        System.out.println();

    }

    public static void printArray(int n, int[] A) {
        for (int i = 1; i <= n; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static double INF = Double.POSITIVE_INFINITY;

    public static void printArray(int n, double[][] A) {
        int i, j;
        System.out.println();
        System.out.print("    ");

        for (i = 1; i <= n; i++)
            System.out.printf("%7d", i);
        System.out.println("\n");

        for (i = 1; i <= n; i++) {
            System.out.printf("%4d", i);
            for (j = 1; j <= n; j++)
                if (A[i][j] == INF)
                    System.out.print("    INF");
                else
                    System.out.printf("%7.0f", A[i][j]);

            System.out.println();
        }

        System.out.println();
    }

    public static void printArray(int n, int[][] A) {
        int i, j;
        System.out.println();
        System.out.print("    ");

        for (i = 1; i <= n; i++)
            System.out.printf("%7d", i);
        System.out.println("\n");

        for (i = 1; i <= n; i++) {
            System.out.printf("%4d", i);
            for (j = 1; j <= n; j++)
                System.out.printf("%7d", A[i][j]);
            System.out.println();
        }

        System.out.println();
    }

    public static void printArray(int n, long[][] A) {
        int i, j;
        System.out.println();
        System.out.print("    ");

        for (i = 1; i <= n; i++)
            System.out.printf("%7d", i);
        System.out.println("\n");

        for (i = 1; i <= n; i++) {
            System.out.printf("%4d", i);
            for (j = 1; j <= n; j++)
                System.out.printf("%7d", A[i][j]);
            System.out.println();
        }

        System.out.println();
    }

    public static void print2DArray(int n, int[][] A) {
        int i, j;
        System.out.println();
        System.out.print("    ");

        for (i = 0; i < n; i++)
            System.out.printf("%7d", i);
        System.out.println("\n");

        for (i = 0; i < n; i++) {
            System.out.printf("%4d", i);
            for (j = 0; j < n; j++)
                System.out.printf("%7d", A[i][j]);
            System.out.println();
        }

        System.out.println();
    }

    public static void printArray(int n, double[] A) {

        for (int j = 0; j < n; j++)
            System.out.print(A[j] + " ");
        System.out.println();
    }

    public static void printArray(int n, short[] A) {

        for (int j = 0; j < n; j++)
            System.out.print(A[j] + " ");
        System.out.println();
    }

    public static void printArray(int n, byte[] A) {

        for (int j = 0; j < n; j++)
            System.out.print(A[j] + " ");
        System.out.println();
    }

    public static void sop(int a) {
        System.out.print(a);
    }

    public static void sopln(int a) {
        System.out.println(a);
    }

    public static void sop(double a) {
        System.out.print(a);
    }

    public static void sopln(double a) {
        System.out.println(a);
    }

    public static void sop(byte a) {
        System.out.print(a);
    }

    public static void sopln(byte a) {
        System.out.println(a);
    }

    public static void sop(boolean a) {
        System.out.print(a);
    }

    public static void sopln(boolean a) {
        System.out.println(a);
    }

    public static void sop(String s) {
        System.out.print(s);
    }

    public static void sopln(String s) {
        System.out.println(s);
    }

    public static void sopln() {
        System.out.println();
    }

}
