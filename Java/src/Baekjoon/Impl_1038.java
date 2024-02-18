package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Impl_1038 {
    private static int N;
    private static List<Long> ls = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++){
            recur(0, i);
        }
        Collections.sort(ls);
        System.out.println(ls.get(N));
    }

    private static void recur(int size, long num){
        if (size > 10) return;
        ls.add(num);
        for (int i = 0; i < num % 10; i++){
            recur(size + 1, num * 10 + i);
        }
    }
}
