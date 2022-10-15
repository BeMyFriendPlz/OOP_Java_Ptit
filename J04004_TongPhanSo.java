import java.util.Scanner;

public class J04004_TongPhanSo {
    public static class PhanSo {
        private long tu;
        private long mau;

        public PhanSo(long tu, long mau) {
            this.tu = tu;
            this.mau = mau;
        }

        public long getTu() {
            return tu;
        }

        public long getMau() {
            return mau;
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

        public static PhanSo Tong(PhanSo a, PhanSo b){
            long tu1 = a.getTu();
            long mau1 = a.getMau();
            long tu2 = b.getTu();
            long mau2 = b.getMau();
            return new PhanSo(tu1*mau2 + tu2*mau1, mau1*mau2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
        PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
        System.out.println(PhanSo.Tong(a,b).ToiGian());
    }
}
