import java.util.*;

public class J05021_SapXepTheoMaSinhVien {
    public static class SinhVien {
        private String ma, name, lop, mail;

        public SinhVien(String ma, String name, String lop, String mail) {
            this.ma = ma;
            this.name = name;
            this.lop = lop;
            this.mail = mail;
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
        List<SinhVien> list = new ArrayList<>();
        while(sc.hasNextLine()) {
            list.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(list, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getMa().compareTo(o2.getMa());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
