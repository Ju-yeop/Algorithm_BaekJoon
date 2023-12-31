import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
3
4
7
10
 */
public class DP_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            max = Integer.max(max, temp);
            ar[i] = temp;
        }

        int[][] dp = new int[4][max+1];

        for (int i = 0; i < 4; i++){
            Arrays.fill(dp[i], 1);
        }

        for (int i = 2; i < 4; i++){
            for (int j = 1; j < max+1; j++){
                if (j-i < 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-i];
            }
        }

        for (int a : ar){
            System.out.println(dp[3][a]);
        }
    }
}
