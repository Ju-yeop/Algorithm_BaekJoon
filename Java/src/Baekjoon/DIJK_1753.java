package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
public class DIJK_1753 {

    public static StringTokenizer st;

    public static class Node{
        int dest, w;

        Node(int dest, int w){
            this.dest = dest;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++){
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(d, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        int[] result = new int[v+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;

        pq.add(new Node(start, result[start]));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int crt_dest = node.dest;
            int crt_w = node.w;

            if(result[crt_dest] < crt_w){continue;}

            for (Node n : graph.get(crt_dest)){
                int next_dest = n.dest;
                int next_w = n.w;
                int t = result[crt_dest] + next_w;
                if (t < result[next_dest]){
                    result[next_dest] = t;
                    pq.add(new Node(next_dest, t));
                }
            }
        }

        for (int i = 1; i < result.length; i++){
            if (result[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else {System.out.println(result[i]);}
        }
    }
}
