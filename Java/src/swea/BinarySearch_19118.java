package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BinarySearch_19118 {

    static StringTokenizer st;
    static int[] ls;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            ls = new int[N];
            for (int i = 0; i < N; i++){
                ls[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer> lis = new ArrayList<>();
            for (int i = 0; i < N; i++){
                if (lis.isEmpty() || lis.get(lis.size() - 1) < ls[i]){
                    lis.add(ls[i]);
                }
                else {
                    lis.set(binary_search(ls[i], lis), ls[i]);
                }
            }
            System.out.println("#" + test_case + " " + (N - lis.size()));
        }
    }

    static int binary_search(int x, ArrayList<Integer> ar){
        int start = 0;
        int end = ar.size()-1;
        while(start < end){
            int mid = (start + end) / 2;
            if (ar.get(mid) < x) start = mid + 1;
            else end = mid;
        }
        return end;
    }

}
