import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07048_DanhSachSanPham_2 {
    public static class SanPham {
        private String maSP, tenSP;
        private int giaBan, baoHanh;

        public SanPham(String maSP, String tenSP, int giaBan, int baoHanh) {
            this.maSP = maSP;
            this.tenSP = tenSP;
            this.giaBan = giaBan;
            this.baoHanh = baoHanh;
        }

        @Override
        public String toString() {
            return maSP + " " + tenSP + " " + giaBan + " " + baoHanh;
        }

        public int getGiaBan() {
            return giaBan;
        }

        public String getMaSP() {
            return maSP;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        SanPham[] sp = new SanPham[n];
        for (int i = 0; i < n; i++) {
            sp[i] = new SanPham(sc.nextLine(), sc.nextLine(),
                    Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(sp, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                if(o1.getGiaBan() > o2.getGiaBan()){
                    return -1;
                }else if(o1.getGiaBan() < o2.getGiaBan()) {
                    return 1;
                }else {
                    return o1.getMaSP().compareTo(o2.getMaSP());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(sp[i]);
        }
    }
}
