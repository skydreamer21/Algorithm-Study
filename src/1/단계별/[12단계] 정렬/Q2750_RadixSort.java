// 2750번 수 정렬하기 - Radix Sort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. Radix Sort

<필요 함수>
 1. 배열의 최댓값 찾는 함수
 2. 자릿수와 배열이 주어질때 해당 자릿수에서의 Counting Sort
 3. Radix Sort

 */

import java.io.*;
import java.util.Arrays;

public class Q2750_RadixSort {
    static int count=0;
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) max = Math.max(num,max);
        return max;
    }

    public static void CountingSort(int[] arr, int exp) {
        count++;
        int size = arr.length;
        int[] buffer = new int[size]; // Counting 한번할때마다 초기화
        int[] cnt = new int[10]; // buffer와 마찬가지로 초기화
        System.out.printf("<%d try> cnt(init) : ",count);
        System.out.println(Arrays.toString(cnt));
        int idx;

        for(int num : arr) cnt[(num/exp)%10]++;
        for(int i=1;i<cnt.length;i++) cnt[i]+=cnt[i-1]; //cnt에는 index에 관한 정보가 담김
        System.out.printf("<%d try> cnt : ",count);
        System.out.println(Arrays.toString(cnt));

        for(int i=size-1;i>=0;i--) {
            idx = cnt[(arr[i]/exp)%10]-1;
            buffer[idx] = arr[i];
            cnt[(arr[i]/exp)%10]--;
        }
        for (int i=0;i<size;i++) arr[i]=buffer[i];
        System.out.printf("<%d try> arr : ",count);
        System.out.println(Arrays.toString(arr));
    }

    public static void RadixSort(int[] arr) {
        int max = findMax(arr);
        for (int exp=1;max/exp>0;exp*=10) CountingSort(arr,exp);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        RadixSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}