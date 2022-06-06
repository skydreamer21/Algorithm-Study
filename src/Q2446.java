// 2446번 별찍기 - 9 (B3)
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q2446 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++) {
            for (int j=1;j<=2*N-1-i;j++) {
                sb.append(j<=i ? " " : "*");
//                System.out.print("*");
            }
//            System.out.println();
            sb.append("\n");
        }
        for (int i=1;i<N;i++) { //N-i-1 + 2*i+1
            for (int j=1;j<=N+i;j++) {
                sb.append(j<=N-i-1 ? " " : "*");
//                System.out.print("*");
            }
//            System.out.println();
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
