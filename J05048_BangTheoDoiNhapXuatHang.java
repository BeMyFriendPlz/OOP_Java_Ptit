import java.util.Scanner;

public class J05048_BangTheoDoiNhapXuatHang {
    public static class MatHang {
        private String ma;
        private int soLuongNhap;

        public MatHang(String ma, int soLuongNhap) {
            this.ma = ma;
            this.soLuongNhap = soLuongNhap;
        }

        public double getSoLuongXuat() {
            if(ma.charAt(0) == 'A') {
                return Math.round((double) (60 * soLuongNhap) / 100);
            } else {
                return Math.round((double) (70 * soLuongNhap) / 100);
            }
        }

        public long getDonGia() {
            if(ma.charAt(4) == 'Y') {
                return 110000;
            } else {
                return 135000;
            }
        }

        public long getTien() {
            return (long) (getSoLuongXuat() * (int) getDonGia());
        }

        public double getThue() {
            if(ma.charAt(0) == 'A') {
                if(ma.charAt(4) == 'Y') {
                    return (double) (8 * getTien()) / 100;
                } else {
                    return (double) (11 * getTien()) / 100;
                }
            } else {
                if(ma.charAt(4) == 'Y') {
                    return (double) (17 * getTien()) / 100;
                } else {
                    return (double) (22 * getTien()) / 100;
                }
            }
        }

        @Override
        public String toString() {
            return ma + " " + soLuongNhap + " " + String.format("%.0f", getSoLuongXuat()) + " " +
                    getDonGia() + " " + getTien() + " " + String.format("%.0f", getThue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}

