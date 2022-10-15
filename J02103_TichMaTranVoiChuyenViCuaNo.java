import java.util.Scanner;

public class J02103_TichMaTranVoiChuyenViCuaNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Long[][] a = new Long[n][m];
            Long[][] b = new Long[m][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    a[j][k] = b[k][j] = sc.nextLong();
                }
            }
            Long[][] c = new Long[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[j][k] = 0L;
                    for (int l = 0; l < m; l++) {
                        c[j][k] += a[j][l] * b[l][k];
                    }
                }
            }
            System.out.println("Test " + i +":");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(c[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
