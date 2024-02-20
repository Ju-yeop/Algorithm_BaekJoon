package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
10 9
4 1 2 3 4
2 1 5
2 2 6
1 7
1 8
2 7 8
1 9
1 10
2 3 10
1 4
 */
public class Impl_1043 {
    static int N, M, K;
    static ArrayDeque<Integer> known;
    static ArrayList[] parties;
    static StringTokenizer st;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        known = new ArrayDeque<>();
        for (int i = 0; i < K; i++){
            known.add(Integer.parseInt(st.nextToken()));
        }
        parties = new ArrayList[M];
        checked = new boolean[M];

        for (int i = 0; i < M; i++){
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++){
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        while(!known.isEmpty()){
            int person = known.poll();
            for (int i = 0; i < M; i++){
                if (!checked[i] && parties[i].contains(person)){
                    known.addAll(parties[i]);
                    checked[i] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++){
            if (!checked[i]) answer++;
        }
        System.out.println(answer);
    }
}
