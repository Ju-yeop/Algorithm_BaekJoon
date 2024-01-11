package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
3 2
1 3
2 3
 */
public class TopologySort_2252 {
    static int[] indegree;
    static StringTokenizer st;
    static int[][] order;
    static List<Integer>[] ls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        order = new int[m][2];
        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }
        ls = new ArrayList[n+1];
        for (int i = 0 ; i < n+1; i++) ls[i] = new ArrayList<>();
        indegree = new int[n+1];

        for (int[] o : order) {
            indegree[o[1]]++;
            ls[o[0]].add(o[1]);
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++){
            if (indegree[i] == 0) dq.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(!dq.isEmpty()){
            int cur = dq.poll();
            answer.add(cur);
            for (int i = 0; i < ls[cur].size(); i++){
                int next = ls[cur].get(i);
                if (--indegree[next] == 0){
                    dq.add(next);
                }
            }
        }

        for (Integer t : answer) System.out.println(t + " ");
    }
}
