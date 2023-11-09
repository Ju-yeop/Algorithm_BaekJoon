import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
5
2
3
5
10
18
 */
public class BinarySearch_2295 {
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N, num[], sum[], count = 0;

            N = Integer.parseInt(br.readLine());
            num = new int[N];
            sum = new int[N * N];

            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(num);

            for (int i = 0; i < N; i++) {
                for (int j = i; j < N; j++) {
                    sum[count++] = num[i] + num[j];
                }
            }
            Arrays.sort(sum, 0, count - 1);

            for (int i = N - 1; 0 <= i; i--) {
                for (int j = i; 0 <= j; j--) {
                    if (Arrays.binarySearch(sum, 0, count - 1, num[i] - num[j]) < 0) continue;
                    bw.write(String.valueOf(num[i]));
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
//    public static Long[] ar;
//    public static long[] selected = new long[3];
//    public static boolean flag = false;
//    public static int N;
//    public static boolean [] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        ar = new Long[N];
//        visited = new boolean[N];
//        for (int i = 0; i < N; i++){
//            ar[i] = Long.parseLong(br.readLine());
//        }
//        Arrays.sort(ar);
//        dfs(0, 0);
//
//    }
//
//
//    public static void dfs(int depth, int start){
//        if (flag) return;
//        if (depth == 3){
//            long sum = 0;
//            for (long s: selected) sum += s;
//            int f = Arrays.binarySearch(ar, sum);
//            if (f > -1) {
//                System.out.println(ar[f]);
//                flag = true;
//            }
//            return;
//        }
//        for (int i = start; i < N; i++){
//            if (!visited[i]){
//                visited[i] = true;
//                selected[depth] = ar[N - i - 1];
//                dfs(depth+1, i+1);
//                visited[i] = false;
//            }
//        }
//    }
}
