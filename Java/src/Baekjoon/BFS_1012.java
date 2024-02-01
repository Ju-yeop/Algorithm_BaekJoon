package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BFS_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, e, count, answer;
    static int [][] map;
    static boolean [][] visit;
    static int [] x={1,-1,0,0},y={0,0,-1,1};
    static Queue<int[] > queue = new LinkedList<>();
    public static void main(String args[]) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for(int p=0; p<T; p++){
            String[] s = br.readLine().split(" ");
            e=Integer.parseInt(s[0]);
            n=Integer.parseInt(s[1]);
            count=Integer.parseInt(s[2]);
            map = new int [n][e];
            visit= new boolean[n][e];
            for(int i=0; i<count;i++){
                String[] s1 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[0]);
                int y = Integer.parseInt(s1[1]);
                map[y][x]=1;
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<e; j++){
                    if(map[i][j]==1 && !visit[i][j]){
                        bfs(i,j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            answer=0;
        }
    }
    public static void bfs(int a, int b){
        queue.add(new int[] {a,b});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int px=poll[1];
            int py= poll[0];

            visit[py][px]=true;

            for(int i=0; i<4; i++){
                int nx = px+x[i];
                int ny = py+y[i];
                if(nx>=0 &&nx<e && ny>=0 && ny<n){
                    if(!visit[ny][nx] && map[ny][nx]==1){
                        queue.add(new int[] {ny,nx});
                        visit[ny][nx]=true;
                    }
                }
            }
        }
    }
}
