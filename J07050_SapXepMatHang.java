import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07050_SapXepMatHang {
    public static class MatHang {
        private String maMH, tenMH, nhomMH;
        private double mua, ban;

        public MatHang(String maMH, String tenMH, String nhomMH, double mua, double ban) {
            setMaMH(maMH);
            this.tenMH = tenMH;
            this.nhomMH = nhomMH;
            this.mua = mua;
            this.ban = ban;
        }

        public void setMaMH(String maMH) {
            while(maMH.length() < 2) maMH = "0" + maMH;
            this.maMH = "MH" + maMH;
        }

        public double getLoiNhuan() {
            return ban - mua;
        }

        @Override
        public String toString() {
            return maMH + " " + tenMH + " " + nhomMH + " " + String.format("%.2f", getLoiNhuan());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }
        Arrays.sort(mh, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return o1.getLoiNhuan() > o2.getLoiNhuan() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}
