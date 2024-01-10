package programmers;

import java.util.*;
import static java.lang.Integer.parseInt;


class UnionFind_150366 {
    static int n = 2501;
    static int[] parents = new int[n];
    static String[] values = new String[n];

    public String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++){
            parents[i] = i;
            values[i] = "";
        }
        for (String command : commands){
            String[] cmd = command.split(" ");
            String type = cmd[0];
            if (type.equals("UPDATE")){
                if (cmd.length == 4){
                    update(parseInt(cmd[1]), parseInt(cmd[2]), cmd[3]);
                }
                else {
                    update(cmd[1], cmd[2]);
                }
            }
            else if (type.equals("MERGE")) {
                merge(parseInt(cmd[1]), parseInt(cmd[2]),
                        parseInt(cmd[3]), parseInt(cmd[4]));
            }
            else if (type.equals("UNMERGE")){
                unmerge(parseInt(cmd[1]), parseInt(cmd[2]));
            }
            else {
                answer.add(print(parseInt(cmd[1]), parseInt(cmd[2])));
            }
        }

        return answer.toArray(new String[0]);
    }

    int find(int x){
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    void union(int x, int y){
        if (x != y) parents[y] = x;
    }

    int cal(int r, int c){
        return (r-1) * 50 + c;
    }

    void update(int r, int c, String value){
        values[find(cal(r, c))] = value;
    }

    void update(String value1, String value2){
        for (int i = 0; i < n; i++){
            if (values[i].equals(value1)){
                values[i] = value2;
            }
        }
    }

    void merge(int r1, int c1, int r2, int c2){
        if (r1 == r2 && c1 == c2) return;

        int idx1 = cal(r1, c1);
        int idx2 = cal(r2, c2);

        int root1 = find(idx1);
        int root2 = find(idx2);

        if (root1 == root2) return;

        if(values[root1].isBlank()) values[root1] = values[root2];
        values[root2] = "";

        union(root1, root2);
    }

    void unmerge(int r, int c){
        int idx = cal(r, c);
        int root = find(idx);

        String rootValue = values[root];
        values[root] = "";
        values[idx] = rootValue;

        for (int i = 0; i < n; i++) find(i);

        for (int i = 0; i < n; i++){
            if (parents[i] == root){
                parents[i] = i;
            }
        }

    }

    String print(int r, int c){
        int idx = cal(r, c);
        int root = find(idx);
        return (values[root].isBlank()) ? "EMPTY" : values[root];
    }
}
