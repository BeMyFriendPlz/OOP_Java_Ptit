import java.util.*;

public class J05047_BangKeNhapKhoSapXepTheoChietKhau {
    public static Map<String, Integer> map;
    public static class MatHang {
        private String name;
        private int soLuong;
        private long donGia;

        public MatHang(String name, int soLuong, long donGia) {
            this.name = name;
            this.soLuong = soLuong;
            this.donGia = donGia;
        }

        public String getMa() {
            String[] s = name.toUpperCase().split(" ");
            String maDau = s[0].substring(0,1) + s[1].substring(0,1);
            if(map.get(maDau) == null) {
                map.put(maDau, 1);
            } else {
                map.put(maDau, map.get(maDau) + 1);
            }
            String maSau = String.valueOf(map.get(maDau));
            while (maSau.length() < 2) maSau = "0" + maSau;
            return maDau + maSau;
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
            return getMa() + " " + name + " " + getChietKhau() + " " + getThanhTien();
        }
    }

    public static void main(String[] args) {
        map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(sc.nextLine(), Integer.parseInt(sc.nextLine()), Long.parseLong(sc.nextLine()));
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
