import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07085_TongChuSo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<String> list = (ArrayList<String>) ois.readObject();
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).split("[^0-9]+");
            String ans = "";
            for (int j = 0; j < s.length; j++) {
                ans += s[j];
            }
            while (ans.charAt(0) == '0' && ans.length() > 1) ans = ans.substring(1,ans.length());
            int sum = 0;
            for (int j = 0; j < ans.length(); j++) {
                sum = sum + ans.charAt(j) - '0';
            }
            System.out.println(ans + " " + sum);
        }
    }
}
