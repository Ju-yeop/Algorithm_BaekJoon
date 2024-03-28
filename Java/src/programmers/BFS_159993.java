package programmers;

import java.util.*;

class BFS_159993 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] end = new int[2];
        int[] key = new int[2];
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                if (maps[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                else if (maps[i].charAt(j) == 'L'){
                    key[0] = i;
                    key[1] = j;
                }
                else if (maps[i].charAt(j) == 'E'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int toKey = bfs(start, key, maps);
        int toEnd = bfs(key, end, maps);
        if (toKey == -1 || toEnd == -1) return -1;
        return toKey + toEnd;
    }

    int bfs(int[] start, int[] end, String[] maps){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        dq.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!dq.isEmpty()){
            int[] node = dq.poll();
            if (node[0] == end[0] && node[1] == end[1]) return node[2];
            int yLength = maps[0].length();
            int xLength = maps.length;
            for (int i = 0; i < 4; i++){
                int mx = node[0] + dx[i];
                int my = node[1] + dy[i];
                if (-1 < mx && mx < xLength && -1 < my && my < yLength){
                    if (!visited[mx][my] && maps[mx].charAt(my) != 'X'){
                        visited[mx][my] = true;
                        dq.add(new int[]{mx, my, node[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}
