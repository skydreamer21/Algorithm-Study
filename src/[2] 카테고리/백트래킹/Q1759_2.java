// 1759번 암호만들기 (G5) [backtracking]
/*
<문제 정보>
 1. 암호
    - 서로 다른 L개의 알파벳 소문자
    - 최소 한 개의 모음, 최소 두개의 자음으로 구성
    - 증가하는 알파벳 순
    - 사용한 문자의 종류 C가지

<변수 범위>
 1. 2초 / 128MB
 2. 3<=L<=C<=15

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 다시 짜보자...

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;



public class Q1759_2 {
    static int L,C;
    static char[] chars;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // C개 중에 L개를 규칙에 맞게
        chars=br.readLine().replace(" ","").toCharArray();
        Arrays.sort(chars);
        isUsed = new boolean[chars.length];
        dfs(0,0,0,0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (int depth, int idx, int consonant, int vowel) {
        if (depth==L) {
            if (consonant>=2 && vowel>=1) {
                for(int i=0;i<C;i++) {
                    if(isUsed[i]) sb.append(chars[i]);
                }
                sb.append("\n");
            }
            return;
        }
        if(idx==C) return;
        for (int i=idx;i<C;i++) {
            isUsed[i]=true;
            if(chars[i]=='a' || chars[i]=='e' || chars[i]=='i' || chars[i]=='o' || chars[i]=='u') {
                dfs (depth+1,i+1,consonant, vowel+1);
            }
            else dfs (depth+1,i+1,consonant+1, vowel);
            isUsed[i]=false;
        }
    }


}


























