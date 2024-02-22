package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
8 30 4 30
7
9
7
30
2
7
9
25
 */
public class Impl_15961 {
    static StringTokenizer st;
    static int N, SORT, L, BONUS;
    static int[] ls, selected;
    static int result, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        SORT = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        BONUS = Integer.parseInt(st.nextToken());
        ls = new int[N];
        for (int i = 0; i < N; i++){
            ls[i] = Integer.parseInt(br.readLine());
        }
        selected = new int[SORT+1];
        Arrays.fill(selected, 0);
        result = 1;
        answer = 0;
        selected[BONUS] ++;

        for (int i = 0; i < L; i++){
            if (selected[ls[i]] == 0) result += 1;
            selected[ls[i]] += 1;
        }
        int idx = L;
        while (idx != L-1){
            int first;
            if (idx >= L) first = idx - L;
            else first = idx - L + N;
            selected[ls[first]] --;
            if (selected[ls[first]] == 0) result--;
            if (selected[ls[idx]] == 0) result ++;
            selected[ls[idx]] ++;

            answer = Math.max(answer, result);
            if (idx == N-1) idx = 0;
            else idx ++;
        }

        System.out.println(answer);
    }
}
