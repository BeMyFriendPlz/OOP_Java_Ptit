import java.util.Scanner;

public class J02008_BoiSoNhoNhatCuaNSoNguyenDuongDauTien {
    public static long UCLN(long a, long b){
        long temp;
        while (b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static long BCNN(long a, long b){
        return (a / UCLN(a,b)) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            long ans = 1;
            for (int i = 2; i <= n; i++) {
                ans = BCNN(ans,i);
            }
            System.out.println(ans);
        }
    }
}