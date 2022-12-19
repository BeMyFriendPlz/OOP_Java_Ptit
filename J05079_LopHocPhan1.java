import java.util.*;

public class J05079_LopHocPhan1 {
    public static class LopHoc {
        private String maMH, tenMH, nhomLop, tenGV;

        public LopHoc(String maMH, String tenMH, String nhomLop, String tenGV) {
            this.maMH = maMH;
            this.tenMH = tenMH;
            this.nhomLop = nhomLop;
            this.tenGV = tenGV;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<LopHoc> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new LopHoc(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(list, new Comparator<LopHoc>() {
            @Override
            public int compare(LopHoc o1, LopHoc o2) {
                return o1.nhomLop.compareTo(o2.nhomLop);
            }
        });
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine();
            for (LopHoc i : list) {
                if(i.maMH.equals(s)) {
                    System.out.println("Danh sach nhom lop mon " + i.tenMH + ":");
                    break;
                }
            }
            for (LopHoc i : list) {
                if(i.maMH.equals(s)) {
                    System.out.println(i.nhomLop + " " + i.tenGV);
                }
            }
        }
    }
}
