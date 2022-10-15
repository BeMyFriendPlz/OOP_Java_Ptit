import java.util.Arrays;
import java.util.Scanner;

public class J02016_BoBaSoPytago {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
            boolean ok = false;
            for (int i = 0; i < n-2; i++) {
                if(ok) break;
                long c1 = a[i] * a[i];
                for (int j = i+1; j < n-1; j++) {
                    if(ok) break;
                    long c2 = a[j] * a[j];
                    if(Math.pow((long) Math.sqrt(c1 + c2),2) == (c1 + c2)) {
                        for (int k = j+1; k < n; k++) {
                            if(a[k] * a[k] == (c1 + c2)) {
                                ok = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(ok) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
