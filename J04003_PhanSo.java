import java.util.Scanner;

public class J04003_PhanSo {
    public static class PhanSo {
        private long tu;
        private long mau;

        public PhanSo(long tu, long mau) {
            this.tu = tu;
            this.mau = mau;
        }

        public long gcd(long a, long b){
            if(b == 0) return a;
            return gcd(b, a%b);
        }

        public String ToiGian(){
            long gcd = this.gcd(tu,mau);
            tu = tu/gcd;
            mau = mau/gcd;
            return tu + "/" + mau;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
        System.out.println(a.ToiGian());
    }
}
