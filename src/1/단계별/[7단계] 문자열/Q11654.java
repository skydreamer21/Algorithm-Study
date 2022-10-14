// 11654번 아스키코드
// 알파벳이나 숫자 중 하나 주어졌을 때 아스키 코드값을 출력

import java.io.*;

public class Q11654 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        char c = br.readLine().charAt(0);
        int num = (int) c;
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }
}






