package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7
 */
public class TopologySort_1005 {
    static int T, N, K, W;
    static StringTokenizer st;
    static int[] times;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static int[] maxTime;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            times = new int[N+1];
            indegree = new int[N+1];
            maxTime = new int[N+1];
            answer = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++){
                times[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++){
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                indegree[end] ++;
            }
            W = Integer.parseInt(br.readLine());

            topologySort();
            System.out.println(answer + maxTime[W]);
        }
    }

    static void topologySort(){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < N+1; i++){
            if (indegree[i] == 0) dq.add(i);
        }
        while(!dq.isEmpty()){
            int temp = dq.poll();
            int time = times[temp];
            if (temp == W){
                answer += times[temp];
                break;
            }
            for (int i = 0; i < graph[temp].size(); i++){
                int next = graph[temp].get(i);
                indegree[next] --;
                maxTime[next] = Math.max(maxTime[next], maxTime[temp] + time);
                if (indegree[next] == 0){
                    dq.add(next);
                }
            }
        }
    }
}
