package programmers;

/**
 * BFS만을 이용한 풀이
 * - visited로 3가지 구분
 * - while문을 반복할 때마다 대상의 다음 순서가 탐험 가능하게 됐는지 확인
 * 위상정렬 이용 풀이
 * - 먼저 BFS를 통해서 무방향 그래프로 변환한 후 위상 정렬 사용
 *
 */
import java.util.*;

class TopologySort_67260 {
    static int N;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public boolean solution(int n, int[][] path, int[][] order) {
        N = n;

        indegree = new int[N];
        Arrays.fill(indegree, 0);

        for (int i = 0; i < N; i++){
            arr.add(new ArrayList<>());
        }
        for (int[] p: path){
            arr.get(p[0]).add(p[1]);
            arr.get(p[1]).add(p[0]);
        }

        return topologySort(bfs(), order);
    }

    List<Integer>[] bfs(){
        boolean[] visited = new boolean[N];
        List<Integer>[] directedGraph = new ArrayList[N];
        for (int i = 0; i < N; i++) directedGraph[i] = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.add(0);
        visited[0] = true;

        while(!dq.isEmpty()){
            int cur = dq.poll();

            for (int next : arr.get(cur)){
                if (!visited[next]){
                    visited[next] = true;
                    dq.add(next);

                    directedGraph[cur].add(next);
                }
            }
        }
        return directedGraph;
    }

    boolean topologySort(List<Integer>[] graph, int[][] order){
        for (List<Integer> g: graph){
            for (Integer i: g){
                indegree[i]++;
            }
        }
        for (int[] o : order){
            indegree[o[1]]++;
            graph[o[0]].add(o[1]);
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++){
            if (indegree[i] == 0) dq.add(i);
        }

        int cnt = 0;
        while(!dq.isEmpty()){
            int cur = dq.poll();
            cnt++;

            for (int i = 0; i < graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if (--indegree[next] == 0){
                    dq.add(next);
                }
            }
        }

        return cnt == N;
    }
}

