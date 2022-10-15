import java.util.Scanner;

public class J05022_LietKeSinhVienTheoLop {
    public static class SinhVien {
        private String ma, name, lop, email;

        public SinhVien(String ma, String name, String lop, String email) {
            this.ma = ma;
            this.name = name;
            this.lop = lop;
            this.email = email;
        }

        public String getLop() {
            return lop;
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
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + s + ":");
            for (int i = 0; i < n; i++) {
                if(sv[i].getLop().equals(s)){
                    System.out.println(sv[i]);
                }
            }
        }
    }
}
