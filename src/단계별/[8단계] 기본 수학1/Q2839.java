// 2839번 설탕배달

/*
<문제 정보>
 1. N = 3*a + 5*b 로 표현할 때, a+b의 최솟값 출력
 2. 위와 같이 표현할 수 있는 a, b가 존재하지 않으면 -1출력

<프로그램 진행>
 1. a+b가 최소이려면 b값이 최대가 되어야함.
 2. b값을 하나씩 바꿔가며 a,b를 구해봄
 3. 이때 b가 될수있는 최댓값을 구한 후 거기서부터 1씩 낮춰가며 구함.

<필요 함수>
 */

import java.io.*;

public class Q2839 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        int a=0;
        int b = N/5;
        int rem;
        Boolean IsThisPossible = false;
        while (b>=0) {
            rem = N - 5*b;
            if(rem%3==0) {
                a=rem/3;
                IsThisPossible=true;
                break;
            }
            else b--;
        }
        if (IsThisPossible) bw.write(String.valueOf(a+b));
        else bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
    }
}






