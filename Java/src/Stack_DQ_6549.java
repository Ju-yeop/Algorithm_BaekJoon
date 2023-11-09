import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
7 2 1 4 5 1 3 3
4 1000 1000 1000 1000
0
 */
public class Stack_DQ_6549 {
    public static StringTokenizer st;
    public static Stack<Integer> idxst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            long answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            long [] histogram = new long[N];
            for (int i = 0; i < N; i++){
                histogram[i] = Long.parseLong(st.nextToken());
            }
            idxst = new Stack<>();

            for (int i = 0; i < N; i++){
                while (!idxst.isEmpty() && histogram[idxst.peek()] >= histogram[i]) {
                    int popidx = idxst.pop();
                    int width = idxst.isEmpty() ? i : i - 1 -idxst.peek();
                    answer = Long.max(answer, width * histogram[popidx]);
                }

                idxst.push(i);

            }

            while (!idxst.isEmpty()) {
                int popidx = idxst.pop();
                int width = idxst.isEmpty() ? N : N - 1 -idxst.peek();
                answer = Long.max(answer, width * histogram[popidx]);
            }

            System.out.println(answer);
        }
    }
}
