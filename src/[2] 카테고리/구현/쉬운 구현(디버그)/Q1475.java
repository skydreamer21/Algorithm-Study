// 1475번 방번호 (S5)
/*
<문제 정보>
 1. 0~9 세트 필요한 개수4

<변수 범위>
 1. 2초 / 128MB
 2. 방번호 1,000,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
public class Q1475 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int[] num = new int[10];
        for (char c : S.toCharArray()) num[c-'0']++;
        int max=-1;
        for (int i=0;i<10;i++) {
            if(i!=6 && i!=9) max = Math.max(max,num[i]);
        }
//        int except = (num[6]+num[9])%2==1 ? (num[6]+num[9])/2+1 : (num[6]+num[9])/2;
        int except = (num[6]+num[9])/2 + (num[6]+num[9])%2;
        int ans = Math.max(max,except);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
