import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05007_SapXepDanhSachDoiTuongNhanVien {
    public static class NhanVien {
        private String ma, name, sex, birth, address, mst, date;

        public NhanVien(String ma, String name, String sex, String birth, String address, String mst, String date) {
            this.ma = ma;
            this.name = name;
            this.sex = sex;
            this.birth = birth;
            this.address = address;
            this.mst = mst;
            this.date = date;
        }

        public String getMa() {
            while (ma.length() < 5) ma = "0" + ma;
            return ma;
        }

        public int getNgay() {
            return Integer.parseInt(birth.substring(0,2));
        }

        public int getThang() {
            return Integer.parseInt(birth.substring(3,5));
        }

        public int getNam() {
            return Integer.parseInt(birth.substring(6,10));
        }

        @Override
        public String toString() {
            return getMa() + " " + name + " " + sex + " " + birth + " " + address + " " + mst + " " + date;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        NhanVien[] nv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            nv[i] = new NhanVien(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(nv, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if (o1.getNam() == o2.getNam()) {
                    if (o1.getThang() == o2.getThang()) {
                        return o1.getNgay() > o2.getNgay() ? 1 : -1;
                    } else {
                        return o1.getThang() > o2.getThang() ? 1 : -1;
                    }
                } else {
                    return o1.getNam() > o2.getNam() ? 1 : -1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(nv[i]);
        }
    }
}
