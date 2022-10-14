// 2581번 소수
/*
<문제 정보>
 1. M과 N이 주어질때 사이에 있는 소수의 합과 소수들 중 최솟값을 출력
 2. 첫째줄 M, 둘째줄 N 주어짐. 1<=M<=N<=10000
 3. 소수가 없을 경우 첫째줄에 -1출력

<프로그램 진행>
루트값에서 내림을 한 자연수에서 하나씩 내려가면서 (2까지) 나머지가
0되는 수를 카운트  카운트 1개라도 되면 소수 아님
1은 소수가 아님

<필요 함수>
  1. 정수N입력 받아 소수인지 아닌지 Boolean으로 return
 */

import java.io.*;

public class Q2581 {
    public static Boolean IsThisPrimeNumber(int N) {

        Boolean PrimeNumber = true;
        int sqrtNum = (int) Math.floor(Math.sqrt(N));
        while (sqrtNum>1) {
            if (N%sqrtNum==0) {
                PrimeNumber = false;
                break;
            }
            sqrtNum--;
        }
        if (N==1) PrimeNumber = false;
        return PrimeNumber;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int temp=M;
        int min = 1;
        int sum = 0;
        for (int i=M;i<=N;i++) {
            if (IsThisPrimeNumber(i)) {
                if (min==1) min = i;
                sum+=i;
            }
        }
        if (sum==0) bw.write(String.valueOf(-1));
        else bw.write(sum+"\n"+min);
        bw.flush();
        bw.close();
    }
}




