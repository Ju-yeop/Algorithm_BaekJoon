package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
2
5 3
1 1 1 1 1
1 2 2 2 1
1 2 3 2 1
1 2 2 2 1
1 1 1 1 1
2 3
1 3
3 1
 */
public class DP_19004 {
    static StringTokenizer st;
    static int[][] arr;
    static int[][] dp;
    static int N;
    static int K;
    static boolean flag;
    static int answer;

    static class Loc{
        int x, y;

        Loc(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            flag = false;
            answer = Integer.MAX_VALUE;
            playGame();

            if (flag) System.out.println("#" + test_case + " " + "-1");
            else System.out.println("#" + test_case + " " + answer);

        }
    }

    static void playGame(){
        ArrayList<Loc> temp1 = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (arr[i][j] == 1){
                    temp1.add(new Loc(i, j));
                }
            }
        }
        if (temp1.isEmpty()){
            flag = true;
            return;
        }
        int now = 2;
        while (true){
            if (now == K+1){
                for (int q = 0; q < temp1.size(); q++){
                    Loc loc = temp1.get(q);
                    answer = Math.min(answer, dp[loc.x][loc.y]);
                }
                break;
            }

            ArrayList<Loc> temp2 = new ArrayList<>();
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (arr[i][j] == now){
                        temp2.add(new Loc(i, j));
                        int nowMin = Integer.MAX_VALUE;
                        for (int w = 0; w < temp1.size(); w++){
                            Loc loc = temp1.get(w);
                            int dist = Math.abs(loc.x - i) + Math.abs(loc.y - j);
                            if (nowMin > dist + dp[loc.x][loc.y]){
                                nowMin = dist + dp[loc.x][loc.y];
                            }
                        }
                        dp[i][j] = nowMin;
                    }
                }
            }

            if (temp2.isEmpty()){
                flag = true;
                break;
            }

            temp1 = temp2;
            now += 1;
        }
    }
}
