import java.security.KeyPair;
import java.util.*;

public class J02007_DemSoLanXuatHien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            Map<Integer,Integer> map = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if(map.containsKey(x)){
                    map.put(x, map.get(x) + 1);
                }else{
                    map.put(x, 1);
                }
            }
            System.out.println("Test " + i + ":");
            for (Integer key : map.keySet()) {
                System.out.println(key + " xuat hien " + map.get(key) + " lan");
            }
        }
    }
}
