// 1062번 가르침 (G4) [백트래킹 & 비트마스킹]
/*
<문제 정보>
 1. 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지
 2. N : 단어의 개수
 3. 단어는 항상 anta 로 시작해서 tica로 끝난다.(기본 5개 a, c, i, n, t)

<변수 범위>
 1. 1초 / 128MB
 2. N 50 이하의 자연수
 3. K 26 이하의 자연수 또는 0
 4. 단어 길이 8이상 15 이하
 5. 단어 중복 X

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Arrays;

public class Q1062 {
    static int N, K;
    static int status = 0;
    static String[] words;
    static int maxReadableWord = 0;
    static HashSet<Integer> learnedIdx = new HashSet<>(Arrays.asList(0, 2, 8, 13 ,19));

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if ( K < 5 ) {
            System.out.println("0");
            return;
        }
        words = new String[N];
        for (int i=0; i<N; i++) words[i] = br.readLine();

        for (int idx : learnedIdx) status = edit(status, idx, true);

        // ******************** 메인 로직 ********************
        dfs(0, 1);


        // ******************** 정답 출력 ********************
        sb.append(maxReadableWord);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int startIdx) { // startIdx 건드리기
//        System.out.printf("[IN] depth : %d\n",depth);
//        printStatus(status);
        if (depth == K-5) {
            int numOfReadableWord = 0;
            for (String word : words) {
                if (canRead(word)) numOfReadableWord++;
            }
            maxReadableWord = Math.max(maxReadableWord, numOfReadableWord);
            return;
        }

        for (int i=startIdx; i<26; i++) {
            if (learnedIdx.contains(i)) continue;
            status = edit(status, i, true);
            dfs(depth+1, i+1);
            status = edit(status, i, false);
        }
    }

    public static boolean canRead(String word) {
        int wordStatus = wordToStatus(word);
        return (status & wordStatus) == wordStatus;
    }

    public static int wordToStatus(String word) {
        int len = word.length();
        int wordStatus = 0;
        for (int i=0; i<len; i++) {
            wordStatus = edit(wordStatus, word.charAt(i)-'a', true);
        }
        return wordStatus;
    }

    public static int edit(int status, int idx, boolean mode) {
        int v = 1 << idx;
        if (mode) status |= v;
        else status &= ~v;
        return status;
    }

    public static int get(int status, int idx) {
        return (status >> idx) & 1;
    }

    public static void printStatus(int status) {
        System.out.println("-- status --");
        for (int i=0; i<26; i++) {
            System.out.printf("%d ", get(status, i));
        }
        System.out.println();
    }
}
