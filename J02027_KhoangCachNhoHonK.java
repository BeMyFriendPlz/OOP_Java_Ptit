import java.util.*;

public class J02027_KhoangCachNhoHonK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            long ans = 0;
            int temp = 1;
            boolean check1 = true;
            for (int i = 0; i < n; i++) {
                boolean check2 = false;
                for (int j = temp; j < n && check1; j++) {
                    if(a[j] - a[i] >= k) {
                        temp = j;
                        check2 = true;
                        break;
                    }
                }
                if(check2) {
                    ans += temp - i -1;
                } else {
                    ans += n-i-1;
                    check1 = false;
                }
            }
            System.out.println(ans);
        }
    }
}
