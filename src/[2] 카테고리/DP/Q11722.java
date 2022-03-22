// 11722번 가장 긴 감소하는 부분 수열(S2) [dp] [Binary Search]
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 수열 크기, 각 수 1~1000 자연수

<프로그램 진행>
 1. 시간 제한상 dp[ O(N^2) ] 으로 풀어도 되나 연습상 이분탐색 O(NlogN)으로 품

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;



public class Q11722 {
    static int N;
    static int[] arr;
    static int max=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp;
        for (int i=0;i<N;i++) {
            tmp=Integer.parseInt(st.nextToken());
            arr[BS(tmp)]=tmp;
        }
        bw.write(String.valueOf(max+1));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int BS (int key) {
        int lo = 0;
        int hi = N;
        int mid;

        while(lo<hi) {
            mid = (lo+hi)/2;
            if(arr[mid]==key) {
//                System.out.printf("key : %d, mid : %d\n",key, mid);
                return mid;
            }
            else if(arr[mid]>key) lo=mid+1;
            else hi=mid;
        }
        max = Math.max(max,lo);
//        System.out.printf("key : %d, lo : %d\n",key, lo);
        return lo;
    }
}

