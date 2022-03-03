// 9372번 상근이의 여행
/*
<문제 정보>
 1. 모든 국가를 여행하기 위해 타야하는 비행기 종류의 최소 개수 출력

<변수 범위>
 1. 1초 / 256MB
 2. 테스트 케이스 T<=100
 3. 국가의 수 2<=N<=1,000
 4. 비행기의 종류 1<=M<=10,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q9372 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int n,m;
        while(T-- >0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            while(m-->0) br.readLine();
            sb.append(n-1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
