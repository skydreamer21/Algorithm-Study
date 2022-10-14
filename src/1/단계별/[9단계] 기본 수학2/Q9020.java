// 9020번 골드바흐의 추측

/*
<문제 정보>
 1. 골드바흐의 추측 : 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
  - 이러한 수를 골드바흐의 수
  - 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션
  - 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재
 2. 2보다 큰 짝수 n에 대해 n의 골드바흐 파티션 출력
 * 만약 파티션이 여러가지인 경우 두 소수의 차이가 가장 작은 것으로 출력
 * 출력은 작은 것부터

<프로그램 진행>
 1. 크기가 10000까지 이므로 10000까지의 소수를 다 구해놓는다.
 2. 주어진 숫자 N에 대해 N/2보다 큰 소수와 작은소수의 합으로 나타낼 수 있다면
 그게 골드바흐 파티션
 3. N/2 보다 큰 소수 A를 찾는다 -> N-A가 소수인지 판별
 -> 아니면 찾을때까지 반복

<필요 함수>
 1. 10000까지 소수 담긴 bool 배열 return
 2. 정수 N을 넣으면 N의 골드바흐 파티션 출력

 */

import java.io.*;

public class Q9020 {
    public static boolean[] getPrimeNumberUpTo10000() {
        boolean[] PN = new boolean[10001];
        PN[0]=true;
        PN[1]=true;
        for (int i=2;i<=100;i++) {
            for (int j=i*i;j<=10000;j+=i) {
                if (!PN[i]) PN[j]=true;
            }
        }
        return PN;
    }

    public static int getGoldBachPartition (boolean[] arr, int N) throws IOException {
        int GBP=0;
        for (int i=N/2;i<=10000;i++) {
            if (!arr[i] && !arr[N-i]) {
                GBP = N-i;
                break;
            }
        }
        return GBP;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        boolean[] PNto10000 = getPrimeNumberUpTo10000();
        int n;
        int GBP;
        for (int i=0;i<T;i++) {
            n=Integer.parseInt(br.readLine());
            GBP = getGoldBachPartition(PNto10000,n);
            bw.write(GBP+" "+(n-GBP)+"\n");
        }
        bw.flush();
        bw.close();
    }
}