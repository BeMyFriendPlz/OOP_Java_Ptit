import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J03009_TapTuRiengCuaHaiXau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            Set<String> set = new TreeSet<>(Arrays.asList(s1.split("[^a-zA-Z]+")));
            for (String temp : set) {
                if(!s2.contains(temp)) {
                    System.out.print(temp + " ");
                }
            }
            System.out.println();
        }
    }
}
