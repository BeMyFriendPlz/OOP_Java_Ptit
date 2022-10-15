import java.math.BigInteger;
import java.util.Scanner;

public class J03016_ChiaHetCho11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger a = new BigInteger(sc.next());
            if(a.mod(new BigInteger("11")).equals(new BigInteger("0"))){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
