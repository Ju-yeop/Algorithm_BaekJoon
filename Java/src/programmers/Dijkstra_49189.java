package programmers;

import java.util.*;

class Dijkstra_49189 {

    static class Node{
        int x, value;
        Node(int x, int value){
            this.x = x;
            this.value = value;
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for (int[] e : edge){
            graph.get(e[0]).add(new Node(e[1], 1));
            graph.get(e[1]).add(new Node(e[0], 1));
        }

        int[] dist = dijkstra(n);

        int maxV = 0;
        for (int i = 1; i < n+1; i++){
            System.out.println(dist[i]);
            if (dist[i] != Integer.MAX_VALUE){
                maxV = Math.max(maxV, dist[i]);
            }
        }

        for (int i = 1; i < n+1; i++){
            if (dist[i] == maxV) answer++;
        }

        return answer;
    }

    int[] dijkstra(int n){
        PriorityQueue<int[]> hq = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        hq.add(new int[]{1, 0});

        while(!hq.isEmpty()){
            int[] temp = hq.poll();
            int currentNode = temp[0];
            int currentValue = temp[1];

            if (currentValue > distance[currentNode]) continue;

            for (Node node : graph.get(currentNode)){
                int nextNode = node.x;
                int nextValue = node.value;
                if (distance[currentNode] + nextValue < distance[nextNode]){
                    distance[nextNode] = distance[currentNode] + nextValue;
                    hq.add(new int[]{nextNode, distance[nextNode]});
                }
            }
        }
        return distance;
    }
}
