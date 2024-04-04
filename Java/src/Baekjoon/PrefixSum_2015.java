package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
6 5
1 2 3 4 5 0
 */
public class PrefixSum_2015 {
    static int N;
    static long K;
    static long[] ls;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ls = new long[N+1];
        st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 1; i < N+1; i++){
            ls[i] = ls[i-1] + Long.parseLong(st.nextToken());
        }

        map.put(0L, 1);

        for (int i = 1; i < N+1; i++){
            answer += map.getOrDefault(ls[i] - K ,0);
            map.put(ls[i], map.getOrDefault(ls[i], 0) + 1);
        }

        System.out.println(answer);
    }
}
