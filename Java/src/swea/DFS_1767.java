package swea;

/*
3
7
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
9
0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0
0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 1
11
0 0 1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 1
0 0 0 1 0 0 0 0 1 0 0
0 1 0 1 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_1767 {
    static int n, core, answer, count;
    static int[][] map;
    static ArrayList<int[]> list;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Byte.parseByte(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1)
                        list.add(new int[]{i, j});
                }
            }

            core = 0;
            answer = 144;

            dfs(0, 0, 0);
            System.out.println("#" + t + " " + answer);
        }
    }

    static void dfs(int depth, int c, int line) {
        if (depth == list.size()) {
            if (core < c) {
                core = c;
                answer = line;
            } else if (core == c) {
                if (answer > line) answer = line;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (isConnect(list.get(depth), i)) {
                fill(list.get(depth), i, 2);
                dfs(depth + 1, c + 1, line + count);
                fill(list.get(depth), i, 0);
            }
        }
        dfs(depth + 1, c, line);
    }

    static void fill(int[] index, int dir, int value) {
        count = 0;

        int x = index[0] + dx[dir];
        int y = index[1] + dy[dir];
        while (x >= 0 && y >= 0 && x < n && y < n) {
            map[x][y] = value;
            count++;
            x = x + dx[dir];
            y = y + dy[dir];
        }
    }

    static boolean isConnect(int[] index, int dir) {
        int x = index[0] + dx[dir];
        int y = index[1] + dy[dir];

        while (x >= 0 && y >= 0 && x < n && y < n) {
            if (map[x][y] != 0) return false;
            x = x + dx[dir];
            y = y + dy[dir];
        }
        return true;
    }
}
