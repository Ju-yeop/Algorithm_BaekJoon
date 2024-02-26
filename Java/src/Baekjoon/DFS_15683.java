package Baekjoon;

/*
3 7
4 0 0 0 0 0 0
0 0 0 2 0 0 0
0 0 0 0 0 0 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_15683 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][][] mode = {{{0}}, {{0}, {1}, {2}, {3}}, {{2, 3}, {0, 1}},
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}};
    static ArrayList<Node> cctv;
    static class Node {
        int x, y, type;
        public Node(int x, int y, int type) {
            this.x= x;
            this.y= y;
            this.type = type;
        }
    }
    static int n, m, ans;
    static int[][] map;
    static StringTokenizer st;
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cctv = new ArrayList<>();
        int zeroCnt = 0;
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5){
                    cctv.add(new Node(i, j, map[i][j]));
                } else if(map[i][j] == 0) zeroCnt++;
            }
        }
        ans = zeroCnt;
        combination(0, cctv.size(), map);
        System.out.println(ans);
    }


    public static void combination(int depth, int r, int[][] map) {
        if(depth == r) {
            int cnt = check(map);
            ans = Math.min(ans, cnt);
            return;
        }
        int cctvType = cctv.get(depth).type;
        int x = cctv.get(depth).x;
        int y = cctv.get(depth).y;


        for(int i = 0; i < mode[cctvType].length; i++) {
            int[][] map_copy = new int[n][m];
            for(int k=0;k<n;k++) {
                map_copy[k] = map[k].clone();
            }

            for(int j = 0; j < mode[cctvType][i].length; j++){
                int dir = mode[cctvType][i][j];

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (true) {
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                    if(map[nx][ny] == 6) break;
                    map_copy[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }


            combination(depth+1, r, map_copy);
        }
    }

    public static int check(int[][] map) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
