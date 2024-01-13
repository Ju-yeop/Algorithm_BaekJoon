package Baekjoon;

import java.io.*;
import java.util.*;

public class BFS_14502 {
    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, 1, -1 };
    static int N, M;
    static int[][] map;
    static int[][] result = new int[3][2];
    static int res = Integer.MIN_VALUE;
    static int zeroCnt;
    static ArrayList<int[]> twos = new ArrayList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        zeroCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2)
                    twos.add(new int[] { i, j });
                else if (map[i][j] == 0)
                    zeroCnt++;
            }
        }


        combi(0, 0);
        System.out.println(res);
    }

    static void combi(int idx, int start) {
        if (idx == 3) {
            int[][] newMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                newMap[i] = map[i].clone();
            }
            for (int[] r : result) {
                newMap[r[0]][r[1]] = 1;
            }
            int tmp = fillTwo(newMap, zeroCnt - 3);
            res = Math.max(res, tmp);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;
            if (map[r][c] == 0) {
                result[idx][0] = r;
                result[idx][1] = c;
                combi(idx + 1, i + 1);
            }
        }
    }

    static int fillTwo(int[][] newMap, int zeroCnt) {
        boolean[][] visit = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int[] pair : twos) {
            // start bfs
            if (!visit[pair[0]][pair[1]]) {
                q.offer(pair);
                visit[pair[0]][pair[1]] = true;
                while (!q.isEmpty()) {
                    int[] tmp = q.poll();
                    int i = tmp[0];
                    int j = tmp[1];
                    for (int n = 0; n < 4; n++) {
                        int ni = i + di[n];
                        int nj = j + dj[n];

                        if (ni < 0 || ni >= N || nj < 0 || nj >= M)
                            continue;

                        if (newMap[ni][nj] != 0 || visit[ni][nj])
                            continue;

                        q.offer(new int[] { ni, nj });
                        visit[ni][nj] = true;
                        newMap[ni][nj] = 2;
                        zeroCnt -= 1;
                    }
                }
            }
        }
        return zeroCnt;
    }
}
