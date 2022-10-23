import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J02009_XepHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i][0] > a[j][0]) {
                    int temp = a[i][0];
                    a[i][0] = a[j][0];
                    a[j][0] = temp;
                    temp = a[i][1];
                    a[i][1] = a[j][1];
                    a[j][1] = temp;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if(ans <= a[i][0]) {
                ans = a[i][0] + a[i][1];
            } else {
                ans = ans + a[i][1];
            }
        }
        System.out.println(ans);
    }
}
