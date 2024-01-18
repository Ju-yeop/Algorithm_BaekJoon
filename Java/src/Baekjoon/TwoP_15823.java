package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TwoP_15823 {

    private static int n;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMaxNumOfCards());
    }

    private static int findMaxNumOfCards() {
        int l = 1;
        int r = n / m;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (isPossible(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }

    private static boolean isPossible(int numOfCards) {
        int l = 0;
        int r = 0;
        int ct = 0;
        Set<Integer> picked = new HashSet<>();
        int numOfCardPacks = 0;
        while (r < n) {
            int card = arr[r];

            if (!picked.contains(card)) {
                ct++;
                r++;
                picked.add(card);
            } else {
                while (arr[l] != card) {
                    l++;
                }
                l++;
                r = l;
                ct = 0;
                picked.clear();
            }

            if (ct == numOfCards) {
                numOfCardPacks++;
                l = r;
                r = l;
                ct = 0;
                picked.clear();
            }

            if (numOfCardPacks == m) {
                return true;
            }
        }

        return false;
    }
}
