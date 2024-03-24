package programmers;

import java.util.*;

class Impl_172927 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] piro = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int pickSum = picks[0] + picks[1] + picks[2];
        int dx = Math.min(pickSum, (minerals.length - 1) / 5 + 1);
        int[][] mineralInt = new int[dx][3];
        for (int i = 0 ; i < minerals.length; i++){
            int idx = i / 5;
            if (idx == dx) break;
            if (minerals[i].equals("diamond")) mineralInt[idx][0] ++;
            else if (minerals[i].equals("iron")) mineralInt[idx][1] ++;
            else mineralInt[idx][2] ++;
        }
        Arrays.sort(mineralInt, (i0, i1) -> i0[0] == i1[0] ? (i0[1] == i1[1] ? i1[2] - i0[2] : i1[1] - i0[1]) : i1[0] - i0[0]);

        int idx = 0;
        while(true){
            if (pickSum == 0 || idx > dx - 1) break;
            if (picks[0] != 0){
                picks[0] --;
                for (int i = 0; i < 3; i++){
                    answer += (piro[0][i] * mineralInt[idx][i]);
                }
            }
            else if (picks[1] != 0){
                picks[1] --;
                for (int i = 0; i < 3; i++){
                    answer += (piro[1][i] * mineralInt[idx][i]);
                }
            }
            else{
                picks[2] --;
                for (int i = 0; i < 3; i++){
                    answer += (piro[2][i] * mineralInt[idx][i]);
                }
            }
            pickSum--;
            idx++;
        }

        return answer;
    }
}
