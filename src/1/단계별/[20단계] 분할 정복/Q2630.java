// 2630번 색종이 만들기
/*
<문제 정보>
 1. 안에 있는 색이 모두 같아질때까지 사등분
 2. 각 색깔의 색종이가 몇개인지 차례로 출력

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2630 {
    static int[][] arr;
    static int white=0;
    static int blue=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        divide(0,0,N);
        bw.write(String.valueOf(white));
        bw.newLine();
        bw.write(String.valueOf(blue));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void divide (int x, int y, int N) {
        if (SameColor(x, y, N)==0) white++;
        else if (SameColor(x, y, N)==1) blue++;
        else {
            divide(x,y,N/2);
            divide(x+N/2,y,N/2);
            divide(x,y+N/2,N/2);
            divide(x+N/2,y+N/2,N/2);
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