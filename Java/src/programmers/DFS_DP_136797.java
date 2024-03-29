package programmers;

import java.util.Arrays;

class DFS_DP_136797 {
    static int[][] movePlus = new int[10][10];
    static int[][][] dp;
    static int len;
    static String nums;
    public int solution(String numbers) {
        int answer = 0;
        len = numbers.length();
        nums = numbers;
        dp = new int[len][10][10];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < 10; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        moveCounting();

        return dfs(0, 4, 6);
    }

     int dfs(int idx, int left, int right){
        if(idx==len) return 0;
        if(dp[idx][left][right]!=-1) return dp[idx][left][right];

        int num = nums.charAt(idx) - '0';
        int ans = Integer.MAX_VALUE;

        if(num!=right){
            ans = Math.min(dfs(idx+1, num, right) + movePlus[left][num], ans);
        }

        if(num!=left){
            ans = Math.min(dfs(idx+1, left, num) + movePlus[right][num], ans);
        }

        return dp[idx][left][right] = ans;
    }

    void moveCounting(){
        int r1, c1, r2, c2;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j<10; j++) {
                if(i==j){
                    movePlus[i][j] = 1;
                    continue;
                }

                if(i==0) {
                    r1 = 3; c1 = 1;
                }
                else{
                    r1 = (i-1)/3; c1 = (i-1)%3;
                }

                if(j==0) {
                    r2 = 3; c2 = 1;
                }
                else{
                    r2 = (j-1)/3; c2 = (j-1)%3;
                }

                int dr = Math.abs(r1-r2); int dc = Math.abs(c1-c2);
                int min = Math.min(dr, dc); int max = Math.max(dr, dc);
                int diff = dr+dc;

                if(diff == 1) movePlus[i][j] = 2;
                else if(diff > 1) movePlus[i][j] = min*3 + (max-min)*2;
            }
        }
    }
}