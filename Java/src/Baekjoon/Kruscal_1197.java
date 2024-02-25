package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
3 3
1 2 1
2 3 2
1 3 3
 */
public class Kruscal_1197 {
    static int V, E, answer;
    static class Edge{
        int v1, v2, w;
        Edge(int v1, int v2, int w){
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }
    static PriorityQueue<Edge> edges = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
    static StringTokenizer st;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        for (int i = 0; i < V+1; i++) parents[i] = i;
        answer = 0;
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(v1, v2 ,w));
        }

        while(!edges.isEmpty()){
            Edge target = edges.poll();
            if (find(target.v1) == find(target.v2)) continue;
            union(target.v1, target.v2);
            answer += target.w;
        }

        System.out.println(answer);
    }

    static int find(int x){
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);

        if (p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
    }
}
