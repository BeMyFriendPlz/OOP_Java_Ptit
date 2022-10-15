import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07022_LoaiBoSoNguyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        List<String> list = new ArrayList<>();
        while (sc.hasNext()){
            if(!sc.hasNextInt()) {
                list.add(sc.next());
            }else {
                sc.next();
            }
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
