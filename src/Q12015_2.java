// 12015번 가장 긴 증가하는 부분 수열2 (G3) [이분탐색]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q12015_2 {
    static int N;
    static int maxLength=1;
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int key;
        int index;
        for (int i=2;i<=N;i++) {
            key = Integer.parseInt(st.nextToken());
            index = FindUpperBound(key);
            if (index == maxLength) maxLength++;
            arr[index] = key;
            /*for (int j=0;j<maxLength;j++) System.out.printf("%d ",arr[j]);
            System.out.println();*/
        }
        sb.append(maxLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int FindUpperBound(int key) {
        int lo = 0;
        int hi = maxLength;
        int mid;

        while(lo<hi) {
            mid = (lo+hi)/2;
            if (arr[mid]==key) return mid;
            if (arr[mid]<key) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}
