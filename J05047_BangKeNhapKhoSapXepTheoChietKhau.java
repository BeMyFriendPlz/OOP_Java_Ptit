import java.util.*;

public class J05047_BangKeNhapKhoSapXepTheoChietKhau {
    public static class MatHang {
        private String ma, name;
        private int soLuong;
        private long donGia;

        public MatHang(String name, int soLuong, long donGia) {
            this.name = name;
            this.soLuong = soLuong;
            this.donGia = donGia;
        }

        public String getMa() {
            String[] s = name.toUpperCase().split("[^a-zA-Z]+");
            String maDau = s[0].substring(0,1) + s[1].substring(0,1);
            return maDau;
        }

        public void setMa(String ma) {
            this.ma = ma;
        }

        public long getChietKhau() {
            if(soLuong < 5) {
                return 0;
            } else if (soLuong < 8) {
                return (soLuong * donGia) / 100;
            } else if (soLuong <= 10) {
                return (soLuong * donGia * 2) / 100;
            } else {
                return (soLuong * donGia * 5) / 100;
            }
        }

        public long getThanhTien() {
            return soLuong * donGia - getChietKhau();
        }

        @Override
        public String toString() {
            return this.ma + " " + name + " " + getChietKhau() + " " + getThanhTien();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(sc.nextLine(), Integer.parseInt(sc.nextLine()), Long.parseLong(sc.nextLine()));
        }
        String s = "";
        for (int i = 0; i < n; i++) {
            int dem = 1;
            for (int j = 0; j < i; j++) {
                if (mh[i].getMa().equals(mh[j].getMa())) {
                    dem++;
                }
            }
            s = mh[i].getMa() + String.format("%02d", dem);
            mh[i].setMa(s);
        }
        Arrays.sort(mh, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return o1.getChietKhau() > o2.getChietKhau() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}

