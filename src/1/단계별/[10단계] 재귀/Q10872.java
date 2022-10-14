// 10872번 팩토리얼

/*
<문제 정보>
 1. N 팩토리얼을 출력하는 프로그램 작성

<프로그램 진행>
 1. 재귀함수
 2. 0!=1

<필요 함수>
 1.

 */

import java.io.*;

public class Q10872 {
    public static int getN_factorial (int N) {
        if (N==0 || N==1) return 1;
        else {
            return N * getN_factorial(N-1);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getN_factorial(N)));
        bw.flush();
        bw.close();
    }
}