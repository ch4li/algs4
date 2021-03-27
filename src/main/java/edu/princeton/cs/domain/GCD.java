package edu.princeton.cs.domain;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author amazm
 * 最大公约数
 */
public class GCD {

    public static void main(String[] args) {
        matrixIndex2Primes();
//        printMatrix(6);
        //        int depth = 0;
//        superEuclid(1_111_111, 1_234_567, depth);
//        superEuclid(1_234_567,1_111_111, depth);
//        superEuclid(24, 105, depth);
//        superEuclid(105, 24, depth);
//        superEuclid(0, 24, depth);
    }


    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static int Euclid(int p, int q, int depth) {
        // 增加输出深度
        System.out.print(depth);
        System.out.println("  p=" + p + " " + "q=" + q);

        if (q == 0) {
            System.out.println("最大公约数: " + p);
            return p;
        }
        int r = p % q;
        return Euclid(q, r, depth + 1);
    }

    public static int superEuclid(int p, int q, int depth) {

        System.out.print(depth);
        System.out.println("  p=" + p + " " + "q=" + q);

        if (p == 0 || q == 0) {
            return 1;
        }
        if (p < q) {
            int t = p;
            p = q;
            q = t;
        }
        if (p % q == 0) {
            System.out.println("最大公约数: " + q);
            return q;
        } else {
            return superEuclid(q, p % q, depth + 1);
        }
    }

    public static int Euclid(int p, int q) {


        if (p == 0 || q == 0) {
            return 1;
        }
        if (p < q) {
            int t = p;
            p = q;
            q = t;
        }
        if (p % q == 0) {
            return q;
        } else {
            return Euclid(q, p % q);
        }
    }

    // 储存互为质数的索引值的真值

    public static boolean[][] indexEuclid(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Euclid(i, j) == 1;
            }
        }
        return matrix;
    }
    public static void printMatrix(int N) {
        // 创建N*N数组,储存索引为互质数的布尔值,打印表格
        boolean[][] a = new boolean[N][N];
        boolean[][] booleans = indexEuclid(a);

        for (int i = 0; i < booleans.length; i++) {
            System.out.printf("%2s", i);
            for (int j = 0; j < booleans[i].length; j++) {
                System.out.printf("%6b", booleans[i][j]);
            }
            System.out.println();

        }
    }

    /** 储存遍历的同时直接打印
     */
    public static void matrixIndex2Primes() {
        System.out.println("请输入二维数组N*N的边长:");
        int N = StdIn.readInt();
        boolean[][] matrix = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Euclid(i, j) == 1;
                System.out.printf("%6b", matrix[i][j]);
            }
            System.out.println();
        }
    }


}
