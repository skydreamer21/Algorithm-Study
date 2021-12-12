// 5622번 다이얼
/*
<문제 정보>
 숫자에 3개 이상의 영어대문자와 대응(다이얼)
 영어단어가 주어지면 그에 해당하는 번호를 걸때 걸리는 시간
 1은 2초, 하나씩 커질때 마다 1초씩 추가
 */

/*
<필요 함수>
1. 영어대문자를 넣으면 대응하는 숫자 return
2. char배열을 넣으면 대응하는 숫자배열 return
3. 숫자배열 넣으면 걸리는 시간 return
 */

import java.io.*;

public class Q5622 {
    public static int charToDialnum(char c) {
        int val = c - 'A';
        int dialnum;
        if (val<18) dialnum = val/3 + 2;
        else if (val==18) dialnum = 7;
        else if (val<22) dialnum = 8;
        else dialnum = 9;
        return dialnum;
    }

    public static int[] wordToDial(char[] arr) {
        int[] dial = new int[arr.length];
        for (int i=0;i<dial.length;i++) {
            dial[i] = charToDialnum(arr[i]);
        }
        return dial;
    }

    public static int getTime(int[] arr) {
        int sum=0;
        int time;
        for (int num : arr) sum+=num;
        time = sum + arr.length;
        return time;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String word = br.readLine();
        char[] word_char = word.toCharArray();
        int[] Dialnum = wordToDial(word_char);
        int time = getTime(Dialnum);
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }
}






