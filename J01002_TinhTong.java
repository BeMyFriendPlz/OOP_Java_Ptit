import java.util.Scanner;

public class J01002_TinhTong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            long n = sc.nextInt();
            System.out.println((n+1)*n/2);
        }
    }
}
