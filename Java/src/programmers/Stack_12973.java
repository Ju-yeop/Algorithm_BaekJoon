package programmers;

import java.util.Stack;

class Stack_12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            }
            else {
                if (c == stack.peek()) {
                    stack.pop();
                }
                else {
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
