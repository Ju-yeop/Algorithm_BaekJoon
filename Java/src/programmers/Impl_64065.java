package programmers;

import java.util.*;

class Impl_64065 {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] str = s.substring(2, s.length() - 2).replace("},{", "-").split("-");
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {

                return Integer.compare(o1.length(), o2.length());
            }
        });
        for (String x : str) {
            String[] temp = x.split(",");
            for (String value : temp) {
                int n = Integer.parseInt(value);
                if (!answer.contains(n))
                    answer.add(n);
            }
        }
        return answer;
    }
}