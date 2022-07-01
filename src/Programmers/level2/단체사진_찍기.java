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

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

/*

class Solution {
    static int count = 0;
    static int[] line;

    static HashMap<Character, Integer> friends = new HashMap<>();
    static ArrayList<int[]>[] conditions = new ArrayList[8];

    static final int TOTAL_FRIEND = 8;

    static final int EQUAL = 0;
    static final int BIGGER = 1;
    static final int SMALLER = 2;

    static final int OTHER_FRIEND = 0;
    static final int MODE = 1;
    static final int SPACE = 2;

    static final int EMPTY = -1;


    public int solution(int n, String[] data) {
        count = 0;
        friendsToNum();
        for (int i=0;i<TOTAL_FRIEND;i++) {
            conditions[i] = new ArrayList<>();
        }
        for (String cond : data) getCondition(cond);
        line = new int[TOTAL_FRIEND];
        Arrays.fill(line, EMPTY);
        countPossibleCases(0);

        return count;
    }

    public static void countPossibleCases(int depth) {
        if (depth == TOTAL_FRIEND) {
            count++;
            return;
        }

        for (int i=0;i<TOTAL_FRIEND;i++) {
            if (line[i] != EMPTY) continue;
            // i friend가 depth번째 자리에 설 수 있는지 체크
            if (!isPossible(i,depth)) continue;
            line[i] = depth;
            countPossibleCases(depth+1);
            line[i] = EMPTY;
        }
    }

    // friend 가 order번째 자리에 설 수 있는지
    public static boolean isPossible(int friend, int order) {
        // friend에 걸린 조건을 순회
        int otherFriend, space, goalSpace;
        for (int[] condition : conditions[friend]) {
            otherFriend = condition[OTHER_FRIEND];
            if (line[otherFriend] == EMPTY) continue;
            space = Math.abs(order-line[otherFriend])-1;
            goalSpace = condition[SPACE];
            switch(condition[MODE]) {
                case EQUAL:
                    if (space!=goalSpace) return false;
                    break;
                case BIGGER:
                    if (space<=goalSpace) return false;
                    break;
                case SMALLER:
                    if (space>=goalSpace) return false;
            }
        }
        return true;
    }

    public static void getCondition(String cond) {
        char[] condition = cond.toCharArray();
        int friend1 = friends.get(condition[0]);
        int friend2 = friends.get(condition[2]);
        int mode=0;
        switch (condition[3]) {
            case '=':
                mode = EQUAL;
                break;
            case '>':
                mode = BIGGER;
                break;
            case '<':
                mode = SMALLER;
        }
        int space = condition[4] - '0';

        conditions[friend1].add(new int[] {friend2, mode, space});
        conditions[friend2].add(new int[] {friend1, mode, space});
    }

    public static void friendsToNum() {
        friends.put('A', 0);
        friends.put('C', 1);
        friends.put('F', 2);
        friends.put('J', 3);
        friends.put('M', 4);
        friends.put('N', 5);
        friends.put('R', 6);
        friends.put('T', 7);
    }
}

 */
