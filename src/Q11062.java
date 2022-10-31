// 11062번 카드게임 (G3)
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q11062 {
    static final boolean LEFT = true;
    static final boolean RIGHT = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // ******************** 입력 & 초기화 ********************
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Deque<Integer> cards = new ArrayDeque<>();
            for (int i=0; i<N; i++) {
                cards.add(Integer.parseInt(st.nextToken()));
            }

            // ******************** 메인 로직 ********************
            int score = 0;
            boolean myTurn = true;
            int maxCardOfThisTurn;
            while (!cards.isEmpty()) {
                if (cards.size() == 1) maxCardOfThisTurn = cards.poll();
                else { // cards.size() >= 2
                    int leftExpectedProfit = getExpectedProfit(cards, LEFT);
                    int rightExpectedProfit = getExpectedProfit(cards, RIGHT);
                    maxCardOfThisTurn = leftExpectedProfit >= rightExpectedProfit ? cards.pollFirst() : cards.pollLast();
                }
                if (myTurn) score += maxCardOfThisTurn;
                myTurn = !myTurn;
            }

            // ******************** 정답 출력 ********************
            sb.append(score).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getExpectedProfit (Deque<Integer> cards, boolean side) {
        int card, opportunityCost;
        if (side == LEFT) card = cards.pollFirst();
        else card = cards.pollLast();

        opportunityCost = cards.peekFirst();
        if (cards.size() > 1) opportunityCost += cards.peekLast();

        if (side == LEFT) cards.addFirst(card);
        else cards.addLast(card);
        return Math.max(card, opportunityCost);
    }
}

/*
public class Q11062 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // ******************** 입력 & 초기화 ********************
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Deque<Integer> cards = new ArrayDeque<>();
            for (int i=0; i<N; i++) {
                cards.add(Integer.parseInt(st.nextToken()));
            }

            // ******************** 메인 로직 ********************
            int score = 0;
            int oppScore = 0;
            boolean myTurn = true;
            while (!cards.isEmpty()) {
                System.out.printf("%s 의 턴 입니다.\n", myTurn ? "나" : "상대");
                printCards(cards);
                System.out.println("왼쪽은 1, 오른쪽은 2를 선택해주세요");
                System.out.print("--> ");
                String option = br.readLine();

                while (!option.equals("1") && !option.equals("2")) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("왼쪽은 1, 오른쪽은 2를 선택해주세요");
                    System.out.print("--> ");
                    option = br.readLine();
                }

                int cardOfThisTurn = 0;
                if (option.equals("1")) {
                    cardOfThisTurn = cards.pollFirst();
                }
                else cardOfThisTurn = cards.pollLast();
                if (myTurn) score += cardOfThisTurn;
                else oppScore += cardOfThisTurn;
                myTurn = !myTurn;
            }

            // ******************** 정답 출력 ********************
            System.out.println("\n****** Result ******");
            System.out.printf("나의 점수 : %d\n", score);
            System.out.printf("상대의 점수 : %d\n", oppScore);
            sb.append(score).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void printCards(Deque<Integer> cards) {
        Deque<Integer> cardsCopy = new ArrayDeque<>(cards);
        while(!cardsCopy.isEmpty()) {
            System.out.printf("%d ", cardsCopy.pollFirst());
        }
        System.out.println();
    }
}
 */
