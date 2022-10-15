import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J07007_LietKeTuKhacNhau {
    public static class WordSet {
        private File file;
        private Set<String> set;

        public WordSet(String file) throws FileNotFoundException {
            this.file = new File(file);
            set = new TreeSet<>();
            Xuly();
        }

        public void Xuly() throws FileNotFoundException {
            Scanner sc = new Scanner(this.file);
            while (sc.hasNext()){
                this.set.add(sc.next().toLowerCase());
            }
        }

        @Override
        public String toString() {
            String ans = "";
            for (String s : set) {
                ans += s + "\n";
            }
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}
