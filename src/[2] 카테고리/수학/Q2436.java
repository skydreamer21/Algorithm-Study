// 2436번 공약수 (G5) [Math][유클리드호제법]
/*
<문제 정보>
 1. 최소공배수와 최대공약수가 주어질 때 두 수 A, B 구하기
 2. 여러개라면 두 자연수의 합이 최소가 되는 수를 출력

<변수 범위>
 1. 1초 / 128MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2436 {
    static int G, L;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        G = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // ******************** 메인 로직 ********************
        int mul = L/G;
        int big = 0;
        int small = 0;
        for (int i = (int)Math.sqrt(mul); i>=1; i--) {
            if (mul % i == 0 && isCoPrime(mul/i, i)) {
                small = G*i;
                big = G*(mul / i);
                break;
            }
        }

        // ******************** 정답 출력 ********************
        sb.append(small).append(" ").append(big);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isCoPrime(int a, int b) {
        return GCD(a, b) == 1;
    }

    // a > b
    public static int GCD (int a, int b) {
        return a % b == 0 ? b : GCD(b, a%b);
    }
}
