package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1 1000
 */
public class Eratos_1016 {
    static long min, max;
    static boolean[] judge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        int size = (int) (max - min + 1);
        judge = new boolean[size];
        double maxSqrt = Math.floor(Math.sqrt(max));

        for(int i = 2; i <= maxSqrt; i++){
            long iPow = (long) Math.pow(i, 2);
            if (iPow < min){
                long temp = min % iPow;
                if (temp != 0) temp = iPow - temp;
                for (long j = temp; j < size; j += iPow){
                    judge[(int) j] = true;
                }
            }
            else{
                for (long j = iPow - min; j < size; j+= iPow){
                    judge[(int) j] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < size; i++){
            if (!judge[i]) answer++;
        }
        System.out.println(answer);
    }
}
