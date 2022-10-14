// 2750번 수 정렬하기 - Selection Sort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. Selection Sort

<필요 함수>
 1. Swap
 2. 배열과 시작,끝 인덱스가 주어지면 그 안의 최솟값찾는 함수
 3. Selection Sort

 */

import java.io.*;

public class Q2750_Selection_Sort {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }

    public static int findMin(int[] arr, int start, int end) {
        int min = arr[start];
        int minIndex=start;
        for(int i=start;i<=end;i++) {
            if(arr[i]<min) {
                min = arr[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public static void SelectionSort (int[] arr) {
        int min;
        int size=arr.length;
        for (int i=0;i<size;i++) {
            min = findMin(arr,i,size-1);
            // arr[i]!=min 해줘도 똑같은 것은 그다음 루프에서 처리가 됨
            if (arr[i]!=min) swap(arr,i,min);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        SelectionSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        //for (int num : arr) bw.write(num+"\n");
        bw.flush();
        bw.close();
    }
}