// 1978번 소수 찾기
/*
<문제 정보>
 1. 주어진 N개 수 중에서 소수가 몇개인지 출력
 2. 맨 처음에 소수 개수 주어짐

<프로그램 진행>


<필요 함수>
  1. 정수N입력 받아 소수인지 아닌지 Boolean으로 return
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1978 {
    public static Boolean IsThisPrimeNumber(int N) {
        int point = (int) Math.floor(Math.sqrt(N));
        int count=0;
        Boolean PrimeNumber = true;
        if (N==1) PrimeNumber = false;
        else {
            for (int i=1;i<=point;i++) {
                if (N%i==0) count++;
                if (count>1) {
                    PrimeNumber = false;
                    break;
                }
            }
        }
        return PrimeNumber;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        StringTokenizer tk = new StringTokenizer(S);
        int count=0;
        int temp;
        while(tk.hasMoreTokens()) {
            temp = Integer.parseInt(tk.nextToken());
            if (IsThisPrimeNumber(temp)) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}




