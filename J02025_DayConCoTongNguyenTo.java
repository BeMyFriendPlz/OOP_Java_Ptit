import java.util.Scanner;

public class J02025_DayConCoTongNguyenTo {
    private static int n;
    private static int[] a = new int[25];
    private static int[] b = new int[25];

    public static boolean Ngto(int n) {
        if(n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

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
                if(Ngto(sum)) {
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
