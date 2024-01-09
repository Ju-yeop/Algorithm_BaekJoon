package programmers;

class DFS_Test {
    static boolean[] visited;
    static int result, n;
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        visited = new boolean[n];
        result = Integer.MAX_VALUE;
        dfs(0, begin, target, words);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    void dfs(int depth, String nowStr, String t, String[] w){
        if (depth >= result) return;
        if (nowStr.equals(t)){
            result = depth;
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i] && judge(nowStr, w[i])){
                visited[i] = true;
                dfs(depth+1, w[i], t, w);
                visited[i] = false;
            }
        }
    }

    boolean judge(String a, String b){
        int cnt = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) == b.charAt(i)) cnt ++;
        }
        return cnt == a.length() - 1;
    }
}