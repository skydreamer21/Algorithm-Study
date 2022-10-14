// 1016번 제곱 ㄴㄴ수 (G1) [수학 - 에라토스테네스 체]
/*
<문제 정보>
 1. 제곱 ㄴㄴ수 : 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때,
 2. min, max 사이에 제곱 ㄴㄴ수가 몇개 있는지 출력

<변수 범위>
 1. 2초 / 512MB
 2. 1 <= min <= 1,000,000,000,000
 3. min <= max <= min + 1,000,000

<프로그램 진행>
 1.

<필요 함수>
 1. max 루트값 보다 작거나 같은 모든 소수들 구하기
 2. min ~ max 개수에 해당하는 boolean 배열을 만들고 에라토스테네스의 체 풀이 적용
 3. NlogN 풀이

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Q1016 {
    static long min, max;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        int[] primeList = getPrimeNum(max);
//        for (int prime : primeList) {
//            System.out.printf("%d ",prime);
//        }
//        System.out.println();


        // ******************** 메인 로직 ********************
        int range = (int) (max - min + 1);
        // 숫자에 min을 빼면 index 접근
        boolean[] isThatNum = new boolean[range];
        Arrays.fill(isThatNum, true);

        long startNum;
        for (int prime : primeList) {
            // min보다 큰 prime*prime의 배수 찾기 중 최솟값
            startNum = getStartNum(min, prime);
//            System.out.printf("prime : %d, startNum : %d\n",prime, startNum);
            for (long i=startNum; i<=max; i+= (long) prime*prime) {
                isThatNum[(int)(i-min)] = false;
//                System.out.printf("%d 삭제\n",i);
            }
        }

        int count = 0;
        for (int i=0;i<range;i++) {
            if (isThatNum[i]) count++;
        }

        // ******************** 정답 출력 ********************
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // n보다 큰 prime*prime 배수의 최솟값
    public static long getStartNum(long n, int prime) {
        long primeSquare = (long) prime *prime;
        if (n % primeSquare != 0) {
            long div = n / primeSquare;
            return primeSquare * (div + 1);
        }
        else return n;
    }

    // n max
    public static int[] getPrimeNum(long n) {
        int sqrtNum = (int) Math.floor(Math.sqrt(n));
//        System.out.printf("sq : %d\n",sqrtNum);
        boolean[] isPrime = new boolean[sqrtNum+1];
        Arrays.fill(isPrime, true);
        ArrayList<Integer> primes = new ArrayList<>();
        isPrime[0] = isPrime[1] = false;

        for (int i=2;i<=Math.sqrt(sqrtNum);i++) {
            if (!isPrime[i]) continue;
//            System.out.printf("i : %d\n",i);
            for (int j=i*i; j<=sqrtNum; j+=i) {
                isPrime[j] = false;
            }
        }

        for (int i=2; i<=sqrtNum; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int[] primeList = new int[primes.size()];
        int idx=0;
        for (int prime : primes) primeList[idx++] = prime;
        return primeList;
    }
}
