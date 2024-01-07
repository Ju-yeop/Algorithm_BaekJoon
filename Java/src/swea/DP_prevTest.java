package swea;

import java.util.*;

/**
 * SWEA 19154
 */

class DP_prevTest{
    static int n;
    static int[][] agents;
    static int[][][][] dp;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            n = sc.nextInt();
            agents = new int[n][3];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < 3; j++){
                    agents[i][j] = sc.nextInt();
                }
            }
            int result = getDP();
            System.out.println("#" + test_case + " " + result);
        }
    }

    static int getDP(){
        dp = new int[n+1][2][2][2];
        for (int i = 0; i < n + 1; i++){
            for (int x = 0; x < 2; x++){
                for (int y = 0; y < 2; y++){
                    for (int z = 0; z < 2; z++){
                        dp[i][x][y][z] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        dp[0][0][0][0] = 0;

        for (int i = 1; i < n+1; i++){
            for (int x = 0; x < 2; x++){
                for (int y = 0; y < 2; y++){
                    for (int z = 0; z < 2; z++){
                        for (int j = 0; j < 3; j++){
                            if (dp[i - 1][x][y][z] != Integer.MAX_VALUE){
                                int[] currentState = {x, y, z};
                                currentState[j] = 1;
                                int value = sum(agents[i - 1]) - agents[i - 1][j];
                                dp[i][currentState[0]][currentState[1]][currentState[2]] =
                                        Math.min(dp[i][currentState[0]][currentState[1]][currentState[2]],
                                                dp[i - 1][x][y][z] + value);
                            }
                        }
                    }
                }
            }
        }
        int result = dp[n][1][1][1];
        return result == Integer.MAX_VALUE ? - 1 : result;
    }

    static int sum(int[] abilities){
        int total = 0;
        for (int i = 0; i < 3; i++){
            total += abilities[i];
        }
        return total;
    }
}
