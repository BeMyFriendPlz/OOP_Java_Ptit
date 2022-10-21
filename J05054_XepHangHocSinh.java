import java.util.*;

public class J05054_XepHangHocSinh {
    public static class HocSinh {
        private String ma, name;
        private int xepHang;
        private double dtb;

        public HocSinh(String ma, String name, double dtb) {
            if (ma.length() < 2) ma = "0" + ma;
            this.ma = "HS" + ma;
            this.name = name;
            this.dtb = dtb;
        }

        public String getXepLoai() {
            if(dtb < 5) {
                return "Yeu";
            } else if (dtb < 7) {
                return "Trung Binh";
            } else if (dtb < 9) {
                return "Kha";
            } else {
                return "Gioi";
            }
        }

        public void setXepHang(int xepHang) {
            this.xepHang = xepHang;
        }

        public double getDtb() {
            return dtb;
        }

        public int getXepHang() {
            return xepHang;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + String.format("%.1f", dtb)
                    + " " + getXepLoai() + " " + xepHang;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HocSinh[] hs = new HocSinh[n];
        for (int i = 0; i < n; i++) {
            hs[i] = new HocSinh(String.valueOf(i+1), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()));
        }
        List<HocSinh> list = new ArrayList<>(Arrays.asList(hs));
        Collections.sort(list, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return o1.getDtb() > o2.getDtb() ? -1 : 1;
            }
        });
        int count = 1;
        list.get(0).setXepHang(count);
        for (int i = 1; i < n; i++) {
            while (i < n && list.get(i-1).getDtb() == list.get(i).getDtb()) {
                list.get(i).setXepHang(list.get(i-1).getXepHang());
                i++;
                count++;
            }
            if(i == n) break;
            count++;
            list.get(i).setXepHang(count);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(hs[i]);
        }
    }
}
