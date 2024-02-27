package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
2
3 7
racecar
abcdcba
ioioioi
2 3
abb
bba
3 3
abc
ded
cba
4 5
hello
exper
tacad
emyyy
 */
public class Impl_19003 {
    static int T, N, M, answer;
    static StringTokenizer st;
    static ArrayDeque<String> notPal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            notPal = new ArrayDeque<>();
            answer = 0;
            boolean existPal = false;
            for (int i = 0; i < N; i++){
                String s = br.readLine();
                if (!isPal(s)) notPal.add(s);
                else existPal = true;
            }

            while(!notPal.isEmpty()){
                String target = notPal.poll();
                if (notPal.contains(reverseString(target))) answer += 2;
            }

            answer *= M;
            if (existPal) answer += M;
            System.out.println(answer);

        }
    }

    static String reverseString(String t){
        StringBuilder sb = new StringBuilder();
        for (int i = t.length() - 1; i > -1; i--) sb.append(t.charAt(i));
        return sb.toString();
    }

    static boolean isPal(String t){
        for (int i = 0; i < t.length() / 2; i++){
            if (t.charAt(i) == t.charAt(t.length() - i - 1)) continue;
            else return false;
        }
        return true;
    }
}
