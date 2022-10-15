import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05042_BangXepHang {
    public static class ThiSinh {
        private String name;
        private int baiDung, submit;

        public ThiSinh(String name, int baiDung, int submit) {
            this.name = name;
            this.baiDung = baiDung;
            this.submit = submit;
        }

        public String getName() {
            return name;
        }

        public int getBaiDung() {
            return baiDung;
        }

        public int getSubmit() {
            return submit;
        }

        @Override
        public String toString() {
            return name + " " + baiDung + " " + submit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ThiSinh[] ts = new ThiSinh[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            ts[i] = new ThiSinh(sc.nextLine(), Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
        }
        Arrays.sort(ts, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if(o1.getBaiDung() == o2.getBaiDung()) {
                    if(o1.getSubmit() == o2.getSubmit()) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return o1.getSubmit() > o2.getSubmit() ? 1 : -1;
                    }
                } else {
                    return o1.getBaiDung() > o2.getBaiDung() ? -1 : 1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(ts[i]);
        }
    }
}
