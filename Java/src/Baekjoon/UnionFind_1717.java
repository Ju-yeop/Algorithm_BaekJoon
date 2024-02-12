package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
public class UnionFind_1717 {
    static int N, M;
    static StringTokenizer st;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for (int i = 0; i < N+1; i++){
            parents[i] = i;
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int judge = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (judge == 0) union(a, b);
            else System.out.println(find(a) == find(b) ? "YES" : "NO");
        }

    }

    public static int find(int x){
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if (px < py) parents[py] = px;
        else if (px > py) parents[px] = py;
    }
}
