// 1110번 더하기 사이클

import java.util.Scanner;

public class Q1110 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(); //입력 숫자
        int N_mod=N; // 반복문에 들어가서 계속 바뀌는 변수
        int cycle=0; // 사이클
        int SumofEach; // 각 자리수 합
        int new_N; // 새로 만들어지는 수
        while (true) {
            cycle++;
            if (N_mod <10 ) SumofEach=N_mod;
            else SumofEach=N_mod/10+N_mod%10;
            new_N=10*(N_mod%10)+SumofEach%10;
            if (new_N==N) break;
            else N_mod=new_N;
        }
        System.out.println(cycle);
    }
}







