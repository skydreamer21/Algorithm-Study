import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Q11651_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<P5> arr = new ArrayList<>();
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new P5(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr);
        for (P5 point : arr) {
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class P5 implements Comparable<P5>{
    int x,y;

    public P5(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo (P5 o) {
        return (this.y==o.y) ? this.x-o.x : this.y-o.y;
    }
}