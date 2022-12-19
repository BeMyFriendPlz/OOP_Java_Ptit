import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J07024_HieuCuaHaiTapTu {
    public static class WordSet {
        private Set<String> set;

        public WordSet(String file) throws FileNotFoundException {
            Scanner sc = new Scanner(new File(file));
            set = new TreeSet<>();
            while (sc.hasNextLine()) {
                String[] s = sc.nextLine().trim().toLowerCase().split("\\s+");
                for (String temp : s) {
                    set.add(temp);
                }
            }
        }

        public String difference(WordSet s) {
            String ans = "";
            for (String temp : set) {
                if(!s.set.contains(temp)) {
                    ans += temp + " ";
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
