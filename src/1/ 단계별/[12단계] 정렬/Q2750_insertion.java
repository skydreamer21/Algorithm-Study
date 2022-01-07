// 2750번 수 정렬하기 - Insertrion sort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. Insertion sort

<필요 함수>
 1. Insertion sort 함수

 */

import java.io.*;

public class Q2750_insertion {
    public static void InsertionSort (int[] arr) {
        int key;
        int i;
        for (int j=1; j<arr.length;j++) {
            key=arr[j];
            i=j-1;
            while(i>=0 && arr[i]>key) {
                arr[i+1]=arr[i];
                i-=1;
            }
            arr[i+1]=key;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        InsertionSort(arr);
        for (int num : arr) bw.write(num+"\n");
        bw.flush();
        bw.close();
    }
}