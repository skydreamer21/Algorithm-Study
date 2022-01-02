// 1929번 소수 구하기
// 내 제출 기록 보기 arrays.fill 없앴을때 메모리,시간 이득을봄
/*
<문제 정보>
 1. M 이상 N이하의 소수를 모두 출력 (M<=N<=1,000,000)
 2. 사이에 소수가 하나 이상 있는 입력만 주어짐
 3. 한줄에 하나씩 증가하는 순서대로 소수 입력

<프로그램 진행>
 1. 소수를 배열에 담는게 아닌 1~N까지 배열값에 소수인지 아닌지를 담음
 -> 새로운 배열을 만들 필요없음
 2. 에라토스테네스의 체 이용
 3. 끝이 N일 때, 인덱스와 소수를 같게 하기 위해 N+1 크기의 배열을 만듬

<필요 함수>
  1. 배열과 정수 N이 주어지면 N을 제외한 N의 배수에 해당하는 index값에 false 대입
  2. 정수 N을 받아 N보다 작은 소수가 아닌 인덱스의 값에 false 대입, 배열 return
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1929_2 {
    public static void removeMultiple(boolean[] arr, int prime) {
        // prime * prime 부터 해도 되는 이유 : 이미 앞에서 (prime-1)의 배수들은 다 처리되어 있기 때문
        for (int i=prime*prime; i<arr.length; i+=prime) arr[i]=true;
    }

    public static boolean[] getPrimeNum(int N) {
        boolean[] PrimeNumber = new boolean[N+1];
        PrimeNumber[0]=true;
        PrimeNumber[1]=true;
        int sqrtNum = (int) Math.floor(Math.sqrt(N));
        for (int i=2;i<=sqrtNum;i++) {
            if (!PrimeNumber[i]) removeMultiple(PrimeNumber, i);
        }
        return PrimeNumber;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        StringTokenizer st = new StringTokenizer(S);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] PrimeNumber = getPrimeNum(N);
        for (int i=M; i<PrimeNumber.length;i++) {
            if (!PrimeNumber[i]) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}




