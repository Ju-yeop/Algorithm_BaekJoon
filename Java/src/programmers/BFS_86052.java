package programmers;

import java.util.*;

class BFS_86052 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static int[][][] visited;
    public int[] solution(String[] grid) {
        visited = new int[grid.length][grid[0].length()][4];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length(); j++){
                for (int k = 0; k < 4; k++){
                    if (visited[i][j][k] == 0){
                        bfs(i, j, k, grid);
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }

    public void bfs(int a, int b, int d, String[] grid){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{a, b, d, 1});

        while (!dq.isEmpty()){
            int[] t = dq.poll();
            int x = t[0];
            int y = t[1];
            int direction = t[2];
            int depth = t[3];


            int mx = (x + dx[direction]) % grid.length;
            int my = (y + dy[direction]) % grid[0].length();

            if (mx < 0) mx += grid.length;
            if (my < 0) my += grid[0].length();

            int next_direction;
            if (grid[mx].charAt(my) == 'L') next_direction = direction -1;
            else if (grid[mx].charAt(my) == 'R') next_direction = direction + 1;
            else next_direction = direction;

            if (next_direction < 0) next_direction += 4;
            else if (next_direction > 3) next_direction -= 4;

            if (mx == a && my == b && next_direction == d){
                answer.add(depth);
                break;
            }

            if (visited[mx][my][next_direction] == 0){
                visited[mx][my][next_direction] = 1;
                dq.add(new int[]{mx, my, next_direction, depth+1});
            }
        }
    }
}
