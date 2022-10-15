import java.util.Scanner;

public class ThucHanh_Cuong {
    public static class XuLyXau {
        private String s;

        public XuLyXau(String s) {
            this.s = s.trim();
        }

        public void KtraMSV() {
            if(s.matches("B[0-9]{2}DC[A-Z]{2}[0-9]{3}")){
                System.out.println("Dung dinh dang ma sinh vien PTIT!");
            }else {
                System.out.println("Sai dinh dang ma sinh vien PTIT!");
            }
        }

        public void TachTu() {
            String[] temp = s.split("[^a-zA-Z0-9]+");
            System.out.println("So tu trong xau: " + temp.length);
            for (int i = 0; i < temp.length; i++) {
                System.out.println(temp[i]);
            }
        }

        public void ChuanHoa() {
            String[] temp = s.toLowerCase().split("[^a-zA-Z0-9\\.,!?]+");
            System.out.println("Sau khi chuan hoa: ");
            System.out.print(temp[0].substring(0,1).toUpperCase() + temp[0].substring(1,temp[0].length()));
            for (int i = 1; i < temp.length; i++) {
                System.out.print(" " + temp[i]);
            }
            System.out.println();
        }
    }

    public static class Epsilon {
        private double x, epsilon;

        public Epsilon(double x, double epsilon) {
            this.x = x;
            this.epsilon = epsilon;
        }

        public double giaithua(double n) {
            double i, ketqua = 1;
            for (i=2; i<=n; i++)
                ketqua *= i;
            return ketqua;
        }

        public void KetQuaCosx() {
            double a = 1, n = 1, ketqua = 1;
            while (Math.abs(a) > epsilon){
                a = Math.pow(x, 2*n) / giaithua(2*n);
                ketqua += Math.pow(-1, n) * a;
                n++;
            }
            System.out.println("Ket qua: " + ketqua);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Epsilon e = new Epsilon(Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        e.KetQuaCosx();
    }
}
