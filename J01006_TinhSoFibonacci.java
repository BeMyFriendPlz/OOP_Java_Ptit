import java.util.Scanner;

public class J01006_TinhSoFibonacci {
    public static void main(String[] args) {
        Long[] F = new Long[92];
        F[0] = F[1] = Long.valueOf(1);
        for (int i = 2; i < 92; i++) {
            F[i] = F[i-2] + F[i-1];
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            System.out.println(F[n-1]);
        }
    }
}
