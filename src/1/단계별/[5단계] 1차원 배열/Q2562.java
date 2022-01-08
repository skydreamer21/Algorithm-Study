// 2562 최댓값

// 입력은 9개

import java.io.*;

public class Q2562 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int val = Integer.parseInt(br.readLine());
        int val_compare;
        int order=1;
        for (int i=2;i<=9;i++) {
            val_compare = Integer.parseInt(br.readLine());
            if (val_compare>val) {
                val = val_compare;
                order =i;
            }
        }
        bw.write(val+"\n"+order);
        bw.flush();
        bw.close();
    }
}