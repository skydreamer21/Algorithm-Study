import java.io.*;

public class Q11718 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S;
        StringBuilder sb = new StringBuilder();
        while (true) {
            S = br.readLine();
            if (S==null) break;
            else sb.append(S).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}