import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
4 3
1 2 3
2 3 2
2 4 4
1 2
4 1
3 1
 */
public class BFS_15591 {
    public static ArrayList<ArrayList<Node>> ar;

    public static int N;
    public static int Q;
    public static class Node{
        int unit, weight;

        Node(int unit, int weight){
            this.unit = unit;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        ar = new ArrayList<>();
        for (int i = 0; i < N+1; i++){
            ar.add(new ArrayList<>());
        }


        for (int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            ar.get(p).add(new Node(q, r));
            ar.get(q).add(new Node(p, r));
        }


        for (int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            dq.add(v);
            boolean[] visited = new boolean[N+1];
            int answer = 0;

            while(!dq.isEmpty()){
                int s = dq.poll();
                visited[s] = true;
                for (Node n: ar.get(s)){
                    if(!visited[n.unit] && n.weight >= k){
                        answer++;
                        dq.add(n.unit);
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
