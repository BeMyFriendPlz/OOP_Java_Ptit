import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05051_SapXepBangTinhTienDien {
    public static class KhachHang {
        private String ma, loaiSD;
        private int csMoi, csCu;

        public KhachHang(String ma, String loaiSD, int csCu, int csMoi) {
            while (ma.length() < 2) ma = "0" + ma;
            this.ma = "KH" + ma;
            this.loaiSD = loaiSD;
            this.csMoi = csMoi;
            this.csCu = csCu;
        }

        public int heSo() {
            switch (loaiSD) {
                case "KD": {
                    return 3;
                }
                case "NN": {
                    return 5;
                }
                case "TT": {
                    return 4;
                }
                default: {
                    return 2;
                }
            }
        }

        public long thanhTien() {
            return (csMoi - csCu) * heSo() * 550;
        }

        public long phuTroi() {
            int hieu = csMoi - csCu;
            if(hieu < 50) {
                return 0;
            } else if (hieu <= 100) {
                return Math.round((double) (thanhTien() * 35) / 100);
            } else {
                return thanhTien();
            }
        }

        public long tongTien() {
            return phuTroi() + thanhTien();
        }

        @Override
        public String toString() {
            return ma + " " + heSo() + " " + thanhTien() +
                    " " + phuTroi() + " " + tongTien();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        KhachHang[] kh = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            kh[i] = new KhachHang(String.valueOf(i + 1), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(kh, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.tongTien() > o2.tongTien() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(kh[i]);
        }
    }
}
