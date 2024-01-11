package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
3 4 3
abcb
bcaa
abac
aba
abc
cab
 */
public class Hash_BFS_20166 {
    public static char[][] ar;
    public static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    public static HashMap<String, Integer> hm;
    public static int maxLen = 0;
    public static class Node{
        int x, y, depth;
        String str;
        Node(int x, int y, int depth, String str){
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.str = str;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ar = new char[n][m];
        hm = new HashMap<>();

        String[] keys = new String[k];

        for (int i = 0; i < n; i++){
            ar[i] = br.readLine().toCharArray();
        }
        for (int j = 0; j < k; j++){
            String t = br.readLine();
            keys[j] = t;
            maxLen = Integer.max(maxLen, t.length());
            hm.put(t, 0);
        }

        for (int v = 0; v < n ; v++){
            for (int w = 0; w < m; w++){
                bfs(new Node(v, w, 0, ar[v][w] + ""), n, m);
            }
        }

        for (String v : keys){
            System.out.println(hm.get(v));
        }
    }
    
    public static void bfs(Node node, int n, int m){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(node);
        while (!dq.isEmpty()){
            Node temp = dq.poll();
            int x = temp.x;
            int y = temp.y;
            int depth = temp.depth;
            String str = temp.str;
            if (depth >= maxLen) continue;
            if (hm.containsKey(str)){
                hm.put(str, hm.get(str) + 1);
            }
            for (int i = 0; i < 8; i++){
                int mx = (x + dx[i]) % n;
                int my = (y + dy[i]) % m;
                if (mx < 0) mx+=n;
                if (my < 0) my+=m;

                dq.add(new Node(mx, my, depth+1, str + ar[mx][my]));
            }
        }
    }
}
