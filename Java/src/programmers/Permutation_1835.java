package programmers;

import java.util.*;

class Permutation_1835 {
    public static char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public static boolean[] visited = new boolean[8];
    public static Stack<Integer> ar;
    public static int answer;
    public int solution(int n, String[] data) {
        Arrays.fill(visited, false);
        ar = new Stack<>();
        answer = 0;
        dfs(data);
        return answer;
    }

    public void dfs(String[] data){
        boolean flag = true;
        for (String s: data){
            int c1 = s.charAt(0); int c2 = s.charAt(2);
            int e = s.charAt(3);
            int dist = s.charAt(4) - '0' + 1;
            int c1idx = -1; int c2idx = -1;

            for (int i = 0; i < ar.size(); i++){
                if (ar.get(i) == c1) c1idx = i;
                if (ar.get(i) == c2) c2idx = i;
            }

            if (c1idx == -1 || c2idx == -1) continue;

            int t = Math.abs(c1idx - c2idx);

            if (e == '=') flag = t == dist;
            else if (e == '>') flag = t > dist;
            else flag = t < dist;

            if (!flag) return;
        }

        if (ar.size() == 8){
            answer++;
            return;
        }

        for (int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                ar.add((int) name[i]);
                dfs(data);
                ar.pop();
                visited[i] = false;
            }
        }

    }
}
