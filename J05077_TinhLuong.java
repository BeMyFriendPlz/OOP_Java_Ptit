import java.util.Locale;
import java.util.Scanner;

public class J05077_TinhLuong {
    public static class PhongBan {
        private String maPB, tenPB;

        public PhongBan(String maPB, String tenPB) {
            this.maPB = maPB;
            this.tenPB = tenPB;
        }

        public String getMaPB() {
            return maPB;
        }

        public String getTenPB() {
            return tenPB;
        }
    }

    public static class NhanVien {
        private String loaiNV, maPB, maNV, tenNV;
        private long luongCB, ngayCong;

        private int namCT;

        public NhanVien(String maNV, String tenNV, long luongCB, long ngayCong) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luongCB = luongCB;
            this.ngayCong = ngayCong;
            loaiNV = maNV.substring(0,1);
            namCT = Integer.parseInt(maNV.substring(1,3));
            maPB = maNV.substring(3,5);
        }

        public int heSoLuong() {
            if(loaiNV.equals("A")) {
                if(namCT <= 3) return 10;
                else if (namCT <= 8) return 12;
                else if (namCT <= 15) return 14;
                else return 20;
            } else if (loaiNV.equals("B")) {
                if(namCT <= 3) return 10;
                else if (namCT <= 8) return 11;
                else if (namCT <= 15) return 13;
                else return 16;
            } else if (loaiNV.equals("C")) {
                if(namCT <= 3) return 9;
                else if (namCT <= 8) return 10;
                else if (namCT <= 15) return 12;
                else return 14;
            } else {
                if(namCT <= 3) return 8;
                else if (namCT <= 8) return 9;
                else if (namCT <= 15) return 11;
                else return 13;
            }
        }

        public long getLuong() {
            return luongCB * ngayCong * heSoLuong() * 1000;
        }

        @Override
        public String toString() {
            return maNV + " " + tenNV;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = Integer.parseInt(sc.nextLine());
        PhongBan[] pb = new PhongBan[n];
        for (int i = 0; i < n; i++) {
            pb[i] = new PhongBan(sc.next(), sc.nextLine());
        }
        int m = Integer.parseInt(sc.nextLine());
        NhanVien[] nv = new NhanVien[m];
        for (int i = 0; i < m; i++) {
            nv[i] = new NhanVien(sc.nextLine(), sc.nextLine(),
                    Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            System.out.print(nv[i]);
            for (int j = 0; j < n; j++) {
                if(pb[j].maPB.equals(nv[i].maPB)) {
                    System.out.print(pb[j].tenPB + " ");
                }
            }
            System.out.println(nv[i].getLuong());
        }
    }
}
