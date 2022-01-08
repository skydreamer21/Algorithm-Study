// 4153번 직각삼각형

/*
<문제 정보>
 1. 세 변의 길이가 주어질 때, 이게 직각삼각형이 맞는지
 right or wrong 출력

<프로그램 진행>
 1. 주어진 세변중 큰 길이를 알아내야함

<필요 함수>
 1. 세 변의 길이 배열 넣고 최댓값의 index return
 2. 세 변의 길이 배열 넣고 직각삼각형인지 boolean return

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q4153 {
    public static int getMaxIndex(int[] arr) {
        int max=0;
        int index=-1;
        for (int i=0; i<arr.length;i++) {
            if(arr[i]>max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static boolean IsThisRightTriangle(int[] arr) {
        int sum=0;
        int maxIndex = getMaxIndex(arr);
        for (int i=0; i<3; i++) {
            if (i==maxIndex) sum+=arr[i]*arr[i];
            else sum-=arr[i]*arr[i];
        }
        if (sum==0) return true;
        else return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String S;
        int[] arr = new int[3];
        while(true) {
            S = br.readLine();
            st = new StringTokenizer(S);
            for (int i=0; i<3; i++) arr[i] = Integer.parseInt(st.nextToken());
            if (arr[0]==0) break;
            else if (IsThisRightTriangle(arr)) bw.write("right\n");
            else bw.write("wrong\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}