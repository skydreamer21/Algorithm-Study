// 1085번 직사각형에서 탈출

/*
<문제 정보>
 1. 세 점에 주어 졌을 때, 축에 평행한 직사각형을 만들기 위한 네번째 점 출력

<프로그램 진행>
 1. 4개 점의 좌표가 4개의 수들로 이루어져 있음
 2. (a,b) (c,d) (a,b), (c,d)
 3. 하나의 x좌표당 y 두개
 4. 하나의 y좌표당 x 두개
 => x좌표 중 개수 한개인거, y좌표중 개수 한개인거

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q3009 {
    public static int getLessOne(int[] arr) {
        int LessOne;
        if (arr[0]==arr[1]) LessOne = arr[2];
        else if (arr[0]==arr[2]) LessOne = arr[1];
        else LessOne = arr[0];
        return LessOne;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] x = new int[3];
        int[] y = new int[3];
        String temp;
        int x_cool;
        int y_cool;
        for (int i=0;i<3;i++) {
            temp = br.readLine();
            st = new StringTokenizer(temp);
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x_cool = getLessOne(x);
        y_cool = getLessOne(y);
        bw.write(x_cool+" "+y_cool);
        bw.flush();
        bw.close();
        br.close();
    }
}