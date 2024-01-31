package Baekjoon;

/*
3
10010111
011000100110001
0110001011001

(100+1+ | 01)+
 */
import java.util.*;

public class Impl_1013 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String vega = "(100+1+|01)+";
        int t = scan.nextInt();

        for(int i = 0; i < t; i++) {
            String spread = scan.next();
            if(spread.matches(vega)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

