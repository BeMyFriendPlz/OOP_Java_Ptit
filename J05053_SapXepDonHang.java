import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05053_SapXepDonHang {
    public static class MatHang {
        private String name, ma;
        private long donGia, soLuong;

        public MatHang(String name, String ma, long donGia, long soLuong) {
            this.name = name;
            this.ma = ma;
            this.donGia = donGia;
            this.soLuong = soLuong;
        }

        public String getSoThuTu() {
            return ma.substring(1,4);
        }

        public long getGiamGia() {
            if(ma.charAt(4) == '1') {
                return donGia * soLuong * 50 / 100;
            } else {
                return donGia * soLuong * 30 / 100;
            }
        }

        public long getThanhTien() {
            return donGia * soLuong - getGiamGia();
        }

        @Override
        public String toString() {
            return name + " " + ma + " " + getSoThuTu() + " " + getGiamGia() + " " + getThanhTien();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(sc.nextLine(), sc.nextLine(),
                    Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
        }
        Arrays.sort(mh, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return o1.getSoThuTu().compareTo(o2.getSoThuTu());
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}
