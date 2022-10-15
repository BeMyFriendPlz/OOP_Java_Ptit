import java.util.Scanner;

public class J05024_LietKeSinhVienTheoNganh {
    public static class SinhVien {
        private String ma, name, lop, email;

        public SinhVien(String ma, String name, String lop, String email) {
            this.ma = ma;
            this.name = name;
            this.lop = lop;
            this.email = email;
        }

        public String getKhoa() {
            return ma.substring(3,7);
        }

        public char getLop() {
            return lop.charAt(0);
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + lop + " " + email;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String nganh = sc.nextLine().toUpperCase();
            System.out.println("DANH SACH SINH VIEN NGANH " + nganh + ":");
            String[] s = nganh.split(" ");
            String maNganh = "DC" + s[0].charAt(0) + s[1].charAt(0);
            for (int i = 0; i < n; i++) {
                if(sv[i].getKhoa().equals(maNganh)){
                    if(maNganh.equals("DCCN") || maNganh.equals("DCAT")){
                        if (sv[i].getLop() != 'E'){
                            System.out.println(sv[i]);
                        }
                    } else {
                        System.out.println(sv[i]);
                    }
                }
            }
        }
    }
}
