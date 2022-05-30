// 16566번 카드게임 (P5)
/*
<문제 정보>
 1. K번 동안 민수가 내는 카드를 출력
    - 철수가 낼 카드보다 큰 카드중 가장 작은 카드

<변수 범위>
 1. 1.2초 / 512MB
 2. N개중 M개의 카드를 고름 1<=M<=N<=4,000,000
 3. 1<=K<=min(M,10000))

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// <시간초과>

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q16566 {
    static int N, M, K;
    static TreeSet<Integer> cards = new TreeSet<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i=0;i<M;i++) cards.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int key;
        int myCard;
        while(K-- >0) {
            key = Integer.parseInt(st.nextToken());
            myCard = cards.higher(key);
            sb.append(myCard).append("\n");
            cards.remove(myCard);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}















