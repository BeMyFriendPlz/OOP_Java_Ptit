import java.util.Scanner;
import java.util.Stack;

public class J08022_PhanTuBenPhaiDauTienLonHon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] R = new int[n];
            Stack<Integer> st = new Stack<>();
            for (int i = n-1; i >= 0; i--) {
                while (!st.empty() && st.peek() <= a[i]) st.pop();
                if(st.empty()) {
                    R[i] = -1;
                } else {
                    R[i] = st.peek();
                }
                st.push(a[i]);
            }
            for (int i = 0; i < n; i++) {
                System.out.print(R[i] + " ");
            }
            System.out.println();
        }
    }
}
