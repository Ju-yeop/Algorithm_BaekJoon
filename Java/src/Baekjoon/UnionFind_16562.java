package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 3 20
10 10 20 20 30
1 3
2 4
5 4
 */
public class UnionFind_16562 {
    static int F, R, M;
    static int[] friendCost;
    static StringTokenizer st;
    static int[] parents;
    static int[] minCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friendCost = new int[F];
        parents = new int[F];
        minCost = new int[F];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < F; i++) {
            friendCost[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }
        for (int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            union(first - 1, second - 1);
        }
        for (int i = 0; i < F; i++){
            int group = find(i);
            minCost[group] = Math.min(minCost[group], friendCost[i]);
        }
        int result = 0;
        for (int i = 0; i < F; i++){
            if (minCost[i] == Integer.MAX_VALUE) continue;
            result += minCost[i];
        }
        if (M < result) System.out.println("Oh no");
        else System.out.println(result);
    }

    static int find(int x){
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if (px == py) return;
        if (px > py) parents[px] = py;
        else parents[py] = px;
    }
}
