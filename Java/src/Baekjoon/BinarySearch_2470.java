package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
-2 4 -99 -1 98
 */
public class BinarySearch_2470 {
    static int N;
    static long answer;
    static long[] ls;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ls = new long[N];
        answer = Long.MAX_VALUE;
        long[] result = new long[2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            ls[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ls);
        int start = 0;
        int end = N -1;
        while(start < end){
            long target = ls[start] + ls[end];
            if (answer > Math.abs(target)){
                result[0] = ls[start];
                result[1] = ls[end];
                answer = Math.abs(target);
            }
            if (target > 0) end--;
            else if(target < 0) start++;
            else break;
        }
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1]);
    }

}
