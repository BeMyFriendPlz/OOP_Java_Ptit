import java.math.BigInteger;
import java.util.*;

public class J03066_NhoNhatVaLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = Integer.parseInt(sc.nextLine());
            if(n == 0) break;
            else {
                List<BigInteger> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list.add(new BigInteger(sc.nextLine()));
                }
                Collections.sort(list, new Comparator<BigInteger>() {
                    @Override
                    public int compare(BigInteger o1, BigInteger o2) {
                        return o1.compareTo(o2);
                    }
                });
                if(list.get(0).equals(list.get(list.size()-1))){
                    System.out.println("BANG NHAU");
                } else {
                    System.out.println(list.get(0) + " " + list.get(list.size()-1));
                }
            }
        }
    }
}
