import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class J05011_TinhGio {
    public static class Gamer {
        private String ma, name;
        private Date d1, d2;
        private SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        public Gamer(String ma, String name, String d1, String d2) throws ParseException {
            this.ma = ma;
            this.name = name;
            this.d1 = format.parse(d1);
            this.d2 = format.parse(d2);
        }

        public int getGio() {
            return (int) TimeUnit.MILLISECONDS.toHours(d2.getTime() - d1.getTime());
        }

        public int getPhut() {
            return (int) TimeUnit.MILLISECONDS.toMinutes(d2.getTime() - d1.getTime()) - getGio()*60;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + getGio() + " gio " + getPhut() + " phut";
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Gamer[] gm = new Gamer[n];
        for (int i = 0; i < n; i++) {
            gm[i] = new Gamer(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(gm, new Comparator<Gamer>() {
            @Override
            public int compare(Gamer o1, Gamer o2) {
                if (o1.getGio() == o2.getGio()) {
                    return o1.getPhut() > o2.getPhut() ? -1:1;
                } else {
                    return o1.getGio() > o2.getGio() ? -1:1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(gm[i]);
        }
    }
}
