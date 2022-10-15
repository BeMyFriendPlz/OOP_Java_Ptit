import java.util.Scanner;

public class J01021_TinhLuyThua {
    public static long mod = (long) (1e9+7);

    public static long Pow(long a, long b){
        if(b == 0) return 1;
        long x = Pow(a,b/2);
        if(b%2==0) return x*x%mod;
        else return (x*(x*a%mod))%mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a,b;
        while (true){
            a = sc.nextLong();
            b = sc.nextLong();
            if (a ==0 && b == 0) break;
            else System.out.println(Pow(a,b));
        }
    }
}
