package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
 */
public class DFS_13023 {

    static int N, M;
    static StringTokenizer st;
    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static boolean judge = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];
        for (int i = 0; i < N; i++){
            friends[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }
        visited = new boolean[N];
        for (int i = 0; i < N; i++){
            if(judge) break;
            dfs(i, 1);
        }

        System.out.println(judge ? 1 : 0);

    }

    public static void dfs(int start, int depth){
        if (depth == 5){
            judge = true;
            return;
        }
        visited[start] = true;
        for (int i = 0; i < friends[start].size(); i++){
            int temp = friends[start].get(i);
            if (!visited[temp]){
                dfs(temp, depth+1);
            }
        }
        visited[start] = false;
    }
}
