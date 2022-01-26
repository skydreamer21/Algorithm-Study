// 1912번 연속 합

/*
<문제 정보>
 1. N개의 수로 이루어진 수열에서 연속된 몇개의 수의 합이 최대가 될 때 최대값을 출력
 2. 1<=N<=100,000   각 수는 절댓값이 1000이하인 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1912 {
    static int[] arr;
    static int[] summary;
    static Integer[] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        summary = new int[N+1];
        memo = new Integer[N+1];
        memo[0]=0;
        for (int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        makeSummary();
        bw.write(Arrays.toString(summary));
        bw.newLine();
        bw.write(String.valueOf(find_maxIdx()));


        bw.flush();
        bw.close();
        br.close();
    }

    public static int find (int n) {
        if (memo[n]==null) {
            if(arr[n]>=0) memo[n]=find(n-1)+arr[n];
            else memo[n]=0;
        }
        return memo[n];
    }

    public static void makeSummary () {
        boolean sign = (arr[1]>=0) ? true : false;
        int temp=arr[1];
        int idx=0;
        for (int i=2;i<=arr.length-1;i++) {
            if (arr[i-1]*arr[i]>=0) temp+=arr[i];
            else {
                summary[idx]=temp;
                temp=arr[i];
                idx++;
            }
        }
    }

    public static int find_maxIdx () {
        for (int i=arr.length-1;;i--) {
            if (summary[i]!=0) return i;
        }
    }

}