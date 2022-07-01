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

// 1. String 배열을 순회하며 HashSet에 넣는다.
//      - 길이를 넣는 HashSet도 추가
// 2. 각 String 요소(번호)에서 길이 HashSet에 있는 길이로만 substring 사용해서 비교

// 주의사항 배열의 길이가 낮은 순으로 정렬이 되어있어야 한다!

// Another solution -> 사전순 정렬 후 startsWith으로 연속된 번호끼리만 비교!
// 연속된 번호끼리만 비교를 하니까 더 빠를줄알았는데 큰 데이터에서는 sort가 더 느림.. 왜냐하면 String 문자열을 하나하나 비교해야 하니까

import java.util.HashSet;
import java.util.Arrays;

class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        HashSet<String> phoneNumbers = new HashSet<>();
        HashSet<Integer> phoneNumLens = new HashSet<>();

        Arrays.sort(phone_book, (a,b) -> a.length() - b.length());

        boolean isClear = true;
        for (String phoneNum : phone_book) {
            for (int len : phoneNumLens) {
                if (phoneNum.length()<len) continue;
                if (phoneNumbers.contains(phoneNum.substring(0,len))) {
                    isClear = false;
                    break;
                }
            }
            if (!isClear) break;
            phoneNumbers.add(phoneNum);
            phoneNumLens.add(phoneNum.length());
        }
        return isClear;
    }
}


/*
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].startsWith(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}*/