import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07076_SapXepMaTran {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] a = new int[n+5][m+5];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = i+1; j <= n; j++) {
                    if(a[i][k] > a[j][k]) {
                        int temp = a[i][k];
                        a[i][k] = a[j][k];
                        a[j][k] = temp;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
