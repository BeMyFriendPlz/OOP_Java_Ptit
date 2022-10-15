import java.util.Scanner;

public class J01004_SoNguyenTo {
    public static boolean Ngto(long n){
        if(n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            long n = sc.nextLong();
            if (Ngto(n)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
