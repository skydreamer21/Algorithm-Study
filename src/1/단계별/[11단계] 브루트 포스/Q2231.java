// 2231번 분해합

/*
<문제 정보>
 1. 4673번 셀프넘버 문제와 같은 개념 사용
 2. 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램
 3. 생성자가 없을 경우 0을 출력

<프로그램 진행>
 1. 1부터 찾을 수도 있겠지만 어차피 자릿수에 따라 최대로 가질 수 있는 합이 정해져있어서
 거기서부터만 찾으면 시간을 최소화할 수 있음. 만약 3자리면 N-9*3 부터만 찾으면 됨.

<필요 함수>
 1. 숫자 N을 입력했을 때, N의 분해합을 출력
 2. 생성자 찾기

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2231 {
    public static int getDecomposedSum (int N) {
        int sum=N;
        while (N>0) {
            sum+=N%10;
            N/=10;
        }
        return sum;
    }

    public static int getMinNum (int N) {
        int digit = (int) Math.log10(N)+1;
        int minNum=0;
        boolean exist = false;
        if (N<10 && N%2==0) {
            minNum = N/2;
            exist = true;
        }
        else {
            for (int i=N-9*digit;i<=N;i++) {
                if (getDecomposedSum(i)==N) {
                    minNum = i;
                    exist = true;
                    break;
                }
            }
        }
        if (exist) return minNum;
        else return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int minNum = getMinNum(N);
        bw.write(String.valueOf(minNum));
        bw.flush();
        bw.close();
    }
}