import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J06004_QuanLyBaiTapNhom_2 {
    public static class SinhVien {
        private String maSV, tenSV, SDT;
        private int STT;

        public SinhVien(String maSV, String tenSV, String SDT, int STT) {
            this.maSV = maSV;
            this.tenSV = tenSV;
            this.SDT = SDT;
            this.STT = STT;
        }

        @Override
        public String toString() {
            return maSV + " " + tenSV + " " + SDT;
        }
    }

    public static class NhomBTL {
        private int STT;
        private String tenBTL;

        public NhomBTL(int STT, String tenBTL) {
            this.STT = STT;
            this.tenBTL = tenBTL;
        }

        @Override
        public String toString() {
            return STT + " " + tenBTL;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        SinhVien[] sv = new SinhVien[n];
        NhomBTL[] nhom = new NhomBTL[k];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < k; i++) {
            nhom[i] = new NhomBTL(i+1, sc.nextLine());
        }
        Arrays.sort(sv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.maSV.compareTo(o2.maSV);
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.print(sv[i] + " ");
            for (int j = 0; j < k; j++) {
                if(sv[i].STT == nhom[j].STT) {
                    System.out.println(nhom[j]);
                    break;
                }
            }
        }
    }
}
