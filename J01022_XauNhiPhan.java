import java.util.Scanner;

public class J01022_XauNhiPhan {
    public static Long[] F = new Long[93];

    public static void SetFibo(){
        F[0] = 0L;
        F[1] = 1L;
        for (int i = 2; i < 93; i++) {
            F[i] = F[i-2] + F[i-1];
        }
    }

    public static int XuLy(int n, long k){
        if(n==1) return 0;
        if(n==2) return 1;
        if(k <= F[n-2]) return XuLy(n-2, k);
        else return XuLy(n-1, k - F[n-2]);
    }

    public static void main(String[] args) {
        SetFibo();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(XuLy(n,k));
        }
    }
}
