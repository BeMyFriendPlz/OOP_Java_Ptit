import java.util.*;

public class J04022_Wordset {
    public static class WordSet {
        private String s;

        public WordSet(String s) {
            this.s = s.trim().toLowerCase();
        }

        public String getS() {
            return s;
        }

        public String union(WordSet temp) {
            Map<String, Integer> map = new TreeMap<>();
            String[] a1 = s.split(" ");
            Set<String> set = new TreeSet<>(Arrays.asList(a1));
            for (String x : set) {
                map.put(x, 1);
            }
            String[] a2 = temp.getS().split(" ");
            set = new TreeSet<>(Arrays.asList(a2));
            for (String x : set) {
                if(map.containsKey(x)) {
                    map.put(x, map.get(x)+1);
                } else {
                    map.put(x, 1);
                }
            }
            String ans = "";
            for (String x : map.keySet()) {
                ans += x + " ";
            }
            return ans;
        }

        public String intersection(WordSet temp) {
            Map<String, Integer> map = new TreeMap<>();
            String[] a1 = s.split(" ");
            Set<String> set = new TreeSet<>(Arrays.asList(a1));
            for (String x : set) {
                map.put(x, 1);
            }
            String[] a2 = temp.getS().split(" ");
            set = new TreeSet<>(Arrays.asList(a2));
            for (String x : set) {
                if(map.containsKey(x)) {
                    map.put(x, map.get(x)+1);
                } else {
                    map.put(x, 1);
                }
            }
            String ans = "";
            for (String x : map.keySet()) {
                if(map.get(x) > 1) {
                    ans += x + " ";
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
