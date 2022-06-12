// 17425번 약수의 합 (G4)
/*
<문제 정보>
 1. f(x) : x의 약수의 합
 2. g(x) : f(1) + f(2) + ... + f(x)
 3. g(N)을 구하자.

<변수 범위>
 1. 1초 / 512MB
 2. 테스트케이스 1<=T<=100,000
 3. 자연수 N 1<=N<=1,000,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 실패 - 시간초과

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Q17425 {
    static boolean[] numbers = new boolean[1_000_001];
    static ArrayList<Integer> primeNumList = new ArrayList<>();
    static HashSet<Integer> primeNum = new HashSet<>();
    static int[][] expSum;
    static int[] g;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        getPrimeNum();
        for(int n : primeNumList) System.out.printf("%d ",n);
        System.out.println();
        System.out.println(primeNumList.size());
        expSum = new int[primeNumList.size()][30];

        int value, mul;
        for (int i=0;i<primeNumList.size();i++) {
            expSum[i][0]=1;
            value = 1;
            mul = primeNumList.get(i);
            for (int j=1;j<30;j++) {
                value *= mul;
                expSum[i][j] = expSum[i][j-1] + value;
                if(expSum[i][j] > 1_000_000) break;
            }
        }

        /*for (int i=0;i<168;i++) {
            for (int j=0;j<30;j++) System.out.printf("%d ",expSum[i][j]);
            System.out.println();
        }*/

        /*while(T-- >0) {

        }*/


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPrimeNum() {
        numbers[0] = true; // 0은 합성수임
        numbers[1] = true;
        for (int i=2;i<1000;i++) {
            if(numbers[i]) continue;
            primeNumList.add(i);
            for (int j=i*i;j<1_000_000;j+=i) numbers[j] = true;
        }
    }

    public static boolean isPrime(int n) {
        return !numbers[n];
    }
}
