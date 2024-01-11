package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 17
 */
public class BFS_12851 {

    public static class Node{
        int value, depth;

        Node(int value, int depth){
            this.value = value;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] visited = new int[1000001];

        int cnt = 0;
        int how = 1;
        boolean flag = false;

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start, 0));
        Arrays.fill(visited, 0);

        while(!dq.isEmpty()){
            Node node = dq.poll();
            int value = node.value;
            int depth = node.depth;
            if (flag){
                if (depth > cnt) break;
                if (value == end && depth == cnt) how += 1;
            }

            if (value == end){
                cnt = depth;
                flag = true;
            }
            for (int i = 0; i < 3; i++){
                int next;
                if (i==0) next = value+1;
                else if (i==1) next = value-1;
                else next = value*2;

                if (next > 100000 || next < 0) continue;

                if (visited[next] == 0 || depth+1 == visited[next]){
                    dq.add(new Node(next, depth +1));
                    visited[next] = depth+1;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(how);
    }
}
