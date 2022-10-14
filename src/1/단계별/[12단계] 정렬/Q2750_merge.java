// 2750번 수 정렬하기 - merge sort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. merge sort

<필요 함수>
 1.

 */

import java.io.*;

public class Q2750_merge {
    public static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid-start+1;
        int n2 = end-mid;
        int[] A = new int[n1+1];
        int[] B = new int[n2+1];
        for (int i=0;i<n1;i++) A[i]=arr[start+i];
        for (int i=0;i<n2;i++) B[i]=arr[mid+i+1];
        A[n1]=10000001; B[n2]=10000001;
        int a=0;
        int b=0;
        while (a+b<n1+n2) {
            if(A[a]>=B[b]) {
                arr[start+a+b]=B[b];
                b++;
            }
            else if (A[a]<B[b]) {
                arr[start+a+b]=A[a];
                a++;
            }
        }
    }

    public static void mergeSort (int[] arr, int start, int end) {
        if(end>start) {
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        mergeSort(arr,0,arr.length-1);
        for (int num : arr) sb.append(num).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}