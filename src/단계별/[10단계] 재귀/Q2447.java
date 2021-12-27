// 2447번 별찍기 - 10

/*
<문제 정보>
 1. N은 3의 거듭제곱
 2. 크기 N의 패턴은 N x N 정사각형
 3. 크기 3의 패턴은 가운데 공백

<프로그램 진행>
 1. 재귀함수
 2. 크기 3의 패턴이 재귀함수 탈출
 3. print로 재귀는 못함. 배열 값으로 넘겨줘서 마지막에 프린트해야함

<필요 함수>
 1.

 */

import java.io.*;

public class Q2447 {
    public static double getLogBase3 (int N) {
        double num = Math.round(Math.log(N)/Math.log(3));
        return num;
    }
    public static boolean[][] getN_Pattern (boolean[][] arr, int N) {
        int powerNum = (int) Math.pow(3, N);
        int powerNum_1 = (int) Math.pow(3, N - 1);
        boolean[][] prev_arr;
        if (N == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1) arr[i][j] = true;
                    else {
                        if (j != 1) arr[i][j] = true;
                    }
                }
            }
        } else {
            prev_arr = getN_Pattern(arr, N - 1);
            for (int i = 0; i < powerNum; i++) {
                if (i < powerNum_1) {
                    for (int j = powerNum_1; j < powerNum; j++) {
                        arr[i][j] = prev_arr[i][j % powerNum_1];
                    }
                } else if (i < 2 * powerNum_1) {
                    for (int j = 0; j < powerNum; j++) {
                        if (j / powerNum_1 != 1) {
                            arr[i][j] = prev_arr[i % powerNum_1][j % powerNum_1];
                        }
                    }
                } else {
                    for (int j = 0; j < powerNum; j++) {
                        arr[i][j] = prev_arr[i % powerNum_1][j % powerNum_1];
                    }
                }
            }
        }
        return arr;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int log3Num = (int) getLogBase3(N);
        boolean[][] arr = new boolean[N][N];
        arr = getN_Pattern(arr, log3Num);
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (arr[i][j]) bw.write("*");
                else bw.write(" ");
                if (j==N-1) bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}