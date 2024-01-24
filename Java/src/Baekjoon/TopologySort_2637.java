package Baekjoon;

/*
7
8
5 1 2
5 2 2
7 5 2
6 5 2
6 3 3
6 4 4
7 6 3
7 4 5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TopologySort_2637 {
    static int N, M;
    static ArrayList<Node>[] graph;
    static StringTokenizer st;

    static class Node{
        int item, cost;
        Node(int item, int cost){
            this.item = item;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        int[] leafCnt = new int[N+1];
        int[] indegree = new int[N+1];

        for (int i = 0; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, k));
            indegree[y] ++;
            leafCnt[x] ++;
        }

        int[] costs = new int[N+1];

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(N, 1));

        while(!dq.isEmpty()){
            Node node = dq.poll();
            for (int i = 0; i < graph[node.item].size(); i++){
                Node nextNode = graph[node.item].get(i);
                costs[nextNode.item] += (nextNode.cost * node.cost);
                indegree[nextNode.item] --;
                if (indegree[nextNode.item] == 0){
                    dq.add(new Node(nextNode.item, costs[nextNode.item]));
                }
            }
        }

        for (int i = 1; i < N+1; i++){
            if (leafCnt[i] == 0) System.out.println(i + " " + costs[i]);
        }

    }
}
