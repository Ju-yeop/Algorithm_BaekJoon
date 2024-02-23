package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
 */
public class DFS_17471 {
    static int N, answer;
    static int[] people;
    static ArrayList<Integer>[] graph;
    static StringTokenizer st;
    static ArrayDeque<Integer> first = new ArrayDeque<>();
    static ArrayDeque<Integer> second = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        people = new int[N];
        graph = new ArrayList[N+1];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            for (int j = 0; j < l; j++){
                graph[i+1].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i <= N/2; i++){
            first = new ArrayDeque<>();
            slice(i, 0, 0);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void slice(int count, int depth, int last){
        if (depth == count){
            second = new ArrayDeque<>();
            for (int i = 1; i < N+1; i++){
                if (!first.contains(i)){
                    second.add(i);
                }
            }
            boolean judge1 = bfs(first);
            boolean judge2 = bfs(second);
            if (judge1 && judge2) checkMin(first, second);
            return;
        }
        for (int i = last + 1; i < N+1; i++){
            first.add(i);
            slice(count, depth + 1, i);
            first.pollLast();
        }
    }

    static boolean bfs(ArrayDeque<Integer> area){
        boolean[] visited = new boolean[N+1];
        visited[0] = true;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(area.getFirst());
        visited[area.getFirst()] = true;

        while(!dq.isEmpty()){
            int temp = dq.poll();
            for (int i = 0; i < graph[temp].size(); i++){
                int t = graph[temp].get(i);
                if (!visited[t] && area.contains(t)){
                    visited[t] = true;
                    dq.add(t);
                }
            }
        }

        boolean judge = true;
        Object[] objects = area.toArray();
        for (Object t: objects){
            int temp = (int) t;
            if (!visited[temp]){
                judge = false;
                break;
            }
        }
        return judge;
    }

    static void checkMin(ArrayDeque<Integer> f, ArrayDeque<Integer> s){
        int diff = 0;
        Object[] ar1 = f.toArray();
        Object[] ar2 = s.toArray();
        for (Object o : ar1){
            int t = (int) o;
            diff += people[t-1];
        }
        for (Object o : ar2){
            int t = (int) o;
            diff -= people[t-1];
        }
        answer = Math.min(answer, Math.abs(diff));
    }
}
