import java.util.Scanner;

public class J04006_KhaiBaoLopSinhVien {
    public static class SinhVien {
        private String MaSV;
        private String name;
        private String MaLop;
        private String birth;
        private float GPA;

        public SinhVien(){
            this.MaSV = "B20DCCN001";
            this.name = "";
            this.MaLop = "";
            this.birth = "";
            this.GPA = 0;
        }

        public String getMaSV() {
            return MaSV;
        }

        public void setMaSV(String maSV) {
            MaSV = maSV;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMaLop() {
            return MaLop;
        }

        public void setMaLop(String maLop) {
            MaLop = maLop;
        }

        public String getBirth() {
            String[] s = this.birth.split("/");
            while (s[0].length() < 2) s[0] = "0" + s[0];
            while (s[1].length() < 2) s[1] = "0" + s[1];
            while (s[2].length() < 4) s[2] = "0" + s[2];
            return s[0] + "/" + s[1] + "/" + s[2];
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public float getGPA() {
            return GPA;
        }

        public void setGPA(float GPA) {
            this.GPA = GPA;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String MaLop = sc.next();
        String birth = sc.next();
        float GPA = sc.nextFloat();
        SinhVien sv = new SinhVien();
        sv.setName(name);
        sv.setMaLop(MaLop);
        sv.setBirth(birth);
        sv.setGPA(GPA);
        System.out.printf("%s %s %s %s %.2f", sv.getMaSV(), sv.getName(), sv.getMaLop(), sv.getBirth(), sv.getGPA());
    }
}
