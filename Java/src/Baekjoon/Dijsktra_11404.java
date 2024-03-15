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
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
 */
public class Dijsktra_11404 {
    static class Node{
        int city, cost;
        Node(int city, int cost){
            this.city = city;
            this.cost = cost;
        }
    }
    static int C, B;
    static StringTokenizer st;
    static ArrayList<Node>[] ar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        ar = new ArrayList[C+1];
        for (int i = 0; i < C + 1; i++){
            ar[i] = new ArrayList<>();
        }
        for (int i = 0; i < B; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            ar[start].add(new Node(end, cost));
        }

        for (int i = 1; i < C+1; i++){
            dijkstra(i);
        }
    }

    static void dijkstra(int startCity){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        pq.add(new Node(startCity, 0));
        int[] distances = new int[C + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startCity] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int city = node.city;
            int cost = node.cost;
            if (cost > distances[city]) continue;
            for (Node n : ar[city]){
                int nextCity = n.city;
                int nextCost = n.cost;
                if (distances[nextCity] > distances[city] + nextCost){
                    distances[nextCity] = distances[city] + nextCost;
                    pq.add(new Node(nextCity, distances[nextCity]));
                }
            }
        }

        for (int i = 1; i < C+1; i++) {
            if (distances[i] == Integer.MAX_VALUE) System.out.print(0 + " ");
            else System.out.print(distances[i] + " ");
        }
        if (startCity != C) System.out.println("");
    }
}
