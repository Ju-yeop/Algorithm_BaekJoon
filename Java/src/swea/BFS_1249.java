package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class BFS_1249{
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node{
        int x;
        int y;
        int value;

        Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(bf.readLine());
            board = new int[N][N];
            for (int i = 0; i < N; i++){
                String s = bf.readLine();
                for (int j = 0; j < N; j++){
                    board[i][j] = s.charAt(j) - '0';
                }
            }
            visited = new boolean[N][N];
            PriorityQueue<Node> hq = new PriorityQueue<>((i1, i2) -> i1.value - i2.value);
            hq.add(new Node(0, 0, 0));
            visited[0][0] = true;

            while(!hq.isEmpty()){
                Node n = hq.poll();
                if (n.x == N-1 && n.y == N-1){
                    System.out.println(n.value);
                    break;
                }
                for (int i = 0; i < 4; i++){
                    int mx = n.x + dx[i];
                    int my = n.y + dy[i];
                    if (-1 < mx && mx < N && -1 < my && my < N){
                        if(!visited[mx][my]){
                            visited[mx][my] = true;
                            hq.add(new Node(mx, my, n.value + board[mx][my]));
                        }
                    }
                }
            }
        }
    }
}
