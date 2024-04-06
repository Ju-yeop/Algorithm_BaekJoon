package Baekjoon;

/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BFS_1926 {
    static StringTokenizer st;
    static int N, M;
    static int[][] ls;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxSize, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ls = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                ls[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (ls[i][j] == 1){
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxSize);
    }

    static void bfs(int x, int y){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x, y});
        cnt++;
        ls[x][y] = -1;
        int size = 1;
        while(!dq.isEmpty()){
            int[] temp = dq.poll();

            for (int i = 0; i < 4; i++){
                int mx = temp[0] + dx[i];
                int my = temp[1] + dy[i];
                if (-1 < mx && mx < N && -1 < my && my < M){
                    if (ls[mx][my] == 1){
                        size++;
                        ls[mx][my] = -1;
                        dq.add(new int[]{mx, my});
                    }
                }
            }
        }
        maxSize = Math.max(maxSize, size);
    }
}
