import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class J07030_CapSoNguyenToTrongFile_1 {
    public static boolean Ngto(long n) {
        if(n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA1.in"));
        List<Integer> list1 = (ArrayList<Integer>) ois.readObject();
        int[] a = new int[1000001];
        for (int i = 0; i < list1.size(); i++) {
            int x = list1.get(i);
            if(Ngto(x)) {
                a[x]++;
            }
        }
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> list2 = (ArrayList<Integer>) is.readObject();
        for (int i = 2; i < 500000; i++) {
            if(a[i] > 0) {
                int x = 1000000 - i;
                if(Ngto(x) && list2.contains(x)) {
                    System.out.println(i + " " + x);
                }
            }
        }
        ois.close();
        is.close();
    }
}
