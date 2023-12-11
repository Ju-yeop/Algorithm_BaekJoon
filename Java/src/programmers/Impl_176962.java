package programmers;

import java.util.*;

class Impl_176962 {
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();

        Arrays.sort(plans, (s1, s2) -> {
            int time1 = convertTime(s1);
            int time2 = convertTime(s2);
            return time1 - time2;
        });
        ArrayDeque<String[]> dq = new ArrayDeque<>();
        Stack<String[]> left = new Stack<>();
        for (String[] s: plans){
            dq.add(s);
        }


        while (!dq.isEmpty()){
            String[] current = dq.poll();
            int currentTime = convertTime(current);
            int duration = Integer.valueOf(current[2]);
            int endTime = currentTime + duration;
            if (dq.isEmpty()) {
                answer.add(current[0]);
                continue;
            }

            String[] next = dq.peek();
            int nextTime = convertTime(next);
            if (endTime <= nextTime){
                answer.add(current[0]);
                if (endTime < nextTime){
                    int leftTime = nextTime - endTime;
                    while (!left.isEmpty() && leftTime > 0){
                        String[] last = left.pop();
                        int time = Integer.valueOf(last[2]);
                        if (leftTime < time){
                            left.add(new String[]{last[0], last[1], String.valueOf(time - leftTime)});
                        }
                        else if (leftTime >= time){
                            answer.add(last[0]);
                        }
                        leftTime -= time;
                    }
                }
            }
            else if (endTime > nextTime){
                left.add(new String[]{current[0], current[1], String.valueOf(endTime - nextTime)});
            }
        }

        while (!left.isEmpty()){
            answer.add(left.pop()[0]);
        }

        return answer.toArray(new String[0]);
    }

    public int convertTime(String[] s){
        String[] t = s[1].split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
}