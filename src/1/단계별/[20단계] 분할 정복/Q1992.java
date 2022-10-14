// 1992번 쿼드 트리
/*
<문제 정보>
 1. 흑백 영상 압축방법 중 하나인 쿼드 트리
 2. 사등분해서 다 같은 색이면 압축
 3. 압축한 결과를 출력
 4. 영상의 크기 N은 언제나 2의 제곱수  64이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;

public class Q1992 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String numS;
        arr = new int[N][N];
        for (int i=0;i<N;i++) {
            numS = br.readLine();
            for (int j=0;j<N;j++) arr[i][j] = numS.charAt(j)-'0';
        }
        divide(0,0,N);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void divide (int x, int y, int N) {
        if (SameColor(x,y,N)==0) sb.append(0);
        else if (SameColor(x,y,N)==1) sb.append(1);
        else {
            sb.append('(');
            for (int i=0;i<2;i++) {
                for (int j=0;j<2;j++) divide(x+N/2*i,y+N/2*j,N/2);
            }
            sb.append(')');
        }
    }

    public static int SameColor (int x, int y, int N) {
        boolean same_color = true;
        int first_color = arr[x][y];
        for (int i=0;i<N;i++) {
            if (!same_color) break;
            for (int j=0;j<N;j++) {
                if(arr[x+i][y+j]!=first_color) {
                    same_color = false;
                    break;
                }
            }
        }
        if (same_color) return first_color;
        else return -1;
    }
}