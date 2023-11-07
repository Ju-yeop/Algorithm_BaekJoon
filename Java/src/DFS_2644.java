import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */
public class DFS_2644 {

    public static int[] visited;
    public static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public static Boolean done = false;
    public static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visited = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N+1; i++){
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            StringTokenizer tz = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tz.nextToken());
            int e = Integer.parseInt(tz.nextToken());
            lists.get(s).add(e);
            lists.get(e).add(s);
        }

        dfs(start, destination, 0);
        System.out.println(answer);
    }

    public static void dfs(int s, int dest, int depth){
        if (done){
            return;
        }
        if (s == dest){
            done = true;
            answer = depth;
            return;
        }
        visited[s] = 1;
        for (Integer target: lists.get(s)){
            if (visited[target] == 0){
                dfs(target, dest, depth+1);
                visited[target] = 0;
            }
        }
    }
}
