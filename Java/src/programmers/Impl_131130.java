package programmers;

import java.util.*;

class Impl_131130 {
    public static int cnt;
    public static boolean[] visited;
    public int solution(int[] cards) {
        Integer[] answer = new Integer[cards.length];
        visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++){
            cnt = 0;
            recur(i, cards);
            answer[i] = cnt;
        }
        Arrays.sort(answer, Collections.reverseOrder());
        return answer[0] * answer[1];
    }
    public void recur(int x, int[] c){
        if (!visited[x]){
            visited[x] = true;
            cnt += 1;
            recur(c[x] - 1, c);
        }
    }
}