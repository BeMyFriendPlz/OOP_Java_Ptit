import java.util.Scanner;

public class J04012_BaiToanTinhCong {
    public static class NhanVien {
        private String maNV, name, chucVu;
        private long luong;
        private int ngayCong;

        public NhanVien(String name, long luong, int ngayCong, String chucVu) {
            this.maNV = "NV01";
            this.name = name;
            this.luong = luong;
            this.ngayCong = ngayCong;
            this.chucVu = chucVu;
        }

        public long luongThang() {
            return luong * ngayCong;
        }

        public long thuong() {
            int heSo;
            if(ngayCong < 22) {
                heSo = 0;
            }else if (ngayCong < 25) {
                heSo = 10;
            }else {
                heSo = 20;
            }
            return luongThang()*heSo/100;
        }

        public long phuCap() {
            switch (chucVu) {
                case "GD" : {
                    return 250000;
                }
                case "PGD" : {
                    return 200000;
                }
                case "TP" : {
                    return 180000;
                }
                default : {
                    return 150000;
                }
            }
        }

        public long thuNhap() {
            return luongThang() + thuong() + phuCap();
        }

        @Override
        public String toString() {
            return maNV + " " + name + " " + luongThang() + " " + thuong() + " " + phuCap() + " " + thuNhap();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien(sc.nextLine(), sc.nextLong(), sc.nextInt(), sc.next());
        System.out.println(nv);
    }
}
