import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05081_DanhSachMatHang {
    public static class MatHang {
        private String maMH;
        private String nameMH;
        private String donVi;
        private long giaMua, giaBan, loiNhuan;

        public MatHang(String maMH, String nameMH, String donVi, long giaMua, long giaBan) {
            while (maMH.length() < 3) maMH = "0" + maMH;
            this.maMH = "MH" + maMH;
            this.nameMH = nameMH;
            this.donVi = donVi;
            this.giaMua = giaMua;
            this.giaBan = giaBan;
            setLoiNhuan();
        }

        public String getMaMH() {
            return maMH;
        }

        public void setLoiNhuan() {
            this.loiNhuan = this.giaBan - this.giaMua;
        }

        public long getLoiNhuan() {
            return loiNhuan;
        }

        @Override
        public String toString() {
            return maMH + " " + nameMH + " " + donVi +
                    " " + giaMua + " " + giaBan + " " + loiNhuan;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
        }
        Arrays.sort(mh, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                if(o1.getLoiNhuan() > o2.getLoiNhuan()){
                    return -1;
                }else if(o1.getLoiNhuan() == o2.getLoiNhuan()){
                    return o1.getMaMH().compareTo(o2.getMaMH());
                }else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}
