package Baekjoon;

/*
1
10
26 -76
65 -83
78 38
92 22
-60 -42
-27 85
42 46
-86 98
92 -47
-41 38
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Impl_1007 {
    static int T, N;
    static int[][] points;
    static StringTokenizer st;
    static double answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++){
            N = Integer.parseInt(br.readLine());
            points = new int[N][2];
            visited = new boolean[N];
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }
            dfs(0, - 1);
            System.out.println(answer);
        }
    }

    static void dfs(int depth, int top){
        if (depth == N/2) {
            answer = Math.min(answer, cal(visited));
            return;
        }
        for (int i = top + 1; i < N; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    static double cal(boolean[] visited){
        int x = 0; int y = 0;
        for (int i = 0; i < N; i++){
            if (visited[i]){
                x += points[i][0];
                y += points[i][1];
            }
            else{
                x -= points[i][0];
                y -= points[i][1];
            }
        }
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
