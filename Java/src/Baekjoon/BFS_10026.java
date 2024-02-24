package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */
public class BFS_10026 {
    static int N, usual, unUsual;
    static int[] answer;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashMap<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        answer = new int[2];
        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            for (int j = 0; j < N; j++){
                graph[i][j] = temp.charAt(j);
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visited[i][j]) bfsUsual(i, j, graph[i][j]);
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visited[i][j]) bfsUnUsual(i, j, graph[i][j]);
            }
        }

        System.out.println(usual + " " + unUsual);
    }

    static void bfsUsual(int x, int y, char s){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x, y});
        visited[x][y] = true;
        usual++;

        while(!dq.isEmpty()){
            int[] temp = dq.poll();
            for (int i = 0; i < 4; i++){
                int mx = dx[i] + temp[0];
                int my = dy[i] + temp[1];
                if (-1 < mx && mx < N && -1 < my && my < N){
                    if (!visited[mx][my] && s == graph[mx][my]){
                        visited[mx][my] = true;
                        dq.add(new int[]{mx, my});
                    }
                }
            }
        }
    }

    static void bfsUnUsual(int x, int y, char s){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x, y});
        visited[x][y] = true;
        unUsual++;

        while(!dq.isEmpty()){
            int[] temp = dq.poll();
            for (int i = 0; i < 4; i++){
                int mx = dx[i] + temp[0];
                int my = dy[i] + temp[1];
                if (-1 < mx && mx < N && -1 < my && my < N && !visited[mx][my]){
                    if (s == 'R' || s == 'G'){
                        if (graph[mx][my] == 'R' || graph[mx][my] == 'G'){
                            visited[mx][my] = true;
                            dq.add(new int[]{mx, my});
                        }
                    }
                    else {
                        if (s == graph[mx][my]) {
                            visited[mx][my] = true;
                            dq.add(new int[]{mx, my});
                        }
                    }
                }
            }
        }
    }
}
