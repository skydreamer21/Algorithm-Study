// 17425번 약수의 합 (G4)
/*
<문제 정보>
 1. f(x) : x의 약수의 합
 2. g(x) : f(1) + f(2) + ... + f(x)
 3. g(N)을 구하자.

<변수 범위>
 1. 1초 / 512MB
 2. 테스트케이스 1<=T<=100,000
 3. 자연수 N 1<=N<=1,000,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.ArrayList;

public class Q17425 {
    static boolean[] numbers = new boolean[1000];
    static ArrayList<Integer> primeNumList = new ArrayList<>();
    static int[] g;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        getPrimeNum();
        for(int n : primeNumList) System.out.printf("%d ",n);
        System.out.println();
        System.out.println(primeNumList.size());
        /*while(T-- >0) {

        }*/


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPrimeNum() {
        numbers[0] = true; // 0은 합성수임
        numbers[1] = true;
        for (int i=2;i<Math.sqrt(1000);i++) {
            if(numbers[i]) continue;
            for (int j=i*i;j<1000;j+=i) numbers[j] = true;
        }

        for (int i=2;i<1000;i++) {
            if(!numbers[i]) primeNumList.add(i);
        }
    }
}
