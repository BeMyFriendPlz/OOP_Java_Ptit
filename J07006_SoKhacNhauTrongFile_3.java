import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class J07006_SoKhacNhauTrongFile_3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> list = (ArrayList<Integer>) ois.readObject();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        ois.close();
    }
}
