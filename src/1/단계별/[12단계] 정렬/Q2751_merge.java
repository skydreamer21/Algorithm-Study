// 2751번 수 정렬하기2 - merge sort

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

public class Q2751_merge {
    static int[] arr;
    static int[] sorted_arr;
    static int cnt=0;

    public static void merge(int start, int mid, int end) {
        int n1 = mid-start+1;
        int n2 = end-mid;
        int a=0;
        int b=0;
        while (a<n1 || b<n2) {
            if((b<n2 && arr[start+a]>=arr[mid+b+1]) || a>=n1) {
                sorted_arr[start+a+b]=arr[mid+b+1];
                b++;
            }
            else {
                sorted_arr[start+a+b]=arr[start+a];
                a++;
            }
        }
        for (int i=start;i<=end;i++) arr[i]=sorted_arr[i];
    }

    public static void mergeSort (int start, int end) {
        if(end>start) {
            int mid = (start+end)/2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
            printArr(sorted_arr,cnt++);
        }
    }

    public static void printArr (int[] arr, int count) {
        System.out.printf("%d번째 : ",count+1);
        for (int i=0; i<arr.length;i++) {
            if(i!=arr.length-1) System.out.printf("%d, ",arr[i]);
            else System.out.printf("%d\n",arr[i]);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        sorted_arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        mergeSort(0,N-1);
        for (int num : arr) sb.append(num).append("\n");
        //for (int num : sorted_arr) sb.append(num).append("\n");
        //merge함수가 한번이라도 돌아가면 무조건 맞지만, 한번도 안돌아갈경우, 즉 N=1 일때 성립이 안됨.
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}