package programmers;

import java.util.*;

class Impl_152995 {
    public int solution(int[][] scores) {
        int n = scores[0][0];
        int m = scores[0][1];
        int inhoSum = n + m;
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });

        int max = scores[0][1];
        int first = scores[0][0];
        for (int i = 1; i < scores.length; i++){
            if (first > scores[i][0] && max > scores[i][1]) {
                if (scores[i][0] == n && scores[i][1] == m) return -1;
                scores[i][0] = -1;
                scores[i][1] = -1;
            }
            max = Math.max(max, scores[i][1]);
        }


        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[0] + o2[1] - o1[0] - o1[1];
            }
        });

        int answer = 1;
        for (int i = 0; i < scores.length; i++){
            if (scores[i][0] + scores[i][1] == inhoSum) break;
            answer++;
        }
        return answer;
    }
}
