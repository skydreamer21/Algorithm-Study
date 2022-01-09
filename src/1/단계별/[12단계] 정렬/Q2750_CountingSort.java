// 2750번 수 정렬하기 - Counting Sort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. Counting Sort

<필요 함수>
 1. Counting Sort
 2. 주어진 배열에서 최댓값 찾는 함수

 */

import java.io.*;
import java.util.Arrays;

public class Q2750_CountingSort {
    public static int findMax (int[] arr) {
        int max = arr[0];
        for(int num : arr) {
            if(num>max) max = num;
        }
        return max;
    }
    public static int[] CountingSort (int[] arr) {
        int size = arr.length;
        int max = findMax(arr);
        int[] cnt = new int[max+1]; //int배열 기본값 0
        int[] sorted_arr = new int[size];

        //arr에 들어있는 숫자 count
        for(int num : arr) cnt[num]++;
        System.out.println(Arrays.toString(cnt));

        //누적합만들기
        for(int i=1;i<cnt.length;i++) cnt[i]+=cnt[i-1];
        System.out.println(Arrays.toString(cnt));

        //배열하기
        for(int i=size-1;i>=0;i--) {
            sorted_arr[cnt[arr[i]]-1]=arr[i];
            cnt[arr[i]]--;
        }

        return sorted_arr;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        int[] sorted_arr = CountingSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : sorted_arr) {
            sb.append(num).append("\n");
        }
        bw.write(sb.toString());
        //for (int num : arr) bw.write(num+"\n");
        bw.flush();
        bw.close();
    }
}