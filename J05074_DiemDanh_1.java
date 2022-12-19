import java.util.Scanner;

public class J05074_DiemDanh_1 {
    public static class SinhVien {
        private String maSV, tenSV, lopSV, bangCC;
        private int diemCC;

        public SinhVien(String maSV, String tenSV, String lopSV) {
            this.maSV = maSV;
            this.tenSV = tenSV;
            this.lopSV = lopSV;
            this.diemCC = 10;
        }

        public void setBangCC(String bangCC) {
            this.bangCC = bangCC;
            tinhDiem();
        }

        public void tinhDiem() {
            for (int i = 0; i < bangCC.length(); i++) {
                if(bangCC.charAt(i) == 'x') {
                    diemCC -= 0;
                } else if (bangCC.charAt(i) == 'm') {
                    diemCC -= 1;
                } else {
                    diemCC -= 2;
                }
            }
            if(diemCC < 0) diemCC = 0;
        }

        @Override
        public String toString() {
            return maSV + " " + tenSV + " " + lopSV + " " + diemCC;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        for (int i = 0; i < n; i++) {
            String msv = sc.next();
            String bangCC = sc.next();
            for (SinhVien x : sv) {
                if(x.maSV.equals(msv)) {
                    x.setBangCC(bangCC);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(sv[i]);
            if(sv[i].diemCC == 0) System.out.print(" KDDK");
            System.out.println();
        }
    }
}
