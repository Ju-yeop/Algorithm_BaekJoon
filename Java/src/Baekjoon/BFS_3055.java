package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 4
.D.*
....
..X.
S.*.
....
 */
public class BFS_3055 {
    static int N, M;
    static int[][] floodTime;
    static boolean[][] floodVisited;
    static boolean[][] dooVisited;
    static StringTokenizer st;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        floodVisited = new boolean[N][M];
        dooVisited = new boolean[N][M];
        floodTime = new int[N][M];
        for (int i = 0; i < N; i++){
            Arrays.fill(floodTime[i], Integer.MAX_VALUE);
        }
        int[] arrived = new int[2];
        ArrayDeque<int[]> flood = new ArrayDeque<>();
        ArrayDeque<int[]> doo = new ArrayDeque<>();
        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < M; j++){
                char c = s.charAt(j);
                if (c == 'D'){
                    arrived[0] = i;
                    arrived[1] = j;
                    floodVisited[i][j] = true;
                } else if (c == 'S') {
                    doo.add(new int[]{i, j, 0});
                    dooVisited[i][j] = true;
                } else if (c == '*') {
                    flood.add(new int[]{i, j, 0});
                    floodVisited[i][j] = true;
                } else if (c == 'X') {
                    floodVisited[i][j] = true;
                    dooVisited[i][j] = true;
                }
            }
        }

        while(!flood.isEmpty()){
            int[] t = flood.poll();
            int time = t[2];
            for (int i = 0; i < 4; i++){
                int mx = t[0] + dx[i];
                int my = t[1] + dy[i];
                if (-1 < mx && mx < N && -1 < my && my < M){
                    if (!floodVisited[mx][my]){
                        floodVisited[mx][my] = true;
                        floodTime[mx][my] = time + 1;
                        flood.add(new int[]{mx, my, time + 1});
                    }
                }
            }
        }

        int answer = -1;
        while(!doo.isEmpty()){
            int[] t = doo.poll();
            int time = t[2];
            if (t[0] == arrived[0] && t[1] == arrived[1]){
                answer = time;
                break;
            }
            for (int i = 0; i < 4; i++){
                int mx = t[0] + dx[i];
                int my = t[1] + dy[i];
                if (-1 < mx && mx < N && -1 < my && my < M){
                    if (!dooVisited[mx][my] && time + 1 < floodTime[mx][my]){
                        dooVisited[mx][my] = true;
                        doo.add(new int[]{mx, my, time + 1});
                    }
                }
            }
        }

        System.out.println(answer == -1 ? "KAKTUS" : answer);
    }
}
