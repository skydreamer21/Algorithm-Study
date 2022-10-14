// 1780번 종이의 개수
/*
<문제 정보>
 1. NXN 크기의 종이의 각 칸에는 -1 또는 0 또는 1
 2. 다 같은 수가 아니라면 9등분
 3. 다 잘랐을 때 각각 수로 채워진 종이의 개수
 4. 1<=N<=3^7 N은 3의 거듭제곱꼴

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1780 {
    static int[][] arr;
    static int a=0;
    static int b=0;
    static int c=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        arr = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        divide(0,0,N);
        sb.append(a).append("\n").append(b).append("\n").append(c);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void divide (int x, int y, int N) {
        if (SameColor(x,y,N)==-1) a++;
        else if (SameColor(x,y,N)==0) b++;
        else if (SameColor(x,y,N)==1) c++;
        else {
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) divide(x+N/3*i,y+N/3*j,N/3);
            }
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
        else return -2;
    }
}