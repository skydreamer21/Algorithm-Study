// 1316번 그룹 단어 체커
/*
<문제 정보>
 1. 주어진 N개의 단어들 중에 그룹단어가 몇개 있는지 출력
 2. 그룹단어란 한 문자가 연속으로만 나온 단어 (cab(O), aba(X))
 */

/*
<프로그램 진행>
1. 소문자 char을 0~25 index로 변환
 */

/*
<필요 함수>
1. 소문자 char을 0~25 index로 변환
2. String 입력 받아 그룹단어인지 boolean 값 return
 */

import java.io.*;
import java.util.Arrays;

public class Q1316 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        int index;
        String word;
        int[] groupCharNum = new int[26];
        int cnt=0;
        char temp;
        for (int i=0;i<N;i++) {
            Arrays.fill(groupCharNum, 0);
            word = br.readLine();
            for (int j=0;j<word.length();j++) {
                temp = word.charAt(j);
                index=temp - 'a';
                if (j==0) groupCharNum[index]++;
                else if (temp==word.charAt(i-1)) continue;
                else groupCharNum[index]++;
                if (groupCharNum[index]>1) break;
                if (j==word.length()) cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}






