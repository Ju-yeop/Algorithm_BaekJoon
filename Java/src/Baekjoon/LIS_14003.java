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
import java.util.Stack;
import java.util.StringTokenizer;

public class LIS_14003 {
    static int N;
    static int[] arr, dpIdx;
    static ArrayList<Integer> dp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dpIdx = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp.add(arr[0]);
        for(int i = 1; i < N; i++){
            if (arr[i] > dp.get(dp.size() - 1)){
                dpIdx[i] = dp.size();
                dp.add(arr[i]);
            }
            else{
                int targetIdx = lowerBound(arr[i]);
                dpIdx[i] = targetIdx;
                dp.set(targetIdx, arr[i]);
            }
        }

        System.out.println(dp.size());
        int temp = dp.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i > -1; i--){
            if (dpIdx[i] == temp) {
                stack.add(arr[i]);
                temp--;
            }
        }
        while(!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }

    static int lowerBound(int target){
        int start = 0;
        int end = dp.size();
        int mid;
        while (start < end){
            mid = (start + end) / 2;
            if (target > dp.get(mid)) start = mid + 1;
            else end = mid;
        }
        return end;
    }
}
