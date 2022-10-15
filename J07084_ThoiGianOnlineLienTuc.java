import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class J07084_ThoiGianOnlineLienTuc {
    public static class SinhVien {
        private String name;
        private Date start, end;
        private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        public SinhVien(String name, String start, String end) throws ParseException {
            this.name = name;
            this.start = format.parse(start);
            this.end = format.parse(end);
        }

        public String getName() {
            return name;
        }

        public long getTime() {
            return TimeUnit.MILLISECONDS.toMinutes(end.getTime() - start.getTime());
        }

        @Override
        public String toString() {
            return name + " " + getTime();
        }
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(sv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getTime() > o2.getTime()) {
                    return -1;
                } else if (o1.getTime() < o2.getTime()) {
                    return 1;
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(sv[i]);
        }
    }
}
