import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 5
10 25 7 8 13
68 24 -78 63 32
12 -69 100 -29 -25
-16 -22 -57 -33 99
7 -76 -11 77 15
 */
public class DP_2169 {
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] mars = new int[n][m];
        int[][] dp = new int[n][m];
        int[][] temp = new int[2][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], 0);
            for (int j = 0; j < m; j++){
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = mars[0][0];

        for (int i = 1; i < m; i++){
                dp[0][i] = mars[0][i] + dp[0][i-1];
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j < m; j++){
                if (j == 0) temp[0][j] = mars[i][j] + dp[i-1][j];
                else temp[0][j] = mars[i][j] + Integer.max(dp[i-1][j], temp[0][j-1]);
            }
            for (int j = m-1; j > -1; j--){
                if (j == m-1) temp[1][j] = mars[i][j] + dp[i-1][j];
                else temp[1][j] = mars[i][j] + Integer.max(dp[i-1][j], temp[1][j+1]);
            }
            for (int k = 0; k < m ; k++){
                dp[i][k] = Integer.max(temp[0][k], temp[1][k]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
