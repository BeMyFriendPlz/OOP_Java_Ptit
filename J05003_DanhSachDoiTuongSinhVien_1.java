import java.util.Scanner;

public class J05003_DanhSachDoiTuongSinhVien_1 {
    public static class SinhVien {
        private String id ,name, clas, birth;
        private double gpa;

        public SinhVien(String id, String name, String clas, String birth, double gpa) {
            this.id = id;
            this.name = name;
            this.clas = clas;
            this.birth = birth;
            this.gpa = gpa;
        }

        public String getId() {
            while (id.length() < 3) id = "0" + id;
            return "B20DCCN" + id;
        }

        public String getBirth() {
            String[] s = birth.split("/");
            if(s[0].length() < 2) s[0] = "0" + s[0];
            if(s[1].length() < 2) s[1] = "0" + s[1];
            return s[0] + "/" + s[1] + "/" + s[2];
        }

        public String getGpa() {
            return String.format("%.2f", gpa);
        }

        @Override
        public String toString() {
            return getId() + " " + name + " " + clas + " " + getBirth() + " " + getGpa();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), Double.parseDouble(sc.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(sv[i]);
        }
    }
}
