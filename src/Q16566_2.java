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

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q16566_2 {
    static int N,M,K;
    static int[] cards;
    static int removedCardNum = 0;
    static int[] removedCards;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cards = new int[M];
        removedCards = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);

        st = new StringTokenizer(br.readLine());
        int key;
        int firstCheckIdx;
        int secondCheckIdx;
        int removedCardIdx;
        int myCard, myCardIdx;
        while(K-- >0) {
            key = Integer.parseInt(st.nextToken());
            firstCheckIdx = checkInCards(key);
            removedCardIdx = checkInRemovedCards(firstCheckIdx);
//            System.out.printf("first : %d, removedCardIdx : %d\n",firstCheckIdx, removedCardIdx);

            // 해당 카드가 제거되지 않았거나 제거된 카드가 없다면 이번에 이카드를 내고 삭제한다.
            if (removedCardIdx==-1 || removedCardNum==0) {
                myCard = cards[firstCheckIdx];
                myCardIdx = firstCheckIdx;
            }

            // 해당 카드가 제거되었다면 제거된 카드리스트에 없는 수 중에서 해당 카드보다 높은 수 중 최솟값을 찾는다.
            else {
                secondCheckIdx = getMyCard(removedCardIdx);
                myCard = cards[secondCheckIdx];
                myCardIdx = secondCheckIdx;
            }

            sb.append(myCard).append("\n");
            removedCards[removedCardNum++] = myCardIdx;
            Arrays.sort(removedCards,0,removedCardNum);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // lo와 hi는 모두 배열 인덱스
    public static int checkInCards(int key) {
        int lo = 0;
        int hi = M-1;
        int mid;

        while(lo<hi) {
            mid = (lo+hi)/2;
            if(cards[mid]<=key) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }

    // 먼저 minIdx가 removedCard에 어디 있는지 찾는다.
    public static int checkInRemovedCards(int minIdx) {
        int lo = 0;
        int hi = removedCardNum;
        int mid;

        while(lo<=hi) {
            mid = (lo+hi)/2;
//            System.out.printf("lo : %d, hi : %d, mid: %d\n",lo,hi,mid);
            if(removedCards[mid]==minIdx) return mid;
            if(removedCards[mid]<minIdx) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }

    public static int getMyCard(int removedIdx) {
        for (int i=removedIdx; i<removedCardNum;i++) {
            if(removedCards[i+1] - removedCards[i]>1) return removedCards[i]+1;
        }
        // 여기까지 안끝났다면 removedCard에 있는 마지막 카드보다 1더 큰 카드 반환
        return removedCards[removedCardNum-1]+1;
    }
}















