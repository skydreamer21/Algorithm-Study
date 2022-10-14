// 11720번 숫자의 합
// N개의 공백없는 숫자들의 합

import java.io.*;

public class Q11720 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum=0;
        int val;
        for (int i=0;i<s.length();i++) {
            val=Character.getNumericValue(s.charAt(i));
            sum+=val;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}






