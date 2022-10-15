import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J02006_HopCuaHaiDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            set.add(sc.nextInt());
        }
        for (int temp : set) {
            System.out.print(temp + " ");
        }
    }
}
