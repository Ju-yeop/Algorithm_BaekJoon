package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
1 2 3 4 5 6
 */
public class Impl_1041 {
    static int N;
    static int[] dice = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1){
            int maxValue = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < 6; i++){
                sum += dice[i];
                maxValue = Math.max(maxValue, dice[i]);
            }
            System.out.println(sum  - maxValue);
        }
        else{
            long one = (long) ((Math.pow(N-2, 2) * 5 + ((N-2) * 4)) * oneMin());
            long two = ((N-1) * 4 + (N-2) * 4) * twoMin();
            long three = 4 * threeMin();

            System.out.println(one + two + three);
        }
    }

    static long oneMin(){
        long value = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++){
            value = Math.min(value, dice[i]);
        }
        return value;
    }

    static long twoMin(){
        long value = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++){
            for (int j = i+1; j < 6; j++){
                if ((i == 0 && j == 5) || (i == 1 && j == 4) || (i == 2 && j == 3)) continue;
                value = Math.min(value, dice[i] + dice[j]);
            }
        }
        return value;
    }

    static long threeMin(){
        long value = Math.min(dice[1] + dice[2], Math.min(dice[1] + dice[3],
                Math.min(dice[2] + dice[4], dice[3] + dice[4])));
        long temp = Math.min(dice[0], dice[5]);
        return value  + temp;
    }
}
