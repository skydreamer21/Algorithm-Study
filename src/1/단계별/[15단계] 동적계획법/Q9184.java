// 9184번 신나는 함수 실행

/*
<문제 정보>
 -50이상 50이하인 세 정수 a, b, c에 대해서
 1. 한개라도 0이하이면 1을 return
 2. 한개라도 20보다 크면 w(20,20,20)을 return
 3. a<b<c 라면 w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c) return
 4. 위의 1,2,3에 해당되지 않는다면 w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1) return

 1-2-3-4 순서대로 조건 진행

 위와 같은 재귀함수를 구현하고 a,b,c를 입력받았을 때 w(a, b, c) = ____ 꼴로 출력

<프로그램 진행>
 1.

<필요 함수>
 1. fill_1 : 1조건 이용해서 하나라도 0일 때 1을 채워넣음

 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q9184 {
    static int[][][] memo = new int[21][21][21];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        fill_1();
        int a, b, c;
        while(true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a==-1 && b==-1 && c==-1) break;
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int w(int a, int b, int c) {
        // 1 조건
        if (a<0 || b<0 || c<0) return 1;
        // 2 조건
        else if (a>20 || b>20 || c>20) return w(20,20,20);

        if (memo[a][b][c]==0) {
            // 3 조건
            if (a<b && b<c) memo[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);

            // 4 조건
            else memo[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        }
        return memo[a][b][c];
    }

    public static void fill_1 () {
        for (int i=0;i<=20;i++) {
            Arrays.fill(memo[0][i],1);
            for (int j=0;j<=20;j++) {
                memo[i][0][j]=1;
                memo[i][j][0]=1;
            }
        }
    }
    /*
    public static void printResult (int a, int b, int c) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(memo[a][b][c]).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
     */
}