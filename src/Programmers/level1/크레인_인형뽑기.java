/*
// 인형을 뺄때마다 board의 값을 0으로 바꿔주면 board만으로도 가능
// 하지만 board의 모든 빈 곳을 탐색해줘야한다는 단점이 있음

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

    static final int EMPTY = 0;
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        Deque<Integer>[] stack = new ArrayDeque[N+1];
        int doll;
        for (int col=0;col<N;col++) {
            stack[col+1] = new ArrayDeque<>();
            for (int row=N-1;row>=0;row--) {
                doll = board[row][col];
                if (doll==EMPTY) break;
                stack[col+1].add(doll);
            }
        }

        Deque<Integer> result = new ArrayDeque<>();
        int answer = 0;
        for (int move : moves) {
            if (stack[move].isEmpty()) continue;

            doll = stack[move].pollLast();
            if (result.isEmpty()) result.add(doll);
            else {
                if (result.peekLast() == doll) {
                    result.pollLast();
                    answer += 2;
                }
                else result.add(doll);
            }
        }
        return answer;
    }
}*/
