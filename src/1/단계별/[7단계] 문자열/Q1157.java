// 1157번 단어공부
// 가장 많이 사용된 알파벳 대문자로 출력, 단 여러개 있으면 ?

/*
필요함수
(* a~z 아스키코드 97~122)
(* A~Z 아스키코드 65~90)
1. 단어를 받아 a~z까지 개수를 담은 배열을 반환
2. 배열에서 max값 찾기
3. 같은 max가 있는지 검사하고 알맞은 문자 내보내기
---> 2&3번을 하나의 함수로 합칠 수 있음!
 */

import java.io.*;
import java.util.Arrays;

public class Q1157 {
    public static int[] wordToAlphabetNum(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        String str = s.toLowerCase();
        char c;
        int index;
        for(int i=0;i<s.length();i++) {
            c=str.charAt(i);
            index=(int)c - 97;
            arr[index]++;
        }
        return arr;
    }

    public static int findMax(int[] arr) {
        int max=arr[0];
        for (int num : arr) {
            if(num>max) max = num;
        }
        return max;
    }

    public static char getMaxAlphabet(int[] arr) {
        int max = findMax(arr);
        int cnt=0;
        int alphabet;
        char MaxAlphabet='0';
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==max) {
                alphabet=i+65;
                MaxAlphabet = (char)alphabet ;
                cnt++;
                if(cnt>1) {
                    MaxAlphabet='?';
                    break;
                }
            }
        }
        return MaxAlphabet;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String word = br.readLine();
        int[] alphabetNum = wordToAlphabetNum(word);
        char MaxAlphabet = getMaxAlphabet(alphabetNum);
        bw.write(String.valueOf(MaxAlphabet));
        bw.flush();
        bw.close();
    }
}






