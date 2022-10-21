import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class J07040_LietKeTheoThuTuXuatHien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        List<String> list = (ArrayList<String>) ois.readObject();
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).trim().toLowerCase().split("\\s+");
            set.addAll(Arrays.asList(s));
        }
        Scanner sc = new Scanner(new File("VANBAN.in"));
        while (sc.hasNext()) {
            String s = sc.next().toLowerCase();
            if(set.contains(s)) {
                System.out.println(s);
                set.remove(s);
            }
        }
        ois.close();
    }
}
