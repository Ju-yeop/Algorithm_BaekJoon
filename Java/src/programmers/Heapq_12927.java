package programmers;

import java.util.*;

class Heapq_12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> hq = new PriorityQueue<>((i1, i2) -> i2- i1);
        for (int i = 0; i < works.length; i++){
            hq.add(works[i]);
        }
        while(n > 0){
            int temp = hq.poll();
            if (temp != 0) hq.add(temp - 1);
            else hq.add(temp);
            n--;
        }

        while(!hq.isEmpty()){
            answer += (long) Math.pow(hq.poll(), 2);
        }

        return answer;
    }
}
