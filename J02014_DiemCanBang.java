import java.util.Scanner;

public class J02014_DiemCanBang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n+5];
            long sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum1 += a[i];
            }
            boolean check = false;
            for (int i = 0; i < n; i++) {
                sum1 -= a[i];
                if(sum1 == sum2){
                    System.out.println(i+1);
                    check = true;
                    break;
                }
                sum2 += a[i];
            }
            if (!check){
                System.out.println(-1);
            }
        }
    }
}
