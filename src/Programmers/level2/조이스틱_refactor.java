import java.util.ArrayList;

class 조이스틱_refactor {
    static int len;
    static ArrayList<Integer> isNotA = new ArrayList<>();
    public int solution(String name) {
        len = name.length();
        getIsNotA(name);

        int count = isNotA.size()==0 ? 0 : getMinMoveOfLeftAndRight();
        for (int idxOfNotA : isNotA) {
            count += Math.min(name.charAt(idxOfNotA) - 'A', 'Z' - name.charAt(idxOfNotA) + 1);
        }
        return count;
    }

    // A가 아닌 문자의 Index를 ArrayList에 추가
    public static void getIsNotA(String name) {
        char[] nameCharArr = name.toCharArray();
        for (int i=0;i<len;i++) {
            if (nameCharArr[i] != 'A') isNotA.add(i);
        }
    }

    public static int getMinMoveOfLeftAndRight() {
        final int START = 0;
        final int END = len;

        int numOfNotA = isNotA.size();
        // 오른쪽 방향키로만
        int onlyForward = isNotA.get(numOfNotA-1)-START;
        // 왼쪽 방향키로만
        int onlyBackward = END - isNotA.get(0);
        int minMove = Math.min(onlyForward, onlyBackward);

        int startToLastNotAInForward, startToLastNotAInBackward;
        int minMoveInEachCase;
        // 오른쪽 방향키로 가는 마지막 A가 아닌 문자의 인덱스 : isNotA.get(i)
        // 왼쪽 방향키로 가는 마지막 A가 아닌 문자의 인덱스 : isNotA.get(i+1)
        for (int i=0;i<numOfNotA-1;i++) {
            startToLastNotAInForward = isNotA.get(i) - START;
            startToLastNotAInBackward = END - isNotA.get(i+1);
            minMoveInEachCase = startToLastNotAInForward
                    + startToLastNotAInBackward
                    + Math.min(startToLastNotAInForward,startToLastNotAInBackward);
            minMove = Math.min(minMove, minMoveInEachCase);
        }
        return minMove;
    }
}