// 번
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


package Programmers.level2;

import java.util.ArrayList;

class 조이스틱 {
    static int len;
    static int possibleMove;
    static ArrayList<Integer> isNotA = new ArrayList<>();
    public int solution(String name) {
        len = name.length();
        possibleMove = (len-1)/2 - 1;
        getIsNotA(name);

        int count = isNotA.size()==0 ? 0 : getMinMove();
        System.out.printf("minMove : %d\n",count);
        for (int order : isNotA) {
            count += Math.min(name.charAt(order-1) - 'A', 'Z' - name.charAt(order-1) + 1);
        }
        // for (int order : isNotA) count += name.charAt(order-1) - 'A';
        return count;
    }

    // A가 아닌 문자의 순서를 ArrayList에 추가
    public static void getIsNotA(String name) {
        int order = 1;
        for (char c : name.toCharArray()) {
            if (c != 'A') isNotA.add(order);
            order++;
        }
    }

    public static int getMinMove() {
        // 1번 mode의 시작은 1, 2번 mode의 시작은 1+len
        final int START = 1;
        final int END = 1+len;

        int numOfNotA = isNotA.size(); // numOfNotA 가 0이면 바로 아래서 오류 (인덱스 -1 들어감)
        int minMove = isNotA.get(numOfNotA-1)-START;
        int now, next;
        for (int i=0;i<numOfNotA-1;i++) {
            now = isNotA.get(i);
            next = isNotA.get(i+1);
            minMove = Math.min(minMove, now-START + END-next + Math.min(now-START,END-next));
        }
        /*
        int moves;
        for (int i=0;i<numOfNotA;i++) {
            now = isNotA.get(i);
            // 1번 모드 -> 다음 인덱스 (마지막은 따로)
            if (now <= START+possibleMove && i<numOfNotA-1) {
                moves = (now-START)*2 + END-isNotA.get(i+1);
                minMove = Math.min(minMove, moves);
            }

            // 2번 모드 ->
            if (now >= END-possibleMove && i>0) {
                moves = (END - now)*2 + isNotA.get(i-1)-START;
                minMove = Math.min(minMove, moves);
            }
        }
        */
        return minMove;
    }
}
