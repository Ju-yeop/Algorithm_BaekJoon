package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
10 3
3 1
2 2
1 3
 */
public class DP_1106 {
    static int C, N;
    static int[][] ls;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        ls = new int[N][2];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            ls[i][0] = Integer.parseInt(st.nextToken());
            ls[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][C+1];
        for (int i = 1; i < C+1; i++){
            if (i == 1) dp[0][i] = ls[0][0];
            dp[0][i] =  ((i-1) / ls[0][1] + 1) * ls[0][0];
        }
        for (int i = 1; i < N; i++){
            for (int j = 1; j < C+1; j++){
                if (j <= ls[i][1]) dp[i][j] = Math.min(ls[i][0], dp[i-1][j]);
                else dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j - ls[i][1]], dp[i-1][j - ls[i][1]]) + ls[i][0]);
            }
        }

        System.out.println(dp[N-1][C]);

    }
}
