package swea;

import java.util.*;
import java.io.*;

class BFS_5684{
    static class Node{
        int e, value;
        Node(int e, int value){
            this.e = e;
            this.value = value;
        }
    }
    static int N, M;
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N+1; i++){
                arr.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr.get(s).add(new Node(e, v));
            }
            int answer = Integer.MAX_VALUE;
            for (int j = 1; j < N+1; j++){
                int r = bfs(j);
                if (r != -1) answer = Math.min(answer, r);
            }
            if (answer == Integer.MAX_VALUE) System.out.println("#" + test_case + " " + -1);
            else System.out.println("#" + test_case + " " + answer);
        }
    }

    static int bfs(int x){
        visited = new boolean[N+1];
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, 0));
        while(!dq.isEmpty()){
            Node n = dq.poll();
            int t = n.e;
            int current_dist = n.value;
            for (int i = 0; i < arr.get(t).size(); i++){
                Node node = arr.get(t).get(i);
                int end = node.e;
                int value = node.value;
                if (!visited[end]){
                    if (end == x) return current_dist + value;
                    visited[end] = true;
                    dq.add(new Node(end, current_dist + value));
                }
            }
        }
        return -1;
    }
}
