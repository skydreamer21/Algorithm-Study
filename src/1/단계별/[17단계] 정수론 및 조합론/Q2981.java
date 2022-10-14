// 2981번 검문

/*
<문제 정보>
 1. N개의 숫자를 M으로 나누었을 때 나머지가 같게 되는 M을 모두 출력 (오름차순)
 (입력은 무조건 M이 존재)
 2. 2<=N<=100 / N개의 숫자는 1이상 1,000,000,000 이하 / M은 1보다 큼

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 마지막 최대공약수값이 큰 값이라면 출력성능 또한 전체 프로그램 성능에 영항을 미침

/*
<사용 개념>
- 유클리드 호제법 (최대공약수 구하기)
- 특정 수의 약수들을 모두 구하기 (제곱근까지 탐색)
 */

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Q2981 {
    static int[] arr;
    static int[] diff;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        diff = new int[N-1];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        for (int i=0;i<N-1;i++) diff[i]  = Math.abs(arr[i+1]-arr[i]);
        Arrays.sort(diff);
        //System.out.println(Arrays.toString(diff));
        int gcd = diff[0];
        for (int i=1;i<N-1;i++) gcd = GCD(diff[i],gcd);
        //System.out.println(gcd);
        ArrayList<Integer> factor = new ArrayList<>();
        // 제곱근 값 까지 하는 것과 절반까지 하는 것과 성능차이가 꽤 큼
        for (int i=2;i<=Math.sqrt(gcd);i++) {
            if (i*i==gcd) factor.add(i);
            else if (gcd%i==0) {
                factor.add(i);
                factor.add(gcd/i);
            }
        }
        factor.add(gcd);
        Collections.sort(factor);
        for (int num : factor) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int GCD (int A, int B) {
        if (B==0) return A;
        else return GCD(B,A%B);
    }
}