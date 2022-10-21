import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class J07005_SoKhacNhauTrongFile_2 {
    public static void main(String[] args) throws IOException {
        DataInputStream dt = new DataInputStream(new FileInputStream("DATA.IN"));
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 100000; i++) {
            int x = dt.readInt();
            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        dt.close();
    }
}
