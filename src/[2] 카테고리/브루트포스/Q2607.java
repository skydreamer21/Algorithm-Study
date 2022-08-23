// 2607번 비슷한 단어 (S3)
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

public class Q2607 {
    static int N;
    static int[] numOfChars = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        char[] mainWord = br.readLine().toCharArray();
        String[] words = new String[N - 1];
        for (int i = 0; i < N - 1; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < mainWord.length; i++) {
            int charIdx = mainWord[i] - 'A';
            numOfChars[charIdx]++;
        }

        int numOfSimilar = 0;
        for (int i = 0; i < N - 1; i++) {
            if (isSimilar(words[i])) numOfSimilar++;
        }

        sb.append(numOfSimilar);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isSimilar(String wordStr) {
        char[] word = wordStr.toCharArray();
        int[] mainWord = new int[26];
        System.arraycopy(numOfChars, 0, mainWord, 0, 26);
        for (int i = 0; i < word.length; i++) {
            int charIdx = word[i] - 'A';
            mainWord[charIdx]--;
        }

        /*System.out.printf("word : %s\n", wordStr);
        for (int i = 0; i < 26; i++) {
            System.out.printf("%d ", mainWord[i]);
        }
        System.out.println();*/

        boolean numOfAdd = false;
        boolean numOfSub = false;
        for (int i = 0; i < 26; i++) {
            if (mainWord[i] == 0 ) continue;
            if (Math.abs(mainWord[i]) != 1)
                return false;
            if (mainWord[i] == 1) {
                if (numOfAdd)
                    return false;
                numOfAdd = true;
            } else {
                if (numOfSub)
                    return false;
                numOfSub = true;
            }
        }
        return true;
    }
}
