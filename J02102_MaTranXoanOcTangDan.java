import java.util.Arrays;
import java.util.Scanner;

public class J02102_MaTranXoanOcTangDan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n*n];
        for (int i = 0; i < n*n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int[][] b = new int[n][n];
        int d = 0, gt = 1, hang = n-1, cot = n-1, k = 0;
        while (d <= n/2) {
            for (int i = d; i <= cot; i++) b[d][i] = a[k++];
            for (int i = d+1; i <= hang; i++) b[i][cot] = a[k++];
            for (int i = cot-1; i >= d; i--) b[hang][i] = a[k++];
            for (int i = hang-1; i > d; i--) b[i][d] = a[k++];
            d++; hang--; cot--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
