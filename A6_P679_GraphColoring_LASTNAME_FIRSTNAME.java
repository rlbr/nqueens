import java.util.Scanner;
import java.io.*;

public class A6_P679_GraphColoring_LASTNAME_FIRSTNAME {

    public static String name = "LASTNAME_FIRSTNAME";

    // ***********************************************************************
    // In "main" below, you may comment out two of the calls in order to test
    // the method you are currently working on.
    //
    // When you turn this in, leave all methods uncommented (if you wrote all methods).
    //
    // *********************************************************************

    // Problem 6:
    // helper
    public static boolean colors_check(int k, int[][] W, int[] vcolor) {
        for (int i = 1; i < k; i++)
            if ((vcolor[i] == vcolor[k]) && (W[k][i] == 1))
                return false;
        return true;
    }

    public static int greedyColoring(int n, int[][] W, int[] vcolor) {
        int max_color = 0;
        vcolor[1] = 1;
        int start = 2;
        for (int i = start; i < n + 1; i++) {
            vcolor[i] = 1;
            while (!colors_check(i, W, vcolor))
                vcolor[i]++;
            max_color = Math.max(max_color, vcolor[i]);
        }
        return max_color;
    }

    // Problem 7

    public static boolean mColorableRec(int i, int n, int[][] W, int m, int[] vcolor) {
        if (colors_check(i + 1, W, vcolor)) {
            if (i < n) {
                boolean found = false;
                for (int color = 1; color <= m; color++) {
                    vcolor[i + 1] = color;
                    if (!found)
                        found = found || mColorableRec(i + 1, n, W, m, vcolor);
                    else
                        // only need one solution
                        return true;
                }
                // nothing was found in subcalls
                return false;
            }
        }
        // base case if vcolor is invalid
        return false;
    }
    // Problem 9 (YOU NEED TO HAVE DONE PROBLEM 8 TO DO PROBLEM 9)

    public static boolean fastTwoColor(int n, int[][] W, int[] vcolor) {
        A6_P8_IntQueue_LASTNAME_FIRSTNAME working_queue = new A6_P8_IntQueue_LASTNAME_FIRSTNAME();
        for (int i = 1; i < n + 1; i++)
            vcolor[i] = -1;
        vcolor[1] = 1;
        working_queue.enqueue(1);
        int vertex;
        while (!working_queue.isEmpty()) {
            vertex = working_queue.dequeue();
            // invert the color
            int color = ((vcolor[vertex] + 1) % 2) + 1;
            for (int i = 1; i < n + 1; i++) {
                if (W[vertex][i] == 1) {
                    if (vcolor[i] == -1) {
                        vcolor[i] = color;
                        working_queue.enqueue(i);
                    }
                    else if (vcolor[i] != color)
                        return false;
                }
            }
        }
        return true;
    }

    // ***********************************************************************
    // In "main" below, you may comment out two of the calls in order to test
    // only the one method you are working on.
    //
    // When you turn this in, leave all methods uncommented.
    //
    // *********************************************************************

    public static void main(String[] args) throws IOException {

        System.out.println("\n" + name);
        System.out.println("A6, P678, Graph Coloring Methods.\n");

        int n, test = 1;
        int[][] W;

        setUpGraphs();
        W = getNextGraph();
        n = W.length - 1;

        while (n > 0) {
            System.out.println("=============================================================");
            System.out.println("\nGraph " + test + ", size = " + n + "\n");

            test_Problem_6_greedyColoring(n, W, test);

            test_Problem_7_mColorableRec(n, W, test);

            test_Problem_8_fastTwoColor(n, W, test);

            W = getNextGraph();
            n = W.length - 1;
            test++;
        }
    }

    // ********************************************************************
    // DO NOT CHANGE ANYTHING BELOW THIS LINE
    //
    // *********************************************************************

    public static boolean mColorable(int n, int[][] W, int m, int[] vcolor) {

        return mColorableRec(0, n, W, m, vcolor);
    }

    public static Scanner input;

    public static void setUpGraphs() throws IOException {

        FileReader f = new FileReader("graphs.txt");
        input = new Scanner(f);
    }

    public static int[][] getNextGraph() {

        int n = input.nextInt();

        int[][] W = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                W[i][j] = input.nextInt();

        return W;
    }

    public static void test_Problem_6_greedyColoring(int n, int[][] W, int test) {

        int[] vcolor = new int[n + 1];

        long start = System.currentTimeMillis();
        int m = greedyColoring(n, W, vcolor);
        long end = System.currentTimeMillis();

        System.out.println(m + " colors are used by the Greedy Algorithm for Graph " + test + ":");
        printArray(n, vcolor);
        System.out.println("This took " + (end - start) + " milliseconds to run.\n");
    }

    public static void test_Problem_7_mColorableRec(int n, int[][] W, int test) {

        int[] vcolor = new int[n + 1];

        long start, end, startAll, endAll;

        int m = 1;

        start = System.currentTimeMillis();

        while (!(mColorable(n, W, m, vcolor))) {

            end = System.currentTimeMillis();
            System.out.print("This graph is NOT " + m + "-colorable.");
            System.out.println("  (" + (end - start) + " milliseconds to determine this.)");
            start = System.currentTimeMillis();
            m++;
        }

        end = System.currentTimeMillis();

        System.out.println(m + " colors are necessary for Graph " + test + ":");
        printArray(n, vcolor);
        System.out.println("It took " + (end - start) + " milliseconds to determine this.");
    }

    public static void test_Problem_8_fastTwoColor(int n, int[][] W, int test) {

        int[] vcolor = new int[n + 1];

        System.out.println("\nRunning fast two-coloring algorithm...");

        long start = System.currentTimeMillis();
        boolean found = fastTwoColor(n, W, vcolor);
        long end = System.currentTimeMillis();

        if (found) {
            System.out.println("2-coloring FOUND:");
            printArray(n, vcolor);
        }
        else
            System.out.println("No 2-coloring found!");

        System.out.println("This took " + (end - start) + " milliseconds to run.\n");
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
