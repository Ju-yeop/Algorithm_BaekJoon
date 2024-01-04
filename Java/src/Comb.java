import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Comb {
    public static ArrayList<ArrayList<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];
        int[] ls = {1, 2, 3, 4, 5};


        combination(ls, visited, 0, N, R);
    }
    public static void comb(int[] ls, boolean[] visited, int start, int n, int r){
        if (r == 0){
            System.out.print(Arrays.toString(ls));
            return;
        }
        for (int i = start; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                comb(ls, visited, start+1, n, r-1);
                visited[i] = false;
            }
        }
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            System.out.print(Arrays.toString(arr));
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
