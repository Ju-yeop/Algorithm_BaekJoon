package programmers;

import java.util.*;

class Graph_258711 {
    static int n;
    public int[] solution(int[][] edges) {
        int[] answer = new int[]{0, 0, 0, 0};
        n = edges.length;
        int maxNode = 0;
        for (int[] edge: edges){
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < maxNode+1; i++){
            arr.add(new int[]{0, 0});
        }

        for (int[] edge: edges){
            arr.get(edge[0])[0] += 1; //out
            arr.get(edge[1])[1] += 1; //in
        }

        int total = 0;
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i)[0] > 1 && arr.get(i)[1] == 0){
                answer[0] = i;
                total = arr.get(i)[0];
                for (int[] edge: edges){
                    if (edge[0] == i) arr.get(edge[1])[1] -= 1;
                }
                arr.remove(i);
                break;
            }
        }
        arr.remove(0);

        int cnt = 0;
        for (int[] inOut: arr){
            if (inOut[0] == 2 && inOut[1] == 2){
                answer[3] += 1;
                cnt ++;
            }
            else if (inOut[1] == 0){
                answer[2] += 1;
                cnt ++;
            }
        }
        answer[1] = total - cnt;

        return answer;
    }
}
