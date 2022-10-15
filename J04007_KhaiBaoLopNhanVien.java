import java.util.Scanner;

public class J04007_KhaiBaoLopNhanVien {
    public static class NhanVien {
        private String maNV;
        private String name;
        private String sex;
        private String birth;
        private String address;
        private String mst;
        private String date;

        public NhanVien(String name, String sex, String birth, String address, String mst, String date) {
            this.maNV = "00001";
            this.name = name;
            this.sex = sex;
            this.birth = birth;
            this.address = address;
            this.mst = mst;
            this.date = date;
        }

        public String getMaNV() {
            return maNV;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public String getBirth() {
            String[] s = this.birth.split("/");
            while (s[0].length() < 2) s[0] = "0" + s[0];
            while (s[1].length() < 2) s[1] = "0" + s[1];
            while (s[2].length() < 4) s[2] = "0" + s[2];
            return s[0] + "/" + s[1] + "/" + s[2];
        }

        public String getAddress() {
            return address;
        }

        public String getMst() {
            return mst;
        }

        public String getDate() {
            String[] s = this.date.split("/");
            while (s[0].length() < 2) s[0] = "0" + s[0];
            while (s[1].length() < 2) s[1] = "0" + s[1];
            while (s[2].length() < 4) s[2] = "0" + s[2];
            return s[0] + "/" + s[1] + "/" + s[2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien a = new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        System.out.print(a.getMaNV() + " " + a.getName() + " " + a.getSex() + " " +
                a.getBirth() + " " + a.getAddress() + " " + a.getMst() + " " + a.getDate());
    }
}
