package programmers;

import java.util.*;

class Impl_134239 {
    public static ArrayList<Integer> ar = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Double> answer = new ArrayList<>();
        recur(k);
        int siz = ar.size() - 1;
        double[] width = new double[siz];
        for (int i = 0; i < siz; i++){
            width[i] = (double)(ar.get(i) + ar.get(i+1)) / 2;
        }

        for (int[] r: ranges){
            int a = r[0];
            int b = siz + r[1];
            if (a > b) answer.add(Double.valueOf(-1));
            else{
                double t = 0;
                for (int i = a; i < b; i++){
                    t += width[i];
                }
                answer.add(t);
            }
        }

        return answer.stream().mapToDouble(i->i).toArray();
    }

    void recur(int x){
        ar.add(x);
        int item = x;
        if (x == 1) return;
        if (x % 2 == 0) item /= 2;
        else if (x % 2 == 1) item = (item*3) + 1;
        recur(item);
    }
}
