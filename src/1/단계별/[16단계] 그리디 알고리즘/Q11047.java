// 11047번 동전0

/*
<문제 정보>
 1. 동전 N종류 각각 무수히 많음
 2. 가치합 K만들때 필요한 동전 개수의 최솟값
 3. 1<=N<=10  /  1<=K<=100,000,000
 4. 이웃한 동전의 가치는 배수 관계


<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 38267097 gusanr7498 - 14288KB / 128ms  (코드이해불가) - 이분탐색인가? 암튼
// 나중에 이해해보기



import java.io.*;
import java.util.StringTokenizer;

public class Q11047 {
    static int[] coin;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for (int i=0;i<N;i++) coin[i] = Integer.parseInt(br.readLine());

        int coins=0;
        while(K>0) {
            if (K>=coin[N-1]) {
                coins+=K/coin[N-1];
                K%=coin[N-1];
                //System.out.printf("%d원\n",coin[N-1]);
            }
            else N--;
        }

        bw.write(String.valueOf(coins));
        bw.flush();
        bw.close();
        br.close();
    }
}