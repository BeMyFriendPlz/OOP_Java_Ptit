import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05020_SapXepSinhVienTheoLop {
    public static class SinhVien {
        private String ma, name, lop, mail;

        public SinhVien(String ma, String name, String lop, String mail) {
            this.ma = ma;
            this.name = name;
            this.lop = lop;
            this.mail = mail;
        }

        public String getLop() {
            return lop;
        }

        public String getMa() {
            return ma;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + lop + " " + mail;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(sv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getLop().equals(o2.getLop())){
                    return o1.getMa().compareTo(o2.getMa());
                } else {
                    return o1.getLop().compareTo(o2.getLop());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(sv[i]);
        }
    }
}
