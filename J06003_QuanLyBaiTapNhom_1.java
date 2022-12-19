import java.util.Scanner;

public class J06003_QuanLyBaiTapNhom_1 {
    public static class SinhVien {
        private String maSV, tenSV, SDT;
        private int STT;

        public SinhVien(String maSV, String tenSV, String SDT, int STT) {
            this.maSV = maSV;
            this.tenSV = tenSV;
            this.SDT = SDT;
            this.STT = STT;
        }

        @Override
        public String toString() {
            return maSV + " " + tenSV + " " + SDT;
        }
    }

    public static class NhomBTL {
        private int STT;
        private String tenBTL;

        public NhomBTL(int STT, String tenBTL) {
            this.STT = STT;
            this.tenBTL = tenBTL;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        SinhVien[] sv = new SinhVien[n];
        NhomBTL[] nhom = new NhomBTL[k];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < k; i++) {
            nhom[i] = new NhomBTL(i+1, sc.nextLine());
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int q = sc.nextInt();
            System.out.println("DANH SACH NHOM " + q + ":");
            for (int i = 0; i < n; i++) {
                if(sv[i].STT == q) {
                    System.out.println(sv[i]);
                }
            }
            System.out.print("Bai tap dang ky: ");
            for (int i = 0; i < k; i++) {
                if(nhom[i].STT == q) {
                    System.out.println(nhom[i].tenBTL);
                    break;
                }
            }
        }
    }
}
