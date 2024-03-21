package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
2
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1
9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333
 */
public class PQ_7662 {
    static int T, N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++){
            N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minH = new PriorityQueue<>();
            PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (s.equals("I")){
                    Integer t = map.getOrDefault(num, 0);
                    map.put(num, t + 1);
                    minH.add(num);
                    maxH.add(num);
                }
                else if (s.equals("D")){
                    if (map.size() == 0) continue;
                    if (num == -1) remove(minH, map);
                    else if (num == 1) remove(maxH, map);
                }
            }
            if (map.size() == 0) System.out.println("EMPTY");
            else{
                int item = remove(maxH, map);
                System.out.println(item + " " + (map.size() > 0 ? remove(minH, map) : item));
            }
        }
    }

    static int remove(PriorityQueue<Integer> pq, Map<Integer, Integer> map){
        int key;
        while(true){
            key = pq.poll();
            Integer value = map.getOrDefault(key, 0);
            if (value == 0) continue;
            if (value == 1) map.remove(key);
            else map.put(key, value - 1);
            break;
        }
        return key;
    }
}
