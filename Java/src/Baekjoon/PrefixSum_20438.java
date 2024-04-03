package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PrefixSum_20438 {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A= new int[N+3];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<K; i++){
            A[Integer.parseInt(st.nextToken())] = -1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Q; i++){
            check(Integer.parseInt(st.nextToken()));
        }

        int[] sum = new int[N+3];
        for(int i=3; i<sum.length; i++){
            sum[i] = sum[i-1] + (A[i] != 1 ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(sum[b] - sum[a-1]).append("\n");
        }
        System.out.println(sb);

    }

    public static void check(int x){
        if(A[x] == -1) return;
        int times = 2;

        for(int i = x; i<A.length; i = x * times++){
            if(A[i] == 0){
                A[i] = 1;
                check(i);
            }
        }

    }

}