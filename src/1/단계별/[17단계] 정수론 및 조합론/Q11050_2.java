// 11050번 이항 계수

/*
<문제 정보>
 1. 자연수 N, 정수 K가 주어졌을 때 이항 계수 (N,K) 구하는 프로그램 작성
 2. 1<=N<=10, 0<=K<=N


<프로그램 진행>
 1. 파스칼의 삼각형 관련 점화식 (파스칼의 법칙)

<필요 함수>
 1.

 */

// 점화식에서 (N,r) = (N,N-r) 을 이용한 dp로 풀면 큰수에 대해서 4배 (시간 1/4배)
// 정도 좋은 성능을 보일 거라 예상

import java.io.*;
import java.util.StringTokenizer;

public class Q11050_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(Binomial_Coefficient(N,K)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int Binomial_Coefficient(int N, int K) {
        if (K==0 || N==K) return 1;
        else return Binomial_Coefficient(N-1,K)+Binomial_Coefficient(N-1,K-1);
    }
}