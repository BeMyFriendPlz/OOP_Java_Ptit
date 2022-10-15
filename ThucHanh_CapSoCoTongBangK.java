import java.util.*;

public class ThucHanh_CapSoCoTongBangK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Long n = sc.nextLong();
            Long k = sc.nextLong();
            Map<Long, Long> m = new HashMap<>();
            for (Long i = 0L; i < n; i++) {
                Long x = sc.nextLong();
                if(m.get(x) == null){
                    m.put(x, 1L);
                } else {
                  m.put(x, m.get(x) + 1);
                }
            }
            Long ans = 0L;
            for (Long x : m.keySet()) {
                if(x * 2 == k) {
                    ans += m.get(x)*(m.get(x) - 1);
                } else {
                    ans += m.get(x)*(m.get(k - x) == null ? 0 : m.get(k - x));
                }
            }
            System.out.println(ans/2);
        }
    }
}
