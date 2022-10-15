import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class J03017_LoaiBo100 {
    public static class Pair {
        private char first;
        private int second;

        public Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }

        public char getFirst() {
            return first;
        }

        public void setFirst(char first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String s = sc.nextLine();
            int ans = 0;
            Vector<Pair> vector = new Vector<>();
            vector.add(new Pair('2',-1));
            for (int i = 0; i < s.length(); i++) {
                vector.add(new Pair(s.charAt(i),i));
                while(vector.size() >= 3 && vector.get(vector.size()-3).getFirst() == '1' &&
                        vector.get(vector.size()-2).getFirst() == '0' && vector.get(vector.size()-1).getFirst() == '0'){
                    for (int j = 0; j < 3; j++) {
                        vector.remove(vector.lastElement());
                    }
                }
                ans = Math.max(ans,i - vector.lastElement().getSecond());
            }
            System.out.println(ans);
        }
    }
}
