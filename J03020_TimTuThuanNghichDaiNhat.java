import java.util.*;

public class J03020_TimTuThuanNghichDaiNhat {
    public static boolean ThuanNghich(String s) {
        int n = s.length();
        for (int i = 0; i <= n/2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        int length = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            if(ThuanNghich(s)) {
                if(s.length() > length) {
                    map.clear();
                    length = s.length();
                }
                if(s.length() == length) {
                    if(map.get(s) == null) {
                        map.put(s, 1);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                }
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
