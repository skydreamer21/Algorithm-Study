// 2981번 검문

/*
<문제 정보>
 1. N개의 숫자를 M으로 나누었을 때 나머지가 같게 되는 M을 모두 출력 (오름차순)
 (입력은 무조건 M이 존재)
 2. 2<=N<=100 / N개의 숫자는 1이상 1,000,000,000 이하 / M은 1보다 큼

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Arrays;

public class Q2981_2 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int res;
        boolean same=true;
        for (int i=2;i<arr[1];i++) {
            res = arr[0]%i;
            for (int num : arr) {
                if (num%i!=res) {
                    same = false;
                    break;
                }
            }
            if(same) sb.append(i).append(" ");
            else same = true;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}