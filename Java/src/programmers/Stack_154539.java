package programmers;

import java.util.*;

class Stack_154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> st = new Stack<>();
        for (int i = numbers.length - 1; i > -1; i--){
            while(true){
                if (st.isEmpty()){
                    answer[i] = -1;
                    break;
                }
                if (st.peek() > numbers[i]){
                    answer[i] = st.peek();
                    break;
                }
                else st.pop();
            }
            st.add(numbers[i]);
        }
        return answer;
    }
}
