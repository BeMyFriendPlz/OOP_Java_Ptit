import java.util.Scanner;

public class J04014_TinhToanPhanSo {
    public static long UCLN(long a, long b){
        if(b == 0) return a;
        return UCLN(b, a%b);
    }

    public static class PhanSo {
        private long tu, mau;

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

        public PhanSo rutGon() {
            long ucln = UCLN(tu, mau);
            tu = tu/ucln;
            mau = mau/ucln;
            return new PhanSo(tu, mau);
        }

        public static PhanSo tong(PhanSo ps1, PhanSo ps2){
            return new PhanSo(ps1.getTu()* ps2.getMau() + ps2.getTu()* ps1.getMau(),
                    ps1.getMau()* ps2.getMau()).rutGon();
        }

        public static PhanSo tich(PhanSo ps1, PhanSo ps2){
            return new PhanSo(ps1.getTu() * ps2.getTu(), ps1.getMau() * ps2.getMau()).rutGon();
        }

        @Override
        public String toString() {
            return tu + "/" + mau;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            PhanSo ps1 = new PhanSo(sc.nextInt(), sc.nextInt());
            PhanSo ps2 = new PhanSo(sc.nextInt(), sc.nextInt());
            PhanSo ps3 = PhanSo.tich(PhanSo.tong(ps1, ps2),PhanSo.tong(ps1, ps2));
            PhanSo ps4 = PhanSo.tich(PhanSo.tich(ps1, ps2), ps3);
            System.out.println(ps3 + " " + ps4);
        }
    }
}
