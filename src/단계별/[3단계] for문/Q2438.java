// 2438번 별 찍기 -1

import java.io.*;

public class Q2438 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        for (int i=1;i<=N;i++) {
            for(int j=1;j<=i;j++) {
                bw.write("*");
                if (j==i) bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}






