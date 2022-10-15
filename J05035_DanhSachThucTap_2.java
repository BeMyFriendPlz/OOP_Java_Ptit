import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05035_DanhSachThucTap_2 {
    public static class SinhVien {
        private int num;
        private String ma, name, lop, email, doanhNghiep;

        public SinhVien(int num, String ma, String name, String lop, String email, String doanhNghiep) {
            this.num = num;
            this.ma = ma;
            this.name = name;
            this.lop = lop;
            this.email = email;
            this.doanhNghiep = doanhNghiep;
        }

        public String getMa() {
            return ma;
        }

        public String getDoanhNghiep() {
            return doanhNghiep;
        }

        @Override
        public String toString() {
            return num + " " + ma + " " + name + " " + lop + " " + email + " " + doanhNghiep;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(i+1, sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(sv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getMa().compareTo(o2.getMa());
            }
        });
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            for (int i = 0; i < n; i++) {
                if(s.equals(sv[i].getDoanhNghiep())){
                    System.out.println(sv[i]);
                }
            }
        }
    }
}
