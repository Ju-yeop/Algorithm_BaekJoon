package programmers;

class DP_1832 {
    int MOD = 20170805;
    static int[][][] road;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        road = new int[m][n][2];

        for (int i = 1; i < n; i++){
            road[0][i][0] = 1; road[0][i][1] = 0;
            if (cityMap[0][i] == 1) break;
        }

        for (int i = 1; i < m; i++){
            road[i][0][0] = 0; road[i][0][1] = 1;
            if (cityMap[i][0] == 1) break;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                int left = 0; int up = 0;

                if (cityMap[i-1][j] == 2) up += road[i-1][j][1];
                else if (cityMap[i-1][j] == 0) up += (road[i-1][j][0] + road[i-1][j][1]) % MOD;

                if (cityMap[i][j-1] == 2) left += road[i][j-1][0];
                else if (cityMap[i][j-1] == 0) left += (road[i][j-1][1] + road[i][j-1][0]) % MOD;

                road[i][j][0] = left;
                road[i][j][1] = up;
            }
        }

        answer = (road[m-1][n-1][0] + road[m-1][n-1][1]) % MOD;

        return answer;
    }
}
