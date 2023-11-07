import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0
 */
public class BFS_6593 {

    public static class Node{
        int z, x, y, time;

        Node(){}

        Node(int z, int x, int y, int time){
            this.z = z;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int[] dx = {1, 0, 0, -1, 0, 0};
    public static int[] dy = {0, 1, -1, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        while (!(L == 0 && R == 0 && C == 0)) {
            String[][][] building = new String[L][R][C];
            int[][][] visited = new int[L][R][C];
            Node start = new Node();
            Node end = new Node();
            int done = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] temp = br.readLine().split("");
                    for (int k = 0; k < temp.length; k++) {
                        visited[i][j][k] = 0;
                        if (temp[k].equals("S")) {
                            start = new Node(i, j, k, 0);
                        } else if (temp[k].equals("E")) {
                            end = new Node(i, j, k, 0);
                        }
                    }
                    building[i][j] = temp;
                }
                br.readLine();
            }

            ArrayDeque<Node> dq = new ArrayDeque<>();
            dq.addLast(start);
            visited[start.z][start.x][start.y] = 1;
            while (!dq.isEmpty()) {
                Node node = dq.pollFirst();
                int z = node.z;
                int x = node.x;
                int y = node.y;
                int time = node.time;

                if (z == end.z && x == end.x && y == end.y) {
                    System.out.printf("Escaped in %d minute(s).\n", time);
                    done = 1;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int mz = z + dz[i];
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (-1 < mz && mz < L && -1 < mx && mx < R && -1 < my && my < C) {
                        if (visited[mz][mx][my] == 0 &&
                                (building[mz][mx][my].equals(".") || building[mz][mx][my].equals(
                                        "E"))) {
                            visited[mz][mx][my] = 1;
                            dq.addLast(new Node(mz, mx, my, time + 1));
                        }
                    }
                }
            }

            if (done == 0) {
                System.out.println("Trapped!");
            }

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }


    }
}
