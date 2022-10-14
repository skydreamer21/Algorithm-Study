// 1300번 K번째 수
/*
<문제 정보>
 1. N x N 인 배열 A  A[i][j] = i*j 이 수를 일차원 배열 B에 넣으면 B의 크기는 NxN 이 된다.
 2. B를 오름차순 정렬했을 때 B[k]를 출력
 3. A, B의 인덱스는 1부터 시작

<변수 범위>
 1. N은 10^5(100,000) 이하의 자연수
 2. k는 min(10^9, N^2) 이하의 자연수

<프로그램 진행>
 1. 변수 : 주어진 NxN table안의 어떤 수
 2. key : k
 3. 정렬 필요 : f(N)은 함수 자체가 증가함수기 때문에 정렬 필요 X

<필요 함수>
 1. table안에 N까지의 수들의 개수 f(N)
 2. BS_LowerBound

 */

import java.io.*;

public class Q1300 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(BS_LowerBound(N,k)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long BS_LowerBound (int N, int key) {
        long min = 1;
        long max = (long)N*N;
        long mid;
        while (min<max) {
            mid = (min+max)/2;
            if (f(N,mid)>=key) max=mid;
            else min = mid+1;
        }
        return min;
    }

    //sum에 정답만 들어가는 게 아니라서 정답보다 클 경우 충분히 int범위를 벗어날 수 있음.
    public static long f(int N, long k) {
        long sum=0;
        // N줄에 걸쳐서 찾음
        for (int i=1;i<=N;i++) {
            if (k/i>N) sum+=N;
            else sum+=k/i;
            // 위의 두줄을 sum+=Math.min(k/i,N) 으로 바꿀 수 있음.
        }
        return sum;
    }
/*
    // 아래 메소드는 LowerBound를 구하는 메소드, 그런데 BS에서 적용시키면 됨.
    public static int check (int N, int value) {
        if (value<=N) return value;

        boolean ok = false;
        int start = (int)Math.round(Math.sqrt(value));
        while (!ok) {
            for (int i=start;i<=N;i++) {
                if (value%i==0) {
                    ok = true;
                    break;
                }
            }
            if(!ok) value--;
        }
        return value;
    }
 */
}