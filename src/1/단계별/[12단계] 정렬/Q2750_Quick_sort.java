// 2750번 수 정렬하기 - Quick Sort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. Quick Sort - pivot은 배열의 가장 왼쪽

<필요 함수>
 1. partition 함수
 2. swap 함수
 3. QuickSort
 4. QuickSort_recursive

 */

import java.io.*;

public class Q2750_Quick_sort {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right; // hi와 lo는 앞으로 변경될 값
        int pivot = arr[left];

        while(hi>lo) {
            //hi에서 값을 1씩 내리면서 arr[hi]가 pivot보다 작아질 때의 index를 hi에 담아야함
            while(arr[hi]>pivot && hi>lo) hi--;

            //lo에서 값을 1씩 올리면서 arr[lo]가 pivot보다 커질 때의 index를 lo에 담아야함.
            //등호를 넣어준건 왼쪽에 pivot이 있기 때문
            while(arr[lo]<=pivot && hi>lo) lo++;

            // hi와 lo 인덱스에 해당하는 배열값을 서로 바꿈
            swap(arr, lo, hi);
        }

        // pivot을 마지막으로 자리를 바꾼 lo index에 넣어주고 원래 lo 에 있던것은 pivot쪽으로 옮김
        swap(arr,left,lo);

        // 최종적으로 바뀐 pivot의 index를 반환
        return lo;
    }

    public static void QuickSort(int[] arr) {
        QuickSort_recursive(arr,0,arr.length-1);
    }

    public static void QuickSort_recursive(int[] arr, int left, int right) {
        int pivot=0;
        if (left>=right) return;
        else {
            //Divide
            pivot = partition(arr, left, right);
            //Conquer
            //pivot-1 이나 pivot+1을 안해줄시 종료조건에 맞지 않게되어 무한루프에 빠짐
            QuickSort_recursive(arr,left,pivot-1);
            QuickSort_recursive(arr,pivot+1,right);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        QuickSort(arr);
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