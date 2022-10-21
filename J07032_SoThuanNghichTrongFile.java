import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class J07032_SoThuanNghichTrongFile {
    public static boolean ThuanNghich(String s) {
        if(s.length() < 2 || s.length() % 2 == 0) return false;
        for (int i = 0; i <= s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean SoLe(int n) {
        while (n > 0){
            int a = n % 10;
            if(a % 2 == 0) return false;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA1.in"));
        List<Integer> list1 = (ArrayList<Integer>) ois.readObject();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> list2 = (ArrayList<Integer>) is.readObject();

        int[] a = new int[1000001];
        for (int i = 0; i < list1.size(); i++) {
            a[list1.get(i)]++;
        }
        int[] b = new int[1000001];
        for (int i = 0; i < list2.size(); i++) {
            b[list2.get(i)]++;
        }
        int dem = 0;
        for (int i = 100; i < 1000001; i++) {
            if(a[i] > 0 && b[i] > 0 && SoLe(i) && ThuanNghich(String.valueOf(i))) {
                System.out.println(i + " " + (a[i] + b[i]));
                dem++;
            }
            if(dem == 10) break;
        }
        ois.close();
        is.close();
    }
}
