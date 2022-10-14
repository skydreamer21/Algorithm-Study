// 10830번 행렬 제곱
/*
<문제 정보>
 1. N*N인 행렬 A가 주어질 때 A의 B제곱을 출력.
 2. 각 원소는 1000으로 나눈 나머지
 3. 2<=N<=5, 1<=B<=100,000,000,000  /  각 원소는 1000 이하의 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 나머지가 적용이 안된다면? getXY함수를 안쓴거 -> 처음부터 1제곱일때 예외 가능성 있음을 추론가능


import java.io.*;
import java.util.StringTokenizer;

public class Q10830 {
    static int N;
    final static int div = 1000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] A = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) A[i][j] = Integer.parseInt(st.nextToken())%div;
        }
        int[][] result = exp_matrix(A,B);
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) sb.append(result[i][j]).append(" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[][] exp_matrix(int[][] A, long B) {
        if (B==1) return A;
        else {
            if (B%2==1) return multiple_matrix(A, exp_matrix(square_matrix(A),(B-1)/2));
            else return exp_matrix(square_matrix(A),B/2);
        }
    }

    public static int[][] square_matrix (int[][] matrix) {
        int[][] result = new int[N][N];
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                result[i][j] = getXY(matrix, matrix, i, j);
            }
        }
        return result;
    }

    public static int[][] multiple_matrix (int[][] A, int[][] B) {
        int[][] result = new int[N][N];
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                result[i][j] = getXY(A, B, i, j);
            }
        }
        return result;
    }

    public static int getXY(int[][] A, int[][] B, int x, int y) {
        int ans=0;
        for (int i=0;i<N;i++) {
            ans+=A[x][i]*B[i][y]%div;
        }
        return ans%div;
    }
}