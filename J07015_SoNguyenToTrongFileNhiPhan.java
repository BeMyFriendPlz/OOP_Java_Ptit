import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class J07015_SoNguyenToTrongFileNhiPhan {
    public static boolean Ngto(int n) {
        if(n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        List<Integer> list = (ArrayList<Integer>) ois.readObject();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if(Ngto(x)) {
                if(map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        ois.close();
    }
}
