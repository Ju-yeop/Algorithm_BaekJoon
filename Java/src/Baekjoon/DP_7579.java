package Baekjoon;

/*
5 60
30 10 20 35 40
3 0 3 5 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_7579 {
    static int N, M;
    static int[] memory, cost;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N];
        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            cost[j] = Integer.parseInt(st.nextToken());
        }


        int[][] dp = new int[N][10001];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10001; j++) {
                if (i == 0){
                    if (cost[0] <= j) dp[0][j] = memory[0];
                }
                else{
                    if (j - cost[i] < 0) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = Math.max(dp[i - 1][j], memory[i] + dp[i - 1][j - cost[i]]);
                }

                if (dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }
}
