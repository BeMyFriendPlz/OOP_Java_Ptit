import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J03022_XuLyVanBan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.next().toLowerCase());
        }
        String vanBan = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            vanBan += " " + list.get(i);
        }
        String[] cau = vanBan.split("[.!?]");
        for (int i = 0; i < cau.length; i++) {
            String temp = cau[i].trim();
            System.out.println(temp.substring(0,1).toUpperCase() + temp.substring(1,temp.length()));
        }
    }
}
