import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05033_SapXepThoiGian {
    public static class Time {
        int gio, phut, giay;

        public Time(int gio, int phut, int giay) {
            this.gio = gio;
            this.phut = phut;
            this.giay = giay;
        }

        public int getGio() {
            return gio;
        }

        public int getPhut() {
            return phut;
        }

        public int getGiay() {
            return giay;
        }

        @Override
        public String toString() {
            return gio + " " + phut + " " + giay;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            times[i] = new Time(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.getGio() > o2.getGio()){
                    return 1;
                }else if(o1.getGio() == o2.getGio()){
                    if(o1.getPhut() > o2.getPhut()){
                        return 1;
                    }else if(o1.getPhut() == o2.getPhut()){
                        if(o1.getGiay() > o2.getGiay()) {
                            return 1;
                        }else if(o1.getGiay() == o2.getGiay()){
                            return 0;
                        }else {
                            return -1;
                        }
                    }else {
                        return -1;
                    }
                }else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(times[i]);
        }
    }
}
