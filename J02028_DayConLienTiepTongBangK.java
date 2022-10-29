import java.util.Scanner;

public class J02028_DayConLienTiepTongBangK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n + 1];
            a[0] = 0;
            for (int i = 1; i <= n; i++) {
                long x = sc.nextLong();
                a[i] = a[i-1] + x;
            }
            boolean check = false;
            for (int i = 1; i <= n; i++) {
                int l = i;
                int r = n;
                while (l <= r) {
                    int x = (l + r) / 2;
                    if(a[x] - a[i-1] == k) {
                        check = true;
                        break;
                    } else if (a[x] - a[i-1] > k) {
                        r = x - 1;
                    } else {
                        l = x + 1;
                    }
                }
                if(check) break;
            }
            if(check){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
