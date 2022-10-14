// 2798번 블랙잭

/*
<문제 정보>
 1. [첫째줄] N : 카드갯수 / M : 넘지 않으면서 가장 가깝게 만들어야 하는 수
 2. [둘째줄] N개의 숫자 목록
 3. M가 가장 가까운 3개의 숫자의 합을 출력
 4. 입력에는 무조건 문제에 조건에 맞는 출력이 있게끔 주어짐

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2798 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(S1);
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        String S2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(S2);
        int[] card = new int[N];
        for (int i=0;i<N;i++) card[i] = Integer.parseInt(st2.nextToken());
        int diff=M;
        int temp;
        for (int i=0;i<N-2;i++) {
            if (diff==0) break;
            for (int j=i+1;j<N-1;j++) {
                if (diff ==0) break;
                for (int k=j+1;k<N;k++) {
                    if (diff==0) break;
                    temp = card[i]+card[j]+card[k];
                    if (temp<=M && M-temp<diff) {
                        diff = M-temp;
                    }
                }
            }
        }
        bw.write(String.valueOf(M-diff));
        bw.flush();
        bw.close();
    }
}