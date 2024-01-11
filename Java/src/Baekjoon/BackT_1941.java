package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

/*
YYYYY
SYSYS
YYYYY
YSYYS
YYYYY
 */
public class BackT_1941 {
    public static int answer = 0;
    public static int[] selected = new int[7];
    public static boolean[] visited = new boolean[25];
    public static char[][] graph = new char[5][5];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++){
            graph[i] = br.readLine().toCharArray();
        }
        dfs(0, 0);
        System.out.println(answer);
    }
    public static void dfs(int depth, int start){
        if (depth == 7){
            if(check())answer++;
            return;
        }
        for (int i = start; i < 25; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = i;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
    public static boolean check(){
        int Y = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int s: selected){
            temp.add(s);
            if (graph[s/5][s%5] == 'Y'){
                Y += 1;
            }
        }
        if (Y > 3) return false;

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(selected[0]);

        while(!dq.isEmpty()){
            int n = dq.poll();
            for (int i = 0; i < 4; i++){
                int mx = n/5 + dx[i];
                int my = n%5 + dy[i];
                if (-1 < mx && mx < 5 && -1 < my && my < 5){
                    if (temp.contains(mx*5+my)){
                        temp.remove(Integer.valueOf(mx*5+my));
                        dq.add(mx*5+my);
                    }
                }
            }
        }
        return temp.isEmpty();
    }
}
