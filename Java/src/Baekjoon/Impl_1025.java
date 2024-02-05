package Baekjoon;

/*
6 7
3791178
1283252
4103617
8233494
8725572
2937261
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Impl_1025 {
    static int N, M;
    static String[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N];
        for (int i = 0; i < N; i++) board[i] = br.readLine();
        int answer = -1;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                for (int x = -N; x < N; x++){
                    for (int y = -M; y < M; y++){
                        if (x == 0 && y == 0) continue;
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < 9; k++){
                            int mx = i + x * k;
                            int my = j + y * k;
                            if (-1 < mx && mx < N && -1 < my && my < M){
                                sb.append(board[mx].charAt(my));
                                int temp = Integer.parseInt(sb.toString());
                                if (Math.sqrt(temp) % 1 == 0){
                                    answer = Math.max(answer, temp);
                                }
                            }
                        }

                    }
                }
            }
        }
        System.out.println(answer);
    }
}
