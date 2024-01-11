package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = 1;

        int beforeSeat = 0;
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= dp[temp - beforeSeat - 1];
            beforeSeat = temp;
        }
        ans *= dp[N - beforeSeat];

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}