
import java.io.*;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class test24 {
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] cur = new int[2];
        cur[0] = 1;  cur[1] = 1;
        int x; int y;
        for (int[] d : dir) {
            x=cur[0]+d[0]; y=cur[1]+d[1];
            System.out.printf("%d,%d\n",x,y);
        }
        int[] temp = new int[2];
        for (int[] d : dir) {
            temp[0]=cur[0]+d[0]; temp[1]=cur[1]+d[1];
            System.out.printf("%d,%d\n",temp[0],temp[1]);
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
