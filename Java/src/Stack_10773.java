import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
4
3
0
4
0
 */
public class Stack_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++){
            int t = Integer.parseInt(br.readLine());
            if (t != 0) st.push(t);
            else st.pop();
        }
        for (int s : st) answer += s;
        System.out.println(answer);
    }
}
