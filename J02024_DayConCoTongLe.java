import java.util.*;

public class J02024_DayConCoTongLe {
    private static int n;
    private static int[] a = new int[25];
    private static int[] b = new int[25];

    public static void Try(int i) {
        for (int j = 0; j <= 1; j++) {
            b[i] = j;
            if(i == n) {
                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    if(b[k] == 1) {
                        sum += a[k];
                    }
                }
                if(sum % 2 == 1) {
                    for (int k = 1; k <= n; k++) {
                        if(b[k] == 1) {
                            System.out.print(a[k] + " ");
                        }
                    }
                    System.out.println();
                }
            } else if(i <= n + 1) Try(i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 1; i <= n-1; i++) {
                for (int j = i+1; j <= n; j++) {
                    if(a[i] < a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            Try(1);
        }
    }
}
