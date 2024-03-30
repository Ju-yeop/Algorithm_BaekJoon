package programmers;

import java.util.*;

class BFS_154540 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    int xLength, yLength;
    public int[] solution(String[] maps) {
        ArrayList<Integer> result = new ArrayList<>();

        xLength = maps.length;
        yLength = maps[0].length();
        visited = new boolean[xLength][yLength];

        for (int i = 0; i < xLength; i++){
            for (int j = 0; j < yLength; j++){
                if (maps[i].charAt(j) != 'X' && !visited[i][j]){
                    int cnt = bfs(i, j, maps);
                    result.add(cnt);
                }
            }
        }
        if (result.size() == 0) return new int[]{-1};

        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    int bfs(int x, int y, String[] maps){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x, y});
        visited[x][y] = true;
        int result = 0;

        while(!dq.isEmpty()){
            int[] node = dq.poll();
            result += (maps[node[0]].charAt(node[1]) - '0');
            for (int i = 0; i < 4; i++){
                int mx = node[0] + dx[i];
                int my = node[1] + dy[i];
                if (-1 < mx && mx < xLength && -1 < my && my < yLength){
                    if (!visited[mx][my] && maps[mx].charAt(my) != 'X'){
                        visited[mx][my] = true;
                        dq.add(new int[]{mx, my});
                    }
                }
            }
        }
        return result;
    }
}
