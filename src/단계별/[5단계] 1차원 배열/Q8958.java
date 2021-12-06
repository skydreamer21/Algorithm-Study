// 8958번 OX퀴즈
// 연속된 O의 갯수가 해당 문제로 받은 점수

import java.io.*;

public class Q8958 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s;
        int score;
        int sum;
        for (int i=0;i<N;i++) {
            sum=0;
            score=0;
            s=br.readLine();
            for (int j=0;j<s.length();j++) {
                if (s.charAt(j)=='O') {
                    score++;
                    sum+=score;
                }
                else if (s.charAt(j)=='X') score=0;
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
    }
}



