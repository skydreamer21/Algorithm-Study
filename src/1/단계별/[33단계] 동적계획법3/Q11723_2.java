// 11723번 집합
/*
<문제 정보>
 1.

<변수 범위>
 1. 1.5초 / 4MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q11723_2 {
    static final int ALL_SET = 0B11111111111111111111;
    static final int EMPTY_SET = 0B0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int set = 0B0;

        String operation;
        int parameter = 0;
        while(N-- >0) {
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken();
            if (!operation.equals("all") && !operation.equals("empty")) {
                parameter = Integer.parseInt(st.nextToken());
                parameter = 1 << (parameter-1);
//                parameter = (int) Math.pow(2,parameter-1);

            }

            switch(operation) {
                case "add" :
                    set |= parameter;
                    break;
                case "remove" :
                    set &= ~parameter;
                    break;
                case "check" :
                    sb.append( (set & parameter) == parameter ? 1 : 0).append("\n");
                    break;
                case "toggle" :
//                    set = (set & ~parameter) | (~set & parameter);
                    set ^= parameter;
                    break;

                case "all" :
                    set |= ALL_SET;
                    break;
                case "empty" :
                    set &= EMPTY_SET;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}





















