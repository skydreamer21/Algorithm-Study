// 11444번 피보나치 수 6
/*
<문제 정보>
 1. 0(0번째), 1(첫번째)로 시작하는 피보나치 수열의 n번째 수를 구하는 프로그램
 2. N은 1,000,000,000,000,000,000 보다 작거나 같은 자연수
 3. 1,000,000,007 로 나눈 나머지 출력

<프로그램 진행>
 1. 행렬 거듭제곱

<필요 함수>
 1.

 */

import java.io.*;

public class Q11444 {
    static int[][] fibo = {{1,1},{1,0}};
    final static int div = 1000000007;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());

        int ans = (N==1) ? 1 : exp_matrix(fibo,N-1)[0][0];
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[][] exp_matrix (int[][] A, long B) {
        if (B==1) return A;
        else {
            if (B%2==1) return multiple(A,exp_matrix(square_matrix(A),(B-1)/2));
            else return exp_matrix(square_matrix(A),B/2);
        }
    }

    public static int[][] multiple (int[][] A, int[][] B) {
        int[][] result = new int[2][2];
        for (int i=0;i<2;i++) {
            for (int j=0;j<2;j++) result[i][j] = (int) getXY(A,B,i,j);
        }
        return result;
    }

    public static int[][] square_matrix (int[][] A) {
        int[][] result = new int[2][2];
        for (int i=0;i<2;i++) {
            for (int j=0;j<2;j++) result[i][j] = (int) getXY(A,A,i,j);
        }
        return result;
    }

    public static long getXY (int[][] A, int[][] B, int x, int y) {
        long ans=0;
        for (int i=0;i<2;i++) ans+=(long)A[x][i]*B[i][y]%div;
        return ans%div;
    }

}