// 2108번 통계학

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=10,000,000, 주어지는 수는 10000보다 작거나 같은 자연수

<프로그램 진행>
 1. Counting Sort

<필요 함수>
 1. 주어진 배열내에서 최댓값을 찾는 함수
 2. Counting Sort

 */

import java.io.*;

public class Q2108 {
    public static int findMaxValue (int[] arr) {
        int max=arr[0];
        for (int i=0;i<arr.length;i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }
        return max;
    }

    public static int[] CountingSort (int[] arr) {
        int size = arr.length;
        int max = findMaxValue(arr);
        //System.out.printf("max : %d\n",max);
        int[] cnt = new int[max+1]; //누적합
        int[] sorted_arr = new int[size];

        for (int num : arr) cnt[num]++;
        for (int i=1;i<cnt.length;i++) cnt[i]+=cnt[i-1];
        //System.out.println(Arrays.toString(cnt));

        for (int i=size-1;i>=0;i--) {
            sorted_arr[cnt[arr[i]]-1] = arr[i];
            cnt[arr[i]]--;
        }
        return sorted_arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        int[] sorted_arr = CountingSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : sorted_arr) sb.append(num).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}