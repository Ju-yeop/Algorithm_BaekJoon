import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
 */
public class Tree_1991 {
    public static char[][] tree;
    public static String result = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new char[n][2];
        for (int i = 0; i < n; i++){
            char[] temp = br.readLine().toCharArray();
            tree[temp[0] - 'A'][0] = temp[2];
            tree[temp[0] - 'A'][1] = temp[4];
        }
        preOrder(0);
        System.out.println(result);
        result = "";

        inOrder(0);
        System.out.println(result);
        result = "";

        postOrder(0);
        System.out.println(result);
    }

    public static void preOrder(int node){
        int i = node + 'A';
        result += (char) i;
        if (tree[node][0] != '.') preOrder(tree[node][0] - 'A');
        if (tree[node][1] != '.') preOrder(tree[node][1] - 'A');
    }

    public static void inOrder(int node){
        if (tree[node][0] != '.') inOrder(tree[node][0] - 'A');
        int i = node + 'A';
        result += (char) i;
        if (tree[node][1] != '.') inOrder(tree[node][1] - 'A');
    }

    public static void postOrder(int node){
        if (tree[node][0] != '.') postOrder(tree[node][0] - 'A');
        if (tree[node][1] != '.') postOrder(tree[node][1] - 'A');
        int i = node + 'A';
        result += (char) i;
    }
}
