import java.util.Scanner;

public class J04020_LopPair {
    public static class Pair<T1, T2> {
        private T1 x;
        private T2 y;

        public Pair(T1 x, T2 y) {
            this.x = x;
            this.y = y;
        }

        public boolean Ngto(long n){
            if(n < 2) return false;
            for (int i = 2; i*i <= n; i++) {
                if(n % i == 0) return false;
            }
            return true;
        }

        public boolean isPrime() {
            if(Ngto((Integer) x) && Ngto((Integer) y)) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}
