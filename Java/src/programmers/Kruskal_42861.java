package programmers;

import java.util.Arrays;

/*
[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
 */
public class Kruskal_42861 {
    static int[] islands;
    static int answer;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (i1, i2) -> i1[2] - i2[2]);
        islands = new int[n];
        for (int i = 0; i < n; i++) islands[i] = i;
        answer = 0;
        for (int i = 0; i < costs.length; i++){
            int i1 = costs[i][0];
            int i2 = costs[i][1];
            int v = costs[i][2];

            if (find(i1) != find(i2)){
                union(i1, i2);
                answer += v;
            }
        }
        return answer;
    }

    static int find(int x){
        if (islands[x] == x) return x;
        return islands[x] = find(islands[x]);
    }

    static void union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);

        if (p1 > p2) islands[p1] = p2;
        else islands[p2] = p1;
    }
}
