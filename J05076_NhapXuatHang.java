import java.util.Scanner;

public class J05076_NhapXuatHang {
    public static class CuaHang {
        private String maHang, tenHang, xepLoai;
        private long slNhap, slBan, giaBan;

        public CuaHang(String maHang, String tenHang, String xepLoai) {
            this.maHang = maHang;
            this.tenHang = tenHang;
            this.xepLoai = xepLoai;
        }

        public void setSlNhap(long slNhap) {
            this.slNhap = slNhap;
        }

        public void setSlBan(long slBan) {
            this.slBan = slBan;
        }

        public void setGiaBan(long giaBan) {
            this.giaBan = giaBan;
        }

        public int laiXuat() {
            if(xepLoai.equals("A")) {
                return 8;
            } else if (xepLoai.equals("B")) {
                return 5;
            } else {
                return 2;
            }
        }

        public long getGiaNhap() {
            return slNhap * giaBan;
        }

        public long getGiaXuat() {
            return slBan * giaBan * (100 + laiXuat()) / 100;
        }

        @Override
        public String toString() {
            return maHang + " " + tenHang + " " + getGiaNhap() + " " + getGiaXuat();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        CuaHang[] ch = new CuaHang[n];
        for (int i = 0; i < n; i++) {
            ch[i] = new CuaHang(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if(ch[i].maHang.equals(s)) {
                    ch[i].setSlNhap(a);
                    ch[i].setGiaBan(b);
                    ch[i].setSlBan(c);
                    System.out.println(ch[i]);
                }
            }
        }
    }
}
