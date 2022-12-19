import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class J07016_SoNguyenToTrongHaiFileNhiPhan {
    private static class SoNguyenTo {
        private Map<Integer, Integer> map;

        private boolean Ngto(int n) {
            if(n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) return false;
            }
            return true;
        }

        public SoNguyenTo(String file) throws IOException, ClassNotFoundException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            List<Integer> list = (ArrayList) ois.readObject();
            map = new TreeMap<>();
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
        }

        public Map<Integer, Integer> getMap() {
            return map;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SoNguyenTo snt1 = new SoNguyenTo("DATA1.in");
        SoNguyenTo snt2 = new SoNguyenTo("DATA2.in");
        for (int temp : snt1.getMap().keySet()) {
            if(snt2.getMap().containsKey(temp)) {
                System.out.println(temp + " " + snt1.getMap().get(temp) + " " + snt2.getMap().get(temp));
            }
        }
    }
}
