package Baekjoon;

/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BFS_1707 {
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] colors;
    private static final int RED = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < K; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            colors = new int[V+1];

            for(int vertex = 0 ; vertex < V+1; vertex++) {
                graph.add(new ArrayList<>());
            }

            for(int edge = 0; edge < E; edge++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean judge = false;
            for(int vertex = 1; vertex < V+1; vertex++) {
                if(colors[vertex] == 0) {
                    judge = bfs(vertex, RED);
                }
                if(!judge) break;
            }
            System.out.println(judge ? "YES" : "NO");
        }
    }

    private static boolean bfs(int start, int color) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);

        colors[start] = color;

        while(!dq.isEmpty()) {
            int cur = dq.poll();
            for(int next : graph.get(cur)) {
                if(colors[cur] == colors[next]) return false;
                if(colors[next] == 0) {
                    colors[next] = colors[cur] * -1;
                    dq.add(next);
                }
            }
        }
        return true;
    }
}
