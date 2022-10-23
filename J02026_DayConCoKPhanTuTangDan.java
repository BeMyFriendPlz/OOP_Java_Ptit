import java.util.Arrays;
import java.util.Scanner;

public class J02026_DayConCoKPhanTuTangDan {
    private static int n;
    private static int k;
    private static int[] a = new int[20];
    private static int[] b = new int[20];

    public static void Try(int i) {
        for (int j = b[i-1] + 1; j <= n; j++) {
            b[i] = j;
            if(i == k) {
                for (int l = 1; l <= k; l++) {
                    System.out.print(a[b[l]] + " ");
                }
                System.out.println();
            } else Try(i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 1; i < n; i++) {
                for (int j = i+1; j <= n; j++) {
                    if(a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            b[0] = 0;
            Try(1);
        }
    }
}
