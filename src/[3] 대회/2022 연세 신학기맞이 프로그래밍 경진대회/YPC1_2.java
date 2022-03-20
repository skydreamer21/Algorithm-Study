// 번
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 1024MB
 2. 1<=T<=10
 3. 1<=N<=10,000
 4. 1<=A,B<=10^9 (크기, 무게 제한)

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class YPC1_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N;
        for (int i=1;i<=T;i++) {
            N = Integer.parseInt(br.readLine());
            br.readLine();
            while(N-->0) br.readLine();
            sb.append("Material Management ").append(i).append("\n");
            sb.append("Classification ---- End!\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
