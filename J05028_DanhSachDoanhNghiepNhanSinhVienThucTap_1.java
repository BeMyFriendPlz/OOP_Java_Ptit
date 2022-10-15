import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05028_DanhSachDoanhNghiepNhanSinhVienThucTap_1 {
    public static class DoanhNghiep {
        private String ma, name;
        private int soLuong;

        public DoanhNghiep(String ma, String name, int soLuong) {
            this.ma = ma;
            this.name = name;
            this.soLuong = soLuong;
        }

        public String getMa() {
            return ma;
        }

        public int getSoLuong() {
            return soLuong;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + soLuong;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        DoanhNghiep[] dn = new DoanhNghiep[n];
        for (int i = 0; i < n; i++) {
            dn[i]= new DoanhNghiep(sc.nextLine(), sc.nextLine(),
                    Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(dn, new Comparator<DoanhNghiep>() {
            @Override
            public int compare(DoanhNghiep o1, DoanhNghiep o2) {
                if(o1.getSoLuong() == o2.getSoLuong()){
                    return o1.getMa().compareTo(o2.getMa());
                } else {
                    return o1.getSoLuong() > o2.getSoLuong() ? -1 : 1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(dn[i]);
        }
    }
}
