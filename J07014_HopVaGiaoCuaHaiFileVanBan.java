import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class J07014_HopVaGiaoCuaHaiFileVanBan {
    private static class WordSet {
        private Set<String> set;

        public WordSet(String data) throws FileNotFoundException {
            set = new TreeSet<>();
            Scanner sc = new Scanner(new File(data));
            while (sc.hasNextLine()) {
                String[] x = sc.nextLine().toLowerCase().split("\\s+");
                for (String temp : x) {
                    set.add(temp);
                }
            }
        }

        public Set<String> getSet() {
            return set;
        }

        public String union(WordSet s) {
            Set<String> ans = new TreeSet<>();
            ans.addAll(set);
            ans.addAll(s.getSet());
            String res = "";
            for (String temp : ans) {
                res += temp + " ";
            }
            return res;
        }

        public String intersection(WordSet s) {
            String ans = "";
            for (String temp : s.getSet()) {
                if(set.contains(temp)) {
                    ans += temp + " ";
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("D:\\DATA1.in");
        WordSet s2 = new WordSet("D:\\DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
