// 1934번 최소공배수

/*
<문제 정보>
 1. 두개의 자연수를 입력받아 최대공약수와 최소공배수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q1934 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int A; int B; int GCD; int LCM;
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A>B) GCD = GCD(A,B);
            else GCD = GCD(B,A);
            LCM=A*B/GCD;
            sb.append(LCM).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
/*
    public static int GCD (int A, int B) {
        int R;
        while (B!=0) {
            R=A%B;
            A=B;
            B=R;
        }
        return A;
    }
 */
    public static int GCD (int A, int B) {
        if(B==0) return A;
        else return GCD(B,A%B);
    }
}