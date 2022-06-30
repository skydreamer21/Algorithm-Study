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

/*
첫번째, 마지막 중괄호 제거
,를 기준으로 String 배열로 나눈다.
각 String 마다 중괄호와 쉼표를 delim 으로 써서 분리한다.
-> 각 집합의 number 배열을 얻을 수 있음

Next
길이 순으로 탐색할 수 있어야함
자료구조 ArrayList<ArrayList<Integer>>
길이와 index를 담는, 정렬 가능한 class가 필요
-> 해당 class를 정렬 후 순서대로 index를 활용해 ArrayList에 접근
-> HashSet에 순차적으로 담아가며 없는 것을 체크함과 동시에 정답 배열에도 순서대로 담는다.
*/

// sol2 : 숫자만 돌면서 횟수를 세서 가장 많이 나온순으로 출력하면 끝! O(N) 에 가능
/// 위의 풀이보다 더 좋음

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

class 튜플 {
    public int[] solution(String s) {
        // {, } 와 같은 메타문자를 다룰 때는 \\ 붙여주어야 함 (역슬래시)
        String[] splitOfS = s.split("\\{\\{|\\},\\{|\\}\\}"); // 괄호를 공백으로 바꾸고 "공백,공백" 을 delim 으로 할 수도 있음
        int numOfSet = splitOfS.length-1;

        // 위에서 분리한 것을 자료에 담는다 + class 또한 만들어준다.
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        SetStatus[] statuses = new SetStatus[numOfSet];
        StringTokenizer st;
        for (int i=0;i<numOfSet;i++) {
            st = new StringTokenizer(splitOfS[i+1],",");
            sets.add(new ArrayList<>());
            while(st.hasMoreTokens()) {
                sets.get(i).add(Integer.parseInt(st.nextToken()));
            }
            statuses[i] = new SetStatus(i, sets.get(i).size());
        }

        // statuses class 길이순 정렬 => **class 만들 필요 없음! .length로 정렬 가능!
        Arrays.sort(statuses);

        // 정렬된 statuses 배열을 순회하면서 답 추가 <- HashSet 이용

        int idx = 0;
        int[] answer = new int[numOfSet];
        HashSet<Integer> elements = new HashSet<>();
        for (SetStatus status : statuses) {
            for (int num : sets.get(status.idx)) {
                if (elements.add(num)) { // add의 반환값으로 체크 가능!
                    answer[idx++] = num;
                    break;
                }
                /*
                if (!elements.contains(num)) {
                    elements.add(num);
                    answer[idx++] = num;
                    break;
                }
                */
            }
        }
        return answer;
    }
}

class SetStatus implements Comparable<SetStatus> {
    int idx, len;

    public SetStatus (int idx, int len) {
        this.idx = idx;
        this.len = len;
    }

    @Override
    public int compareTo(SetStatus o) {
        return this.len - o.len;
    }
}