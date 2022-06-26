package Programmers.level1;

// 숫자 0~9 : 48 ~ 57
// a ~ z : 97 ~ 122

/*
class Solution {
    public int solution(String s) {
        int answer;
        String[] numbersByAlphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        // replaceAll 은 기존의 것을 수정하는게 아니라 새로운 변수를 만드는 것
        for (int i=0;i<10;i++) s = s.replaceAll(numbersByAlphabet[i], numbers[i]);
        // try{
        //     System.out.println(s);
        //     answer = Integer.parseInt(s);
        // } catch (NumberFormatException e) {
        //     return -1;
        // }
        answer = Integer.parseInt(s);

        return answer;
    }
}
*/



// 히든 테케를 비교해보면 Hash를 사용한 풀이가 시간적으로만 봤을 때 최소 5배 이상 빠름
// 위의 풀이는 O(N)인 replaceAll 을 10번 돌기 때문에 이러한 차이가 나는 것으로 예상

import java.util.HashMap;

class Solution {
    static HashMap<Integer, Integer> numbers = new HashMap<>();

    public int solution(String s) {
        int answer = 0;
        getNumberHashTable();
        char[] str = s.toCharArray();
        int[] numberCharLength = {4,3,3,5,4,4,3,5,5,4};
        int len = str.length;
        int numHashValue=0;
        int num;
        for (int i=0;i<len;i++) {
            answer*=10;
            if (!isNum(str[i])) {
                numHashValue = numberHash(str[i], str[i+1]);
                num = numbers.get(numHashValue);
                answer+=num;
                i+=(numberCharLength[num]-1);
            }
            else answer += (str[i]-'0');
        }

        return answer;
    }

    public static void getNumberHashTable() {
        numbers.put(numberHash('z','e'),0); // 0
        numbers.put(numberHash('o','n'),1); // 1
        numbers.put(numberHash('t','w'),2); // 2
        numbers.put(numberHash('t','h'),3); // 3
        numbers.put(numberHash('f','o'),4); // 4
        numbers.put(numberHash('f','i'),5); // 5
        numbers.put(numberHash('s','i'),6); // 6
        numbers.put(numberHash('s','e'),7); // 7
        numbers.put(numberHash('e','i'),8); // 8
        numbers.put(numberHash('n','i'),9); // 9
    }

    public static int numberHash(int c1, int c2) {
        return 26*(c1-'a') + (c2-'a');
    }

    public static boolean isNum(int c) {
        return c>='0' && c<='9';
    }
}
