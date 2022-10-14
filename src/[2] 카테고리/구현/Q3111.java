// 3111번 검열 (P4) [실패] [구현]
/*
<문제 정보>
 1. 텍스트 T에서 단어 A 검열 프로그램
    - 처음으로 등장하는 A 삭제
    - 마지막으로 등장하는 A 삭제
    - 반복

<변수 범위>
 1. 1.5초 / 128MB
 2. A 최대 25자
 3. T는 최대 300,000자

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q3111 {
    static final char EMPTY = '0';

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();
        String text = br.readLine();

        char[] censoredText = Censor(text, word);
        for (char c : censoredText) {
            if (c == EMPTY) continue;
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static char[] Censor(String text, String word) {
        int wordLength = word.length();
        int lo = 0;
        int hi = text.length() - wordLength;
//        System.out.printf(" 시작시 lo : %d, hi : %d\n",lo, hi);

        // hi 가 처음부터 음수면 검열 필요 없음
        if (hi<0 || wordLength==0) return text.toCharArray();

        char[] textArray = text.toCharArray();
        char[] wordArray = word.toCharArray();
        boolean hasWord = true;
        while(true) {
            // 앞부터 탐색 ------------------------------------------------
            for (int i=lo; i <= hi; i++) {
                hasWord = true;
                if (textArray[i] != wordArray[0]) {
                    hasWord = false;
                    continue;
                }
                int checkedCharacters = 0;
                int j = 0;
                while(checkedCharacters < wordLength) {
                    // 글자 하나씩 체크
                    // 다 맞으면 제거 -> lo,hi 변형
                    // 체크하려는 글자가 EMPTY 이면 넘어감
                    if (i+j == textArray.length) { // 0이 계속 나와서 배열 범위를 벗어날 수 있음.
                        hasWord = false;
                        break;
                    }
                    if (textArray[i+j] == EMPTY) {
                        j++;
                        continue;
                    }
                    if (textArray[i+j++] != wordArray[checkedCharacters]) {
                        hasWord = false;
                        break;
                    }
                    checkedCharacters++;
                }
                // 다 맞았을 경우 제거하고, lo 바꾸고 빠져나감.
                j = 0;
                if(hasWord) {
                    while (checkedCharacters>0) {
                        if (textArray[i+j] == EMPTY) {
                            j++;
                            continue;
                        }
                        textArray[i+j] = EMPTY;
                        checkedCharacters--;
                    }
                    lo = Math.max(i - wordLength + 1, 0);
                    break;
                }
            } // 앞 탐색 끝 -----------------------------------------------------
            // 맞는 단어가 하나도 없을 경우 알고리즘 종료
//            if (!hasWord) break;

            for (char c : textArray) System.out.print(c);
            System.out.println();
            System.out.printf("lo : %d, hi : %d\n",lo, hi);

            /*for (char c : textArray) {
                if (c == EMPTY) continue;
                System.out.print(c);
            }
            System.out.println();*/

            // 뒤부터 탐색 -----------------------------------------------------
            for (int i=hi; i >= 0; i--) {
//                System.out.printf("lo : %d\n",lo);
                hasWord = true;
                if (textArray[i] != wordArray[0]) {
                    hasWord = false;
                    continue;
                }
                int checkedCharacters = 0;
                int j = 0;
//                System.out.printf("i : %d\n",i);
                while(checkedCharacters < wordLength) {
                    // 글자 하나씩 체크
                    // 다 맞으면 제거 -> lo,hi 변형
                    // 체크하려는 글자가 EMPTY 이면 넘어감

                    if (i+j == textArray.length) { // 0이 계속 나와서 배열 범위를 벗어날 수 있음.
                        hasWord = false;
                        break;
                    }

                    if (textArray[i+j] == EMPTY) {
                        j++;
                        continue;
                    }
//                    System.out.printf("j : %d\n",j);
                    if (textArray[i+j++] != wordArray[checkedCharacters]) {
                        hasWord = false;
                        break;
                    }
                    checkedCharacters++;
                }
                j = 0;
                if(hasWord) {
                    while (checkedCharacters>0) {
                        if (textArray[i+j] == EMPTY) {
                            j++;
                            continue;
                        }
                        textArray[i+j] = EMPTY;
                        checkedCharacters--;
                    }
                    hi = Math.max(i-1, 0);
                    // hi가 낮아진 걸로 인해 앞에서 조사할 때 영향을 받지 않도록 lo 값 수정
                    lo = Math.min(lo, Math.max(hi - wordLength + 1, 0));
                    break;
                }
            }
            if (!hasWord) break;

            for (char c : textArray) System.out.print(c);
            System.out.println();
            System.out.printf("lo : %d, hi : %d\n",lo, hi);

            /*for (char c : textArray) {
                if (c == EMPTY) continue;
                System.out.print(c);
            }
            System.out.println();*/
        }
        return textArray;
    }
}


















