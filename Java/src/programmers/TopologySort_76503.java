package programmers;

import java.util.*;

class TopologySort_76503 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] indegree;
    static long[] b;
    public static long solution(int[] a, int[][] edges) {
        long answer = 0;
        int n = a.length;
        indegree = new int[n];
        Arrays.fill(indegree, 0);
        b = new long[n];
        for(int i=0; i<n; i++){
            b[i] = a[i];
            answer += a[i];
        }
        if(answer!=0) return -1;
        if(n==2) return Math.abs(b[0]);

        for (int i = 0; i < n; i++){
            arr.add(new ArrayList<Integer>());
        }
        for (int[] e : edges){
            arr.get(e[0]).add(e[1]);
            arr.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i).size() == 1) {
                dq.add(i);
            }
        }

        while(!dq.isEmpty()){
            int temp = dq.poll();
            answer += (long) Math.abs(b[temp]);
            indegree[temp]--;

            for (int next: arr.get(temp)){
                if (indegree[next] == 0) continue;
                indegree[next] --;
                b[next] += b[temp];
                b[temp] = 0;
                if (indegree[next] == 1){
                    if (next == 0) continue;
                    dq.add(next);
                }
            }
        }


        return Arrays.stream(b).allMatch(i -> i == 0) ? answer : -1;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
    }
}