package Baekjoon;
/*
6
10 20 10 30 20 50
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LIS_12738 {
    static int N;
    static int[] ls;
    static StringTokenizer st;
    static ArrayList<Integer> lis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ls = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            ls[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(ls[0]);
        for (int i = 1; i < N; i++){
            if (lis.get(lis.size() - 1) < ls[i]) lis.add(ls[i]);
            else {
                int idx = lowerBound(ls[i]);
                lis.set(idx, ls[i]);
            }
        }
        System.out.println(lis.size());
    }

    static int lowerBound(int key){
        int start = 0;
        int end = lis.size();
        while(start < end){
            int mid = (start + end) / 2;
            if (lis.get(mid) < key) start = mid +1;
            else end = mid;
        }
        return end;
    }
}
