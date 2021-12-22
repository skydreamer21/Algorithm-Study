// 1085번 직사각형에서 탈출

/*
<문제 정보>
 1. 왼쪽아래(0,0), 오른쪽 위 (w,h) 의 어딘가에서 직사각형의 변까지 가는
 거리의 최솟값

<프로그램 진행>
 1. 4개중에 하나 오른,왼,위,아래 경계 중 하나

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1085 {

    public static int getMin(int[] arr) {
        int val=arr[0];
        for (int i=1; i<4;i++) {
            if(arr[i]<val) val = arr[i];
        }
        return val;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        StringTokenizer st = new StringTokenizer(S);
        int min;
        int[] arr = new int[4];
        for (int i=0;i<4;i++) arr[i]=Integer.parseInt(st.nextToken());
        arr[2]-=arr[0];
        arr[3]-=arr[1];
        min = getMin(arr);
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}