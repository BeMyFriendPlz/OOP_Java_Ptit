import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05070_CauLacBoBongDa_2 {
    public static class CauLacBo {
        private String maCLB, tenCLB, maTran;
        private long giaVe, tien;

        public CauLacBo(String maCLB, String tenCLB, long giaVe) {
            this.maCLB = maCLB;
            this.tenCLB = tenCLB;
            this.giaVe = giaVe;
        }

        public void setMaTran(String maTran) {
            this.maTran = maTran;
        }

        public void setTien(long tien) {
            this.tien = tien;
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
                if(ma.contains(clb[i].maCLB)) {
                    clb[i].setTien(clb[i].giaVe * cdv);
                    clb[i].setMaTran(ma);
                }
            }
        }
        Arrays.sort(clb, new Comparator<CauLacBo>() {
            @Override
            public int compare(CauLacBo o1, CauLacBo o2) {
                if(o2.tien - o1.tien > 0) return 1;
                else if(o2.tien - o1.tien == 0) return o1.tenCLB.compareTo(o2.tenCLB);
                else return -1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(clb[i].maTran + " " + clb[i].tenCLB + " " + clb[i].tien);
        }
    }
}
