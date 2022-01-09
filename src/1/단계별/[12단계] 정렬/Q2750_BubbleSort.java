// 2750번 수 정렬하기 - Bubble Sort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. Bubble Sort

<필요 함수>
 1. Bubble Sort
 2. swap
 3. Bubble 1회전 함수

 */

import java.io.*;
import java.util.Arrays;

public class Q2750_BubbleSort {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }

    public static void BubbleSort_recursive (int[] arr,int end) {
        for(int i=1;i<=end;i++) {
            if(arr[i-1]>arr[i]) swap(arr,i-1,i);
        }
        end--;
        //System.out.println(Arrays.toString(arr));
        if(end>=1) BubbleSort_recursive(arr,end);
    }

    public static void BubbleSort (int[] arr) {
        BubbleSort_recursive(arr,arr.length-1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        BubbleSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append("\n");
        }
        bw.write(sb.toString());
        //for (int num : arr) bw.write(num+"\n");
        bw.flush();
        bw.close();
    }
}