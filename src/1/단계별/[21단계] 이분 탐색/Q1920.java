// 1920번 수 찾기
/*
<문제 정보>
 1. N 개의 정수가 있을 때 이 안에 X가 있으면 1, 없으면 0 출력
 2. 1<=N<=100,000 주어지는 각각의 수는 int범위
 3. 그다음 M개의 수들이 주어 질 때 그 M이 앞서 주어진 수열 안에 존재하는지 알아내면 됨.

<프로그램 진행>
 1. 한번만 찾을것같으면 그냥 linear search가 빠른데 찾는 횟수가 크다면 이진탐색이 효율적

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1920 {
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        int num;
        st = new StringTokenizer(br.readLine());
        while (M-- >0) {
            num = Integer.parseInt(st.nextToken());
            sb.append(Binary_Search(num)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int Binary_Search (int n) {
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (left<=right) {
            mid = (left+right)/2;
            if(arr[mid]==n) return 1;
            else if (arr[mid]>n) right = mid-1;
            else left = mid+1;
        }
        return 0;
    }
}