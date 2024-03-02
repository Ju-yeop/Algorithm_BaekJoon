package Baekjoon;

import java.io.*;
import java.util.*;

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
 */

public class BFS_14502 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] board;
    static int result = 0;
    static StringTokenizer st;
    static ArrayList<int[]> virus = new ArrayList<>();
    static Stack<Integer> comb = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) virus.add(new int[] {i, j});
            }
        }
        dfs(0, -1);
        System.out.println(result);
    }

    static void dfs(int depth, int last){
        if (depth == 3){
            result = Math.max(result, bfs());
            return;
        }
        for (int i = last + 1; i < N * M; i++){
            comb.add(i);
            dfs(depth + 1, i);
            comb.pop();
        }
    }

    static int bfs(){
        for (int i = 0; i < 3; i++) {
            int x = comb.get(i) / M;
            int y = comb.get(i) % M;
            if (board[x][y] != 0)
                return 0;
        }

        int[][] check = new int[N][M];
        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < M; j++){
                check[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < 3; i++){
            check[comb.get(i) / M][comb.get(i) % M] = 1;
        }

        ArrayDeque<int[]> dq = new ArrayDeque<>(virus);

        while(!dq.isEmpty()){
            int[] temp = dq.poll();
            for (int i = 0; i < 4; i++){
                int mx = temp[0] + dx[i];
                int my = temp[1] + dy[i];
                if (-1 < mx && mx < N && -1 < my && my < M){
                    if (check[mx][my] == 0){
                        check[mx][my] = 2;
                        dq.add(new int[]{mx, my});
                    }
                }
            }
        }
        int zeroCnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (check[i][j] == 0) zeroCnt ++;
            }
        }
        return zeroCnt;
    }
}
