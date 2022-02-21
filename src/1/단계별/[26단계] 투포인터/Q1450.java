// 1450번 냅색문제
/*
<문제 정보>
 1. N개의 물건, C만큼 넣을 수 있는 가방
 2. N개의 물건을 가방에 넣는 방법의 수

<변수 범위>
 1. 1초 / 128MB
 2. N : 30 이하 자연수
 3. C : 1,000,000,000이하의 음아닌 정수
 4. 물건의 무게 범위 C와 같음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Q1450 {
    static int[] left;
    static int[] right;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int middle = N/2;
        left = new int[middle];
        right = new int[N-middle];
        System.arraycopy(arr,0,left,0,middle);
        System.arraycopy(arr,middle,right,0,N-middle);


        ArrayList<Long> leftSum = new ArrayList<>();
        ArrayList<Long> rightSum = new ArrayList<>();
        partialSum(left,leftSum,0,0);
        partialSum(right,rightSum,0,0);

        Collections.sort(rightSum);
/*
        for(long num : leftSum) System.out.printf("%d ",num);
        System.out.println();
        for(long num : rightSum) System.out.printf("%d ",num);
        System.out.println();

 */


        //System.out.println(C-leftSum.get(2));
        //System.out.println(upperBound(rightSum,C-leftSum.get(2)));

        int cnt=0;
        for (long num : leftSum) {
            if(num<=C) cnt+=upperBound(rightSum,(int)(C-num));
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void partialSum (int[] numbers, ArrayList<Long> sums, long sum, int idx) {
        if (idx==numbers.length) {
            sums.add(sum);
            return;
        }
        partialSum(numbers,sums,sum,idx+1);
        partialSum(numbers,sums,sum+numbers[idx],idx+1);
    }

    public static int upperBound(ArrayList<Long> sums, int key) {
        int lo=0;
        int hi=sums.size();
        int mid;
        while(lo<hi) {
            mid = (lo+hi)/2;
            if (sums.get(mid)<=key) lo = mid+1;
            else hi=mid;
        }
        return lo;
    }
}
