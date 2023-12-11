package programmers;

import java.util.*;

class Impl_181187 {
    public long solution(int r1, int r2) {
        long answer = 0;
        double rp1 = Math.pow(r1, 2);
        double rp2 = Math.pow(r2, 2);

        for (int x = 1; x < r2; x++){
            double miny = Math.ceil(Math.sqrt(rp1 - Math.pow(x, 2)));
            double maxy = Math.floor(Math.sqrt(rp2- Math.pow(x, 2)));
            if (x >= r1) miny = 1;
            answer += (maxy - miny + 1);
        }
        answer *= 4;
        answer += ((r2 - r1 + 1) * 4);

        return answer;
    }
}
