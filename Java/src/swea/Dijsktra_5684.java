package swea;
/*

1
3 4
1 2 1
3 2 1
1 3 5
2 3 2

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijsktra_5684 {
    static class Node{
        int end, value;
        Node(int end, int value){
            this.end = end;
            this.value = value;
        }
    }
    static int N, M, answer;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            graph = new ArrayList<>();
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < N+1; i++){
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                int v = sc.nextInt();
                graph.get(s).add(new Node(e, v));
            }

            for (int i = 1; i < N+1; i++){
                dijkstra(i);
            }

            System.out.println("#" + test_case + " " + (answer == Integer.MAX_VALUE? -1: answer));
        }
    }

    static void dijkstra(int x){
        PriorityQueue<int[]> hq = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        hq.add(new int[]{x, 0});
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while(!hq.isEmpty()){
            int[] temp = hq.poll();
            int current_node = temp[0];
            int current_dist = temp[1];
            if (current_dist != 0 && current_node == x){
                answer = Math.min(answer, dist[current_node]);
            }

            if (current_dist > dist[current_node]) continue;
            for (int i = 0; i < graph.get(current_node).size(); i++){
                Node node = graph.get(current_node).get(i);
                int next_dist = node.value;
                int next_node = node.end;
                if (dist[next_node] > next_dist + current_dist){
                    dist[next_node] = next_dist + current_dist;
                    hq.add(new int[]{next_node, dist[next_node]});
                }
            }
        }
    }
}
