package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5
0 0 1 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
 */
public class BFS_17070 {
    static int N, answer;
    static int[][] board;
    static StringTokenizer st;
    static int[] dx = {0, 1, 1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 0, 1, 1, 0, 1};
    static class Node{
        int x, y, dir;
        Node(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        answer = 0;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (board[N-1][N-1] == 1){
            System.out.println(0);
            return;
        }
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 1, 0));
        while(!dq.isEmpty()){
            Node node = dq.poll();
            int x = node.x;
            int y = node.y;
            int dir = node.dir;

            if (x == N-1 && y == N-1){
                answer++;
                continue;
            }
            if (x == N-1 && dir == 2) continue;
            if (y == N-1 && dir == 0) continue;

            if (dir == 0){
                for (int i = 0; i < 2; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (mx < N && my < N){
                        if (i == 0 && board[mx][my] == 0) dq.add(new Node(mx, my, 0));
                        else if (i == 1 && board[mx - 1][my] == 0 && board[mx][my - 1] == 0 && board[mx][my] == 0)
                            dq.add(new Node(mx, my, 1));
                    }
                }
            }
            else if (dir == 1){
                for (int i = 2; i < 5; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (mx < N && my < N){
                        if (i == 2 && board[mx][my] == 0) dq.add(new Node(mx, my, 2));
                        else if (i == 3 && board[mx][my] == 0) dq.add(new Node(mx, my, 0));
                        else if (i == 4 && board[mx - 1][my] == 0 && board[mx][my - 1] == 0 && board[mx][my] == 0)
                            dq.add(new Node(mx, my, 1));
                    }
                }
            }
            else if (dir == 2){
                for (int i = 5; i < 7; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (mx < N && my < N){
                        if (i == 5 && board[mx][my] == 0) dq.add(new Node(mx, my, 2));
                        else if (i == 6 && board[mx - 1][my] == 0 && board[mx][my - 1] == 0 && board[mx][my] == 0)
                            dq.add(new Node(mx, my, 1));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
