package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
 */
public class PrefixSum_11660 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N+1; i++){
            for (int j = 2; j < N+1; j++){
                board[i][j] += board[i][j-1];
            }
        }
        for (int i = 1; i < N+1; i++){
            for (int j = 2; j < N+1; j++){
                board[j][i] += board[j-1][i];
            }
        }


        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int result = board[endX][endY] - board[endX][startY-1] - board[startX-1][endY] + board[startX-1][startY-1];
            System.out.println(result);
        }
    }
}
