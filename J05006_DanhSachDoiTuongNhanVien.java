import java.util.Scanner;

public class J05006_DanhSachDoiTuongNhanVien {
    public static class NhanVien {
        private String ma, name, sex, birth, address, mst, date;

        public NhanVien(String ma, String name, String sex, String birth, String address, String mst, String date) {
            this.ma = ma;
            this.name = name;
            this.sex = sex;
            this.birth = birth;
            this.address = address;
            this.mst = mst;
            this.date = date;
        }

        public String getMa() {
            while (ma.length() < 5) ma = "0" + ma;
            return ma;
        }

        @Override
        public String toString() {
            return getMa() + " " + name + " " + sex + " " + birth + " " + address + " " + mst + " " + date;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        NhanVien[] nv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            nv[i] = new NhanVien(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        for (int i = 0; i < n; i++) {
            System.out.println(nv[i]);
        }
    }
}
