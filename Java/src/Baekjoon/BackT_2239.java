package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
103000509
002109400
000704000
300502006
060000050
700803004
000401000
009205800
804000107
 */
public class BackT_2239 {
    static int[][] board = new int[9][9];
    static boolean[][] rows = new boolean[9][9];
    static boolean[][] columns = new boolean[9][9];
    static boolean[][] squares = new boolean[9][9];
    static ArrayList<int[]> ar = new ArrayList<>();
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++){
            String s = br.readLine();
            for (int j = 0; j < 9; j++){
                int target = s.charAt(j) - '0';
                if (target != 0){
                    board[i][j] = target;
                    rows[i][target-1] = true;
                    columns[j][target-1] = true;
                    squares[squareCal(i, j)][target-1] = true;
                }
                else {
                    ar.add(new int[]{i , j});
                }
            }
        }
        backT(0);
        for(int i = 0; i < 9; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 9; j++){
                sb.append(board[i][j]);
            }
            System.out.println(sb.toString());
        }
    }

    static void backT(int idx){
        if (idx == ar.size()) flag = true;
        if (!flag){
            int[] xy = ar.get(idx);
            int x = xy[0]; int y = xy[1];
            for (int j = 0; j < 9; j++){
                if (!rows[x][j] && !columns[y][j] && !squares[squareCal(x, y)][j]){
                    visiting(x, y, j);
                    board[x][y] = j + 1;
                    backT(idx+1);
                    if (flag) return;
                    board[x][y] = 0;
                    nonVisiting(x, y, j);
                }
            }
        }
    }

    static int squareCal(int x, int y){
        return (x / 3 * 3) + (y / 3);
    }

    static void visiting(int x, int y, int j){
        rows[x][j] = true;
        columns[y][j] = true;
        squares[squareCal(x, y)][j] = true;
    }

    static void nonVisiting(int x, int y, int j){
        rows[x][j] = false;
        columns[y][j] = false;
        squares[squareCal(x, y)][j] = false;
    }
}
