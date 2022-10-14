// 4948번 베르트랑 공준

/*
<문제 정보>
 1. 베르트랑 공준 : 임의의 자연수 n에 대하여 n보다 크고, 2n보다 작거나
 같은 소수는 적어도 하나 존재한다.
 2. n이 주어질 때, n보다크고 2n보다 작거나 같은 소수의 개수 출력
 3. 입력은 여러개 테스트 케이스, 마지막 입력이 0

<프로그램 진행>
 1. 앞의 소수 구하기에서의 함수 사용
 ** 문제 조건에서 크기가 123,456까지라 그랬으니까 이만큼 크기를 하나 만들어놓고 계속사용하면
 성능면에서 (메모리, 시간) 이득을 볼수 있음
<필요 함수>
 1. N입력 받아서 N보다 크고 2N보다 작거나 같은 소수 개수 출력

 */

import java.io.*;

public class Q4948 {
    /*
    public static void removeMultiple(boolean[] arr, int prime) {
        for (int i=prime*prime;i<arr.length;i+=prime) arr[i] = true;
    }

    public static int getPrimeNum(int N) {
        int sqrtNum = (int) Math.floor(Math.sqrt(2*N));
        boolean[] PrimeNum = new boolean[2*N+1];
        PrimeNum[0]=true;
        PrimeNum[1]=true;
        int cnt=0;
        for (int i=2;i<=sqrtNum;i++) {
            if (!PrimeNum[i]) removeMultiple(PrimeNum, i);
        }
        for (int i=N+1;i<=2*N;i++) {
            if (!PrimeNum[i]) cnt++;
        }
        return cnt;
    }

     */

    public static int getPrimeNum(int N) {
        boolean[] PrimeNum = new boolean[2*N+1];
        PrimeNum[0]=true;
        PrimeNum[1]=true;
        int cnt=0;
        for (int i=2;i*i<=2*N;i++) {
            for (int j=i*i;j<=2*N;j+=i) {
                if (!PrimeNum[i]) PrimeNum[j]=true;
            }
        }
        for (int i=N+1;i<=2*N;i++) {
            if (!PrimeNum[i]) cnt++;
        }
        return cnt;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        while (true) {
            T=Integer.parseInt(br.readLine());
            if (T==0) break;
            bw.write(getPrimeNum(T)+"\n");
        }
        bw.flush();
        bw.close();
    }
}