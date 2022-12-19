import java.io.File;
import java.io.IOException;
import java.util.*;

public class J07009_LopIntSet_2 {
    private static class IntSet {
        private int[] a;

        public IntSet(int[] a) {
            this.a = a;
        }

        public int[] getA() {
            return a;
        }

        public IntSet intersection(IntSet s) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set1 = new TreeSet<>();
            for (int i = 0; i < a.length; i++) {
                set1.add(a[i]);
            }
            Set<Integer> set2 = new TreeSet<>();
            for (int i = 0; i < s.getA().length; i++) {
                set2.add(s.getA()[i]);
            }
            for (int temp : set2) {
                if(set1.contains(temp)) {
                    list.add(temp);
                }
            }
            int[] temp = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                temp[i] = list.get(i);
            }
            return new IntSet(temp);
        }

        @Override
        public String toString() {
            String s = "";
            for (int i = 0; i < a.length; i++) {
                s += String.valueOf(a[i]) + " ";
            }
            return s;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
