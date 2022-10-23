import java.math.BigInteger;
import java.util.Scanner;

public class JAHA003_ChiaHetCho11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            BigInteger b = new BigInteger(sc.nextLine());
            if(b.mod(new BigInteger("11")).equals(new BigInteger("0"))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
