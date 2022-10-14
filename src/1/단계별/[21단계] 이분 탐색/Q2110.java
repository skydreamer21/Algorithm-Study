// 2110번 공유기 설치
/*
<문제 정보>
 1. 집 N개가 수직선 위에 있다. 각각의 좌표가 주어지고 같은 좌표를 가지는 집 없음
 2. 집 어디서나 와이파이가 되기 위해 공유기 C개를 설치
 3. 한 집에는 공유기 하나만 설치 가능 / 인접한 두 공유기 사이의 거리를 가능한 크게 설치
 4. C개의 공유기를 N개의 집에 적당히 설치했을 때 가장 인접한 두 공유기 사이의 최대 거리

<변수 범위>
1. 2<=N<=200,000 / 2<=C<=N
2. 집의 좌표는 1,000,000,000 이하의 양의 정수

<프로그램 진행>
 1. Binary Search UpperBound
 2. 변수 : 공유기 사이 최소 거리
 3. key : 설치할 수 있는 최대 공유기 개수
 4. 정렬 필요성 O

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2110 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        bw.write(String.valueOf(BS_UpperBound(C)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BS_UpperBound (int key) {
        int min = 0;
        int max = arr[arr.length-1]-arr[0]+1;
        int mid;
        while (min<max) {
            mid = (min+max)/2;  // 주어진 최대 좌표를 2배해도 int범위를 넘지않아서 괜찮지만 넘는지 안넘는지는 꼭 체크!
            if (router(mid)>=key) min = mid+1;
            else max=mid;
        }
        return max-1;
    }

    public static int router (int distance) {
        int cnt=1;
        int location=arr[0];
        for (int i=1;i<arr.length;i++) {
            if(arr[i]-location>=distance) {
                cnt++;
                location = arr[i];
            }
        }
        return cnt;
    }
}