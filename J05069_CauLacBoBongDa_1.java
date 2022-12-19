import java.util.Scanner;

public class J05069_CauLacBoBongDa_1 {
    public static class CauLacBo {
        private String maCLB, tenCLB;
        private long giaVe;

        public CauLacBo(String maCLB, String tenCLB, long giaVe) {
            this.maCLB = maCLB;
            this.tenCLB = tenCLB;
            this.giaVe = giaVe;
        }

        public String getMaCLB() {
            return maCLB;
        }

        public String getTenCLB() {
            return tenCLB;
        }

        public long doanhThu(long cdv) {
            return giaVe * cdv;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        CauLacBo[] clb = new CauLacBo[n];
        for (int i = 0; i < n; i++) {
            clb[i] = new CauLacBo(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
        }
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String ma = sc.next();
            long cdv = sc.nextLong();
            for (int i = 0; i < n; i++) {
                if(clb[i].getMaCLB().equals(ma.substring(1,3))) {
                    System.out.println(ma + " " + clb[i].getTenCLB() + " " + clb[i].doanhThu(cdv));
                }
            }
        }
    }
}
