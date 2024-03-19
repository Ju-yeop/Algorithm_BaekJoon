package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
(1+(2*(3+4)))
 */
public class DFS_2800 {
    static String s;
    static ArrayList<Pair> pairs = new ArrayList<>();
    static Set<String> result = new TreeSet<>();
    static class Pair{
        int open, close;
        Pair(int open, int close){
            this.open = open;
            this.close = close;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        Stack<Integer> tmp = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') tmp.add(i);
            else if(s.charAt(i) == ')') pairs.add(new Pair(tmp.pop(), i));
        }
        dfs(0, s);
        result.remove(s);
        StringBuilder answer = new StringBuilder();
        for (String s : result) answer.append(s).append("\n");
        System.out.print(answer);
    }

    static void dfs(int depth, String temp){
        if (depth == pairs.size()){
            result.add(temp.replaceAll(" ", ""));
            return;
        }
        StringBuilder sb = new StringBuilder(temp);
        sb.setCharAt(pairs.get(depth).open, ' ');
        sb.setCharAt(pairs.get(depth).close, ' ');
        dfs(depth+1, sb.toString());
        dfs(depth+1, temp);
    }
}
