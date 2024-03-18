package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
7
2 3 4 1 3 4 5
 */
public class Impl_1548 {
    static int N;
    static int[] ls;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ls = new int[N];
        for (int i = 0; i < N; i++){
            ls[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ls);
        int answer = 2;
        if (N < 3) answer = N;
        else{
            for (int i = N-1; i > 1; i--){
                for (int j = 0; j < i-1; j++){
                    if (judge(ls[j], ls[j+1], ls[i])){
                        answer = Math.max(answer, i - j + 1);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static boolean judge(int a, int b, int c){
        return a + b > c;
    }
}
