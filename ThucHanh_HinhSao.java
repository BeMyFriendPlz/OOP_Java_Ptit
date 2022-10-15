import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThucHanh_HinhSao {
    public static Map<Integer, Integer> m = new HashMap<>();;

    public static void Them(int x) {
        if(m.get(x) == null) {
            m.put(x, 1);
        }else {
            m.put(x, m.get(x) + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Them(a);
            Them(b);
        }
        boolean check = false;
        for (Integer x : m.keySet()) {
            if(m.get(x) == n-1) {
                check = true;
                break;
            }
        }
        if(check) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
