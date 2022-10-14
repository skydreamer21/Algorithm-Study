// 11650번 좌표 정렬하기

/*
<문제 정보>
 1. 2차원 평면 점 N개가 있을 때, x좌표가 증가하는 순으로 나열.
 2. 만약 x좌표가 같다면 y좌표가 증가하는 순서로 정렬
 3. 1<=N<=100,000 / x, y좌표는 절댓값이 100,000을 넘지않는 정수

<프로그램 진행>
 1. Quick Sort

<필요 함수>
 1. QuickSort
 2. QuickSort_x
 3. QuickSort_y
 4. QuickSort_recursive
 5. partition
 6. swap

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q11650 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] coor = new int [N][2];
        String input;
        StringTokenizer st;
        for (int i=0;i<N;i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            coor[i][0] = Integer.parseInt(st.nextToken());
            coor[i][1] = Integer.parseInt(st.nextToken());
        }
        QuickSort_x(coor);
        //printCoor(coor);
        QuickSort_y(coor);

        //printCoor(coor);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<N;i++) sb.append(coor[i][0]).append(" ").append(coor[i][1]).append("\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    // coor : x좌표(0), y좌표(1)
    public static void QuickSort (int[][] arr, int coor) {
        QuickSort_recursive(arr, coor,0,arr.length-1);
    }

    public static void QuickSort_x(int[][] arr) {
        QuickSort(arr, 0);
    }

    public static void QuickSort_y (int[][] coor) {
        int cnt=0;
        int left=0;
        int right=0;
        for (int i=0;i<coor.length-1;i++) {
            if (coor[i][0]==coor[i+1][0]) {
                if(cnt==0) left = i;
                if (i==coor.length-2) {
                    right = i+1;
                    QuickSort_recursive(coor,1,left,right);
                }
                cnt++;
            }
            else if (cnt!=0) {
                right=i;
                QuickSort_recursive(coor,1,left,right);
                cnt=0;
            }
        }
    }

    public static void QuickSort_recursive (int[][] arr,int coor, int left, int right) {
        int pivot=0;
        if (left>=right) return;

        pivot = partition(arr,coor,left,right);
        QuickSort_recursive(arr,coor,left,pivot-1);
        QuickSort_recursive(arr,coor,pivot+1,right);
    }

    public static void swap (int[][] arr, int a, int b) {
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition (int[][] arr, int coor, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = left;

        while (hi>lo) {
            while (arr[hi][coor]>arr[pivot][coor] && hi>lo) hi--;
            while (arr[lo][coor]<=arr[pivot][coor] && hi>lo) lo++;
            swap(arr,lo,hi);
        }
        swap(arr,pivot,lo);
        return lo; // lo 자리에 pivot이 들어갔으므로
    }
    /*
    public static void printCoor (int[][] arr) {
        for (int i=0;i<arr.length;i++) System.out.println(Arrays.toString(arr[i]));
    }
     */

}

