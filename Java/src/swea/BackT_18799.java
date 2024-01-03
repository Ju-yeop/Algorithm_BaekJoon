package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BackT_18799{
    static StringTokenizer st;
    static int[] ls;
    static Stack<Integer> stack;
    static double value;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            value = 0;
            ls = new int[N];
            for (int i = 0; i < N; i++){
                ls[i] = Integer.parseInt(st.nextToken());
            }
            stack = new Stack<>();
            backT(-1);
            System.out.println("#" + test_case + " " + (value / (Math.pow(2, N) - 1)));
        }
    }

    static void backT(int lastIdx){
        addAverage(stack);
        for (int i = lastIdx+1; i < ls.length; i++){
            stack.push(ls[i]);
            backT(i);
            stack.pop();
        }
    }

    static void addAverage(Stack<Integer> st){
        if (st.size() != 0) {
            double temp = 0;
            for (int i = 0; i < st.size(); i++) {
                temp += st.get(i);
            }
            value += (temp / (double) st.size());
        }
    }
}
