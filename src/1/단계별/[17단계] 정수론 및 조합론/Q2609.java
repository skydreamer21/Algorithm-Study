// 2609번 최대공약수와 최소공배수

/*
<문제 정보>
 1. 두개의 자연수를 입력받아 최대공약수와 최소공배수 출력
 2. 10,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2609 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int min = Math.min(A,B);
        for (int GCD=min;GCD>0;GCD--) {
            if(A%GCD==0 && B%GCD==0) {
                bw.write(String.valueOf(GCD));
                bw.newLine();
                bw.write(String.valueOf(A*B/GCD));
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}