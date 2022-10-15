import java.util.Scanner;

public class J05040_LapBangTinhCong {
    public static class NhanVien {
        private String ma, name;
        private long luongNgay;
        private int ngayCong;
        private String chucVu;

        public NhanVien(String ma, String name, long luongNgay, int ngayCong, String chucVu) {
            while (ma.length() < 2) ma = "0" + ma;
            this.ma = "NV" + ma;
            this.name = name;
            this.luongNgay = luongNgay;
            this.ngayCong = ngayCong;
            this.chucVu = chucVu;
        }

        public long getLuongThang() {
            return ngayCong * luongNgay;
        }

        public long getThuong() {
            if(ngayCong >= 25) {
                return 20 * getLuongThang() / 100;
            } else if (ngayCong >= 22) {
                return 10 * getLuongThang() / 100;
            } else {
                return 0;
            }
        }

        public long getPhuCap() {
            switch (chucVu) {
                case "GD": {
                    return 250000;
                }
                case "PGD": {
                    return 200000;
                }
                case "TP": {
                    return 180000;
                }
                default: {
                    return 150000;
                }
            }
        }

        public long ThucLinh() {
            return getLuongThang() + getThuong() + getPhuCap();
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + getLuongThang() + " " + getThuong() + " " + getPhuCap() + " " + ThucLinh();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        NhanVien[] nv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            nv[i] = new NhanVien(String.valueOf(i+1), sc.nextLine(), Long.parseLong(sc.nextLine()),
                    Integer.parseInt(sc.nextLine()), sc.nextLine());
        }
        for (int i = 0; i < n; i++) {
            System.out.println(nv[i]);
        }
    }
}
