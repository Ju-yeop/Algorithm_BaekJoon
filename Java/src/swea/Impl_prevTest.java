package swea;

import java.util.*;

/**
 * SWEA 19154
 * 문제 잘못 이해하고 풀었지만 발상과 구현은 괜찮았어...
 */

class Impl_prevTest{
    static int n, maxValue;
    static int[][] agents;
    static boolean[] visited;
    static int[] selectedList;
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            n = sc.nextInt();
            int answer = 0;
            agents = new int[3][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < 3; j++){
                    agents[j][i] = sc.nextInt();
                }
            }
            visited = new boolean[n];
            selectedList = new int[3];
            maxValue = Integer.MIN_VALUE;

            dfs(0, 0, new int[]{0, 0, 0});
            for (int i = 0; i < n; i++){
                final int currentI = i;
                if (Arrays.stream(selectedList).anyMatch(t -> t == currentI)){
                    for (int j = 0; j < 3; j++){
                        answer += agents[j][i];
                    }
                }
                else{
                    int maxAbility = 0;
                    for (int k = 0; k < 3; k++){
                        maxAbility = Math.max(maxAbility, agents[k][i]);
                        answer += agents[k][i];
                    }
                    answer -= maxAbility;
                }
            }
            answer -= maxValue;

            System.out.println("#" + test_case + " " + (n < 3 ? -1 : answer));
        }
    }

    static void dfs(int depth, int value, int[] idxList){
        if (depth == 3){
            if (maxValue < value){
                maxValue = value;
                selectedList = idxList;
            }
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                idxList[depth] = i;
                dfs(depth+1, value + agents[depth][i], idxList);
                visited[i] = false;
            }
        }
    }
}
