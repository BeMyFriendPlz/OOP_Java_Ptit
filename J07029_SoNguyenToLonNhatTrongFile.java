import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class J07029_SoNguyenToLonNhatTrongFile {
    public static boolean Ngto(int n) {
        if(n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> list = (ArrayList<Integer>) ois.readObject();
        int[] a = new int[1000001];
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if(Ngto(x)) {
                a[x]++;
            }
        }
        int p = 0;
        for (int i = 1000000; i >= 2; i--) {
            if (a[i] > 0) {
                System.out.println(i + " " + a[i]);
                p++;
                if (p == 10)
                    break;
            }
        }
        ois.close();
    }
}
