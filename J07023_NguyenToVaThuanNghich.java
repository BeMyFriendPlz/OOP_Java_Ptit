import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class J07023_NguyenToVaThuanNghich {
    private static class DaySo {
        private Map<Integer, Integer> map;

        private boolean Ngto(int n) {
            if(n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) return false;
            }
            return true;
        }

        private boolean ThNghich(int n) {
            String s = String.valueOf(n);
            for(int i = 0; i <= s.length()/2; i++) {
                if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
            }
            return true;
        }

        public DaySo(String file) throws IOException, ClassNotFoundException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            List<Integer> list = (ArrayList) ois.readObject();
            map = new TreeMap<>();
            for (int x : list) {
                if(Ngto(x) && ThNghich(x)) {
                    if(map.containsKey(x)) {
                        map.put(x, map.get(x) + 1);
                    } else {
                        map.put(x , 1);
                    }
                }
            }
        }

        public Map<Integer, Integer> getMap() {
            return map;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DaySo ds1 = new DaySo("DATA1.in");
        DaySo ds2 = new DaySo("DATA2.in");
        for (int key : ds1.getMap().keySet()) {
            if(ds2.getMap().containsKey(key)) {
                System.out.println(key + " " + ds1.getMap().get(key) + " " + ds2.getMap().get(key));
            }
        }
    }
}
