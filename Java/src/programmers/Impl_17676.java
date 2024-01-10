package programmers;

import java.util.*;

class Impl_17676 {
    static long[][] times;
    public static int solution(String[] lines) {
        int answer = 0;
        times = new long[lines.length][2];
        for (int i = 0; i < lines.length; i++){
            String line = lines[i];

            String[] t = line.split(" ");
            String time = t[1];
            String[] s = time.split("[:.]");

            String d = t[2];
            String temp = d.substring(0, d.length() - 1);
            double tmp = Double.parseDouble(temp);
            Long durationTime = (long) (tmp * 1000) - 1;

            Long hour = Long.parseLong(s[0]) * 60 * 60 * 1000;
            Long minute = Long.parseLong(s[1]) * 60 * 1000;
            Long second = Long.parseLong(s[2]) * 1000;
            Long milis = Long.valueOf(s[3]);

            Long end = hour + minute + second + milis;
            Long start = end - durationTime;

            times[i][0] = start;
            times[i][1] = end;
        }

        Arrays.sort(times, (i1, i2) -> Long.compare(i1[0], i2[0]));

        for (long[] time : times) {
            long s = time[0]; long e = time[1];
            int cnts = 0; int cnte = 0;

            for (long[] item : times) {
                if (s > item[1]) continue;
                if (s + 1000 <= item[0]) break;
                cnts++;
            }
            for (long[] item : times) {
                if (e > item[1]) continue;
                if (e + 1000 <= item[0]) break;
                cnte++;
            }
            answer = Math.max(answer, Math.max(cnts, cnte));
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
        }));
    }
}