import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J07004_SoKhacNhauTrongFile_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        Map<Integer, Integer> map = new TreeMap<>();
        while (sc.hasNext()){
            int x = sc.nextInt();
            if(!map.containsKey(x)){
                map.put(x,1);
            }else {
                map.put(x, map.get(x) + 1);
            }
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
