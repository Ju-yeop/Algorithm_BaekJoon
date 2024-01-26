package Baekjoon;

/*
6
10 20 10 30 20 50
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LIS_14003 {
    static int N;
    static int[] ls, idxAr;
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayDeque<Integer> answer = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ls = new int[N];
        idxAr = new int[N];
        for (int i = 0; i < N; i++){
            ls[i] = Integer.parseInt(st.nextToken());
        }

        result.add(ls[0]);
        idxAr[0] = 0;
        for (int i = 1; i < N; i++){
            if (ls[i] > result.get(result.size() - 1)){
                result.add(ls[i]);
                idxAr[i] = result.size() - 1;
            }
            else {
                int keyIdx = lowerBound(ls[i]);
                idxAr[i] = keyIdx;
                result.set(keyIdx, ls[i]);
            }
        }

        int flag = result.size() - 1;
        for (int i = N - 1; i >= 0; i--){
            if (idxAr[i] == flag){
                answer.addFirst(ls[i]);
                flag --;
            }
        }
        System.out.println(result.size());
        while(!answer.isEmpty()){
            int temp = answer.poll();
            System.out.print(temp + " ");
        }

    }

    static int lowerBound(int key){
        int left = 0;
        int right = result.size();
        while (left < right){
            int mid = (left + right) / 2;
            if (result.get(mid) < key) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
