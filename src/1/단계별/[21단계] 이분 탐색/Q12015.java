// 12015번 가장 긴 증가하는 부분 수열2
/*
<문제 정보>
 1. 수열 A가 주어질 때 LIS 구하기

<변수 범위>
 1. 수열의 크기 N은 1,000,000 이하의 자연수
 2. 수열을 이루는 수의 범위 : 1,000,000 이하의 자연수

<프로그램 진행>
 1. 원래 LIS의 시간복잡도는 O(n^2) -> 이번 문제 범위에서는 시간 초과
 2. O(n log(n)) 이 나오도록 이분탐색 활용
 3. UpperBound

<필요 함수>
 1.

 */

// LIS 배열에 들어간 수가 가장 긴 부분 수열은 아님. 하지만 길이는 맞음

import java.io.*;
import java.util.StringTokenizer;

public class Q12015 {
    static int[] LIS;
    static int len=1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        LIS = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) BS_UpperBound_insert(Integer.parseInt(st.nextToken()));
        //System.out.println(Arrays.toString(LIS));
        bw.write(String.valueOf(len-1));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void BS_UpperBound_insert (int key) {
        int lo = 0;
        int hi = len;
        int mid;
        while(lo<hi) {
            mid = (lo+hi)/2;
            if (LIS[mid]==key) return;
            if(LIS[mid]<key) lo = mid+1;
            else hi = mid;
        }
        if(hi==len) len++;
        LIS[hi]=key;
    }
}