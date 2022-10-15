import java.util.Scanner;

public class J01014_UocSoNguyenToLonNhat {
    public static boolean KtNgto(long n){
        if(n == 2 || n == 3) return true;
        if(n < 2 || n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i+=6) {
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }

    public static long Uoc(long n){
        long ans = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i == 0){
                if(KtNgto(n/i)) return n/i;
                else if(KtNgto(i)) ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();
            System.out.println(Uoc(n));
        }
    }
}
