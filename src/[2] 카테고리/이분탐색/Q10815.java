// 10815번 숫자카드 (S4)
/*
<문제 정보>
 1. 갖고 있는 숫자 카드이면 1, 아니면 0 출력

<변수 범위>
 1. 2초 / 256MB
 2. 숫자카드 개수 1<=N<=500,000
 3. 적힌 수 -10,000,000<= <=10,000,000
 4. 판별할 수 개수 1<=M<=500,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q10815 {
    static int N;
    static int[] cards;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) cards[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(cards);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num;
        while (M-->0) {
            num = Integer.parseInt(st.nextToken());
            sb.append(BS(num) ? 1 : 0).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean BS (int key) {
        int lo = 0;
        int hi = N-1;
        int mid;

        while (lo<=hi) {
            mid = (lo+hi)/2;
            if(cards[mid]==key) return true;
            else if (cards[mid]<key) lo = mid+1;
            else hi = mid-1;
        }
        return false;
    }

}





















