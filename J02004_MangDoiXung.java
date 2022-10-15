import java.util.Scanner;

public class J02004_MangDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            boolean check = true;
            for (int i = 0; i <= n/2; i++) {
                if(a[i] != a[n-1-i]){
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
