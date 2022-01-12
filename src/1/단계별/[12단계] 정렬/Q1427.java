// 1427번 소트인사이드

/*
<문제 정보>
 1. 수가 주어지면 그 수의 각 자리수를 내림차순으로 정렬
 ex) 2143 -> 4321
 2. N<=1,000,000,000

<프로그램 진행>
 1. MergeSort

<필요 함수>
 1. merge 함수
 2. mergeSort 함수

 */

import java.io.*;

public class Q1427 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int[] arr = new int[S.length()];
        for (int i=0;i<S.length();i++) {
            arr[i]=S.charAt(i)-'0';
        }
        mergeSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void mergeSort (int[] arr) {
        mergeSort_recursive(arr, 0, arr.length-1);
    }

    public static void mergeSort_recursive (int[] arr, int start, int end) {
        if (start>=end) return;
        int mid = (start+end)/2;

        mergeSort_recursive(arr, start, mid);
        mergeSort_recursive(arr,mid+1, end);
        merge(arr,start,mid,end);
    }

    public static void merge (int[] arr, int start, int mid, int end) {
        //System.out.printf("start : %d, mid : %d, end : %d\n",start,mid,end);
        int left = start;
        int right = mid+1;
        int idx = 0;
        int[] sorted_arr = new int[end-start+1];

        while(left<=mid && right<=end) {
            if(arr[left]>arr[right]) {
                sorted_arr[idx] = arr[left];
                idx++;
                left++;
            }
            else {
                sorted_arr[idx] = arr[right];
                idx++;
                right++;
            }
        } // 여기까지하면 left와 right가 길이가 같았다면 완료, 다르다면 한쪽만 남은 상태
        //System.out.printf("left : %d, right : %d\n",left,right);
        //왼쪽이 다 차고, 오른쪽만 남았을 때
        if(left>mid) {
            while(right<=end) {
                sorted_arr[idx]=arr[right];
                idx++;
                right++;
            }
        }

        //오른쪽이 다 차고, 왼쪽만 남았을 때
        else {
            while (left<=mid) {
                sorted_arr[idx]=arr[left];
                idx++;
                left++;
            }
        }

        //sorted_arr 을 arr에 저장해서 다음 함수에서 배열된 함수를 씀
        for (int i=start;i<=end;i++) arr[i] = sorted_arr[i-start];
    }
}