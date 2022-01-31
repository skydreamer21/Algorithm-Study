// 1676번 팩토리얼 0의 개수

/*
<문제 정보>
 1. N! 뒤에서부터 나오는 0의 개수 출력
 2. 0<=N<=500

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q1676 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int ans=0;
        while(N>0) {
            N/=5;
            ans+=N;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}