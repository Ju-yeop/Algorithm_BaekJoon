package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
2
GCF
ACDEB
 */
public class BackT_1339 {
    public static ArrayList<char[]> ls = new ArrayList<>();
    public static int length = 0;
    public static int answer = 0;
    public static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            char[] temp = br.readLine().toCharArray();
            for (char t: temp){
                length = Integer.max(length, t - 'A' + 1);
            }
            ls.add(temp);
        }
//        int [] selected = new int[length];
//        backT(0, selected);
        int [] weight = new int[length];
        for (int i = 0; i < n; i++){
            int w = ls.get(i).length;
            for (int j = 0; j < w; j++){
                int idx = ls.get(i)[j] - 'A';
                weight[idx] += Math.pow(10, w-j-1);
            }
        }
        Arrays.sort(weight);

        int start = 10 - length;
        for (int w: weight){
            answer += (w * start);
            start += 1;
        }

        System.out.println(answer);
    }
    public static void backT(int depth, int[] selected){
        if(depth == length){
            int target = check(selected);
            answer = Integer.max(answer, target);
            return;
        }
        for (int i = 9; i > 9-length; i--){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = i;
                backT(depth+1, selected);
                visited[i] = false;
            }
        }
    }
    public static int check(int[] selected){
        int result = 0;
        for (char[] temp: ls){
            for (int i = 0; i < temp.length; i++){
                int weight = (int) Math.pow(10, temp.length - i - 1);
                result += (selected[temp[i] - 'A'] * weight);
            }
        }
        return result;
    }
}
