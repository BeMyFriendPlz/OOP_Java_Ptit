import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05045_SapXepNhanVienTheoThuNhap {
    public static class NhanVien {
        private String ma, name, chucVu;
        private long luongCB;
        private int ngayCong;

        public NhanVien(String ma, String name, String chucVu, long luongCB, int ngayCong) {
            while(ma.length() < 2) ma = "0" + ma;
            this.ma = "NV" + ma;
            this.name = name;
            this.chucVu = chucVu;
            this.luongCB = luongCB;
            this.ngayCong = ngayCong;
        }

        public int phuCap() {
            switch (chucVu) {
                case "GD": {
                    return 500;
                }
                case "PGD": {
                    return 400;
                }
                case  "TP": {
                    return 300;
                }
                case "KT": {
                    return 250;
                }
                default: {
                    return 100;
                }
            }
        }

        public long luongChinh() {
            return luongCB * ngayCong;
        }

        public long tamUng() {
            double x = (phuCap() + luongChinh() * 2) / 3;
            if(x < 25000) {
                return Math.round(x / 1000) * 1000;
            }else {
                return 25000;
            }
        }

        public long conLai() {
            return luongChinh() + phuCap() - tamUng();
        }

        public String getMa() {
            return ma;
        }

        public long getThuNhap() {
            return luongChinh() + phuCap();
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + phuCap() + " " + luongChinh()
                    + " " + tamUng() + " " + conLai();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        NhanVien[] nv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            nv[i] = new NhanVien(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    Long.parseLong(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(nv, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if(o1.getThuNhap() == o2.getThuNhap()) {
                    return o1.getMa().compareTo(o2.getMa());
                }else {
                    return o1.getThuNhap() > o2.getThuNhap() ? -1 : 1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(nv[i]);
        }
    }
}
