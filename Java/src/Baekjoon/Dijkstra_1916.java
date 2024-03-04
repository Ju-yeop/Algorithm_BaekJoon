package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
 */
public class Dijkstra_1916 {
    static int N, M, start, end;
    static ArrayList<int[]>[] cities;
    static StringTokenizer st;
    static int[] distance;
    static class Node{
        int p, w;
        Node(int p, int w){
            this.p = p;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cities = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) cities[i] = new ArrayList<>();

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            cities[start].add(new int[]{end, value});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(distance[end]);
    }

    static void dijkstra(){
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (node.w > distance[node.p]) continue;

            for (int[] next : cities[node.p]){
                if (distance[next[0]] > distance[node.p] + next[1]){
                    distance[next[0]] = distance[node.p] + next[1];
                    pq.add(new Node(next[0], distance[next[0]]));
                }
            }
        }
    }
}
