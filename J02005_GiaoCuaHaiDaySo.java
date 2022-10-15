import java.util.*;

public class J02005_GiaoCuaHaiDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            set2.add(sc.nextInt());
        }
        for (int temp : set1) {
            if(set2.contains(temp)){
                System.out.print(temp + " ");
            }
        }
    }
}
