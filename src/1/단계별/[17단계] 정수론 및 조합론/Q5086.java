// 5086번 배수와 약수

/*
<문제 정보>
 1. 첫번째 (A) 두번째 (B) 가 주어짐
    - A가 B의 약수 -> factor
    - A가 B의 배수 -> multiple
    - 둘 다 아니라면 -> neither
 2. 각 숫자는 10,000 이하의 두 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q5086 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int A; int B;
        while(true) {
            st=new StringTokenizer(br.readLine());
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            if(A==0 && B==0) break;
            else if (B%A==0) bw.write("factor");
            else if (A%B==0) bw.write("multiple");
            else bw.write("neither");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}