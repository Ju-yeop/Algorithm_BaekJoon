package programmers;
import java.util.*;

class BFS_169199 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    static class Node{
        int x, y, cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(String[] board) {
        int answer = -1;
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length(); j++){
                if (board[i].charAt(j) == 'R'){
                    start[0] = i;
                    start[1] = j;
                }
                else if (board[i].charAt(j) == 'G'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        boolean[][] visited = new boolean[board.length][board[0].length()];
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        while(!dq.isEmpty()){
            Node node = dq.poll();
            if (node.x == end[0] && node.y == end[1]){
                answer = node.cnt;
                break;
            }

            for (int i = 0; i < 4; i++){
                int mx = node.x;
                int my = node.y;
                while (-1 != mx && mx != board.length && -1 != my && my != board[0].length()
                        && board[mx].charAt(my) != 'D') {
                    mx += dx[i];
                    my += dy[i];
                }
                mx -= dx[i];
                my -= dy[i];
                if (!visited[mx][my]){
                    visited[mx][my] = true;
                    dq.add(new Node(mx, my, node.cnt + 1));
                }
            }
        }

        return answer;
    }
}
