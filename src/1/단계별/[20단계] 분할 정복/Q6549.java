// 6549번 히스토그램에서 가장 큰 직사각형
/*
<문제 정보>
 1. 히스토그램이 주어질때 가장 넓이가 큰 직사각형의 넓이 출력
 2. 직사각형의 개수 n은 100,000 이하의 자연수,  높이는 1,000,000,000이하 정수
 3. 마지막 입력은 0 하나

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 스택 풀이도 있음
// 반드시 해볼것

import java.io.*;
import java.util.StringTokenizer;

public class Q6549 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N==0) break;
            arr = new int[N];
            for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            long ans = getMaxSquare(0,N-1);
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long getMaxSquare(int start, int end) {
        if (start==end) return arr[start];
        int mid = (start+end)/2;
        return Math.max(Math.max(getMaxSquare(start,mid),getMaxSquare(mid+1,end)),
                BoundarySquare(start,mid,end));
    }

    public static long BoundarySquare (int start, int mid, int end) {
        int boundary = Math.min(arr[mid],arr[mid+1]);
        long max;
        int cnt1=0; int cnt2=0;
        while(mid-cnt1>=start && arr[mid-cnt1]>=boundary) cnt1++;
        while(mid+1+cnt2<=end && arr[mid+1+cnt2]>=boundary) cnt2++;
        max = (long)boundary*(cnt1+cnt2);
        int temp1 = cnt1;  int temp2 = cnt2;
        // 오른쪽 파트 cnt2
        while (mid+1+temp2<=end) {
            boundary = arr[mid+1+temp2];
            while(mid-temp1>=start && arr[mid-temp1]>=boundary) temp1++;
            while(mid+1+temp2<=end && arr[mid+1+temp2]>=boundary) temp2++;
            max = Math.max(max,(long)boundary*(temp1+temp2));
        }
        // 왼쪽 파트 cnt1
        temp1 = cnt1; temp2 = cnt2;
        while (mid-temp1>=start) {
            boundary = arr[mid-temp1];
            while(mid-temp1>=start && arr[mid-temp1]>=boundary) temp1++;
            while(mid+1+temp2<=end && arr[mid+1+temp2]>=boundary) temp2++;
            max = Math.max(max,(long)boundary*(temp1+temp2));
        }

        return max;
    }

/*
    public static long BoundarySquare_2 () {
        long max=0;
        int cnt1; int cnt2;
        for (int i=0;i<arr.length;i++) {
            cnt1=0; cnt2=0;
            if (i==0) while(i+cnt1<=arr.length-1 && arr[i+cnt1]>=arr[i]) cnt1++;
            else if (i==arr.length-1) while(i-cnt2>=0 && arr[i-cnt2]>=arr[i]) cnt2++;
            else {
                while(i+1+cnt1<=arr.length-1 && arr[i+1+cnt1]>=arr[i]) cnt1++;
                while(i-cnt2>=0 && arr[i-cnt2]>=arr[i]) cnt2++;
            }
            max = Math.max(max,(long)arr[i]*(cnt1+cnt2));
        }
        return max;
    }
 */
}