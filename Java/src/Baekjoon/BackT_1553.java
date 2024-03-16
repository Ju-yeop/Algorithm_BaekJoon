package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
0000000
0123456
1111112
1234562
2222333
3456345
3444556
6456566
 */
public class BackT_1553 {
    static int[][] board = new int[8][7];
    static boolean[][] visited = new boolean[8][7];
    static boolean[][] dice = new boolean[7][7];
    static int answer = 0;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++){
            String s = br.readLine();
            for (int j = 0; j < 7; j++){
                board[i][j] = s.charAt(j) - '0';
            }
        }
        backT(0, 0);
        System.out.println(answer);
    }

    static void backT(int n, int cnt){
        if (n > 55 && cnt == 56){
            answer ++;
            return;
        }
        int x = n / 7; int y = n % 7;
        if(visited[x][y]){
            backT(n+1, cnt);
            return;
        }
        for (int i = 0; i < 2; i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if (-1 < mx && mx < 8 && -1 < my && my < 7){
                if (!visited[mx][my] && (!dice[board[x][y]][board[mx][my]] || !dice[board[mx][my]][board[x][y]])){
                    visited[mx][my] = true;
                    visited[x][y] = true;
                    dice[board[x][y]][board[mx][my]] = true;
                    dice[board[mx][my]][board[x][y]] = true;
                    backT(n + 1, cnt + 2);
                    visited[mx][my] = false;
                    visited[x][y] = false;
                    dice[board[x][y]][board[mx][my]] = false;
                    dice[board[mx][my]][board[x][y]] = false;
                }
            }
        }
    }
}
