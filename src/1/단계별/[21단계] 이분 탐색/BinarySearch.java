// Binary_Search
/*

Goal : UpperBound, LowerBound 구현
 - Lower Bound (하한) : 찾고자 하는 값(key) 이상의 값이 처음으로 나타나는 위치
 - Upper Bound (상한) : 찾고자 하는 값(key)을 초과한 값을 처음 만나는 위치

 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        while (true) {
            int K = Integer.parseInt(br.readLine());
            if (K==-1) break;
            System.out.printf("Lower Bound of %d : %d\n",K,BS_LowerBound(arr,K));
            System.out.printf("Upper Bound of %d : %d\n",K,BS_UpperBound(arr,K));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BS_LowerBound (int[] arr, int key) {
        int lo=0;
        int hi=arr.length;
        int mid;
        while(lo<hi) {
            mid = (lo+hi)/2;
            if (arr[mid]>=key)  hi=mid;
            else lo=mid+1;
        }
        return lo;
    }

    public static int BS_UpperBound (int[] arr, int key) {
        int lo=0;
        int hi=arr.length;
        int mid;
        while(lo<hi) {
            mid = (lo+hi)/2;
            if(arr[mid]<=key) lo=mid+1;
            else hi = mid;
        }
        return lo;
    }
}