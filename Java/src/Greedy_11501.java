import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
 */
public class Greedy_11501 {
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] ar = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                ar[j] = Integer.parseInt(st.nextToken());
            }

            int target = ar[N-1];
            long answer = 0;

            for(int j = N-2; j > -1; j--){
                if (ar[j] < target){
                    answer += (target - ar[j]);
                }
                else if (ar[j] > target){
                    target = ar[j];
                }
            }
            System.out.println(answer);
        }
    }
}