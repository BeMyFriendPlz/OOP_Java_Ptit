import java.util.Scanner;

public class J01009_TongGiaThua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long sum = 0, gt = 1;
        for (int i = 1; i <= a; i++) {
            gt *= i;
            sum += gt;
        }
        System.out.println(sum);
    }
}
