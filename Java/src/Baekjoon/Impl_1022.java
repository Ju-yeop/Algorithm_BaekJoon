package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    -3 -2 -1  0  1  2  3
    --------------------
-3 |37 36 35 34 33 32 31
-2 |38 17 16 15 14 13 30
-1 |39 18  5  4  3 12 29
 0 |40 19  6  1  2 11 28
 1 |41 20  7  8  9 10 27
 2 |42 21 22 23 24 25 26
 3 |43 44 45 46 47 48 49

 -3 -3 2 0
 */
public class Impl_1022 {
    private static int r1, c1, r2, c2, max = 0;
    private static int[][] map;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[r2 - r1 + 1][c2 - c1 + 1];

        fill();
        print();
    }

    private static void fill() {
        int x = 0, y = 0, dir = 0;
        int num = 1, dnum = 1, cnt = 0;

        while (!isFinish()) {
            if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                map[x - r1][y - c1] = num;
            }
            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];

            if (cnt == dnum) {
                cnt = 0;
                if (dir == 1 || dir == 3) dnum++;
                dir = (dir + 1) % 4;
            }
        }
        max = num - 1;
    }

    private static void print() {
        int maxLen = (int) Math.log10(max), len;

        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                len = maxLen - (int) Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isFinish() {
        return map[0][0] != 0 && map[r2 - r1][0] != 0 && map[0][c2 - c1] != 0 && map[r2 - r1][c2 - c1] != 0;
    }
//    static int r1, c1, r2, c2;
//    static int[] dx = {0, -1, 0, 1};
//    static int[] dy = {1, 0, -1, 0};
//    static int[][] graph;
//    static int max, size;
//    static class Node{
//        int num, length, x, y, direction, stack;
//
//        Node(int num, int length, int x, int y, int direction, int stack){
//            this.num = num;
//            this.length = length;
//            this.direction = direction;
//            this.x = x;
//            this.y = y;
//            this.stack = stack;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        r1 = Integer.parseInt(st.nextToken());
//        c1 = Integer.parseInt(st.nextToken());
//        r2 = Integer.parseInt(st.nextToken());
//        c2 = Integer.parseInt(st.nextToken());
//        max = Math.max(Math.abs(r1), Math.max(Math.abs(r2), Math.max(Math.abs(c1), Math.abs(c2))));
//        size = max * 2 + 1;
//        graph = new int[size][size];
//        graph[max][max] = 1;
//
//        ArrayDeque<Node> dq = new ArrayDeque<>();
//        dq.add(new Node(1, 2, max, max, 0, 0));
//        while(!dq.isEmpty()){
//            Node node = dq.poll();
//            int mx = node.x;
//            int my = node.y;
//            boolean judge = false;
//            for (int i = 1; i < node.length; i++){
//                mx = node.x + (i * dx[node.direction]);
//                my = node.y + (i * dy[node.direction]);
//                if (0 > mx || mx >= size || 0 > my || my >= size) {
//                    judge = true;
//                    break;
//                }
//                graph[mx][my] = node.num + i;
//            }
//            if (judge) continue;
//            int direction = (node.direction + 1) % 4;
//            if (node.stack == 1){
//                dq.add(new Node(node.num + node.length - 1,
//                        node.length + 1, mx, my, direction, 0));
//            }
//            else {
//                dq.add(new Node(node.num + node.length - 1,
//                        node.length, mx, my, direction, node.stack + 1));
//            }
//        }
//
//        int maxLength = 0;
//        for (int i = max + r1; i < max + r2 + 1; i++){
//            for (int j = max + c1; j < max + c2 + 1; j++){
//                maxLength = Math.max(maxLength, String.valueOf(graph[i][j]).length());
//            }
//        }
//        maxLength += 1;
//
//        for (int i = max + r1; i < max + r2 + 1; i++){
//            for (int j = max + c1; j < max + c2 + 1; j++){
//                System.out.printf("%" + maxLength + "d", graph[i][j]);
//            }
//            System.out.println();
//        }
//    }
}
