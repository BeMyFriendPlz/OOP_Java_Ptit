import java.util.Scanner;

public class J04005_KhaiBaoLopThiSinh {
    public static class ThiSinh {
        private String name;
        private String birth;
        private float p1,p2,p3;

        public ThiSinh(String name, String birth, float p1, float p2, float p3) {
            this.name = name;
            this.birth = birth;
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public float getP1() {
            return p1;
        }

        public void setP1(float p1) {
            this.p1 = p1;
        }

        public float getP2() {
            return p2;
        }

        public void setP2(float p2) {
            this.p2 = p2;
        }

        public float getP3() {
            return p3;
        }

        public void setP3(float p3) {
            this.p3 = p3;
        }

        public float TongDiem(){
            return (this.p1 + this.p2 + this.p3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String birth = sc.next();
        float p1 = sc.nextFloat();
        float p2 = sc.nextFloat();
        float p3 = sc.nextFloat();
        ThiSinh ts = new ThiSinh(name, birth, p1, p2, p3);
        System.out.printf("%s %s %.1f", ts.getName(), ts.getBirth(), ts.TongDiem());
    }
}
