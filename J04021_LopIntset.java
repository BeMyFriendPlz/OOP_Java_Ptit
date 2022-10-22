import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J04021_LopIntset {
    public static class IntSet {
        private int[] a;

        public IntSet(int[] a) {
            this.a = a;
        }

        public int[] getA() {
            return a;
        }

        public IntSet union(IntSet s) {
            Set<Integer> set = new TreeSet<>();
            for (int x : a) {
                set.add(x);
            }
            for (int x : s.getA()) {
                set.add(x);
            }
            int[] temp = new int[set.size()];
            int i = 0;
            for (int x : set) {
                temp[i] = x;
                i++;
            }
            return new IntSet(temp);
        }

        @Override
        public String toString() {
            String ans = "";
            for (int x : a) {
                ans += String.valueOf(x) + " ";
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
