// 10809번 알파벳 찾기
// a~z 까지 처음 나오는 게 몇변째인지, 없으면 -1 출력

/*
필요정보
* a~z 아스키코드 97~122
 */

import java.io.*;
import java.util.Arrays;

public class Q10809 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String S = br.readLine();
        char[] arr = S.toCharArray();
        int[] orderOfAlphabet = new int[26];
        int index;
        Arrays.fill(orderOfAlphabet, -1);
        for (int i=0;i<arr.length;i++) {
            index = (int)arr[i] - 97;
            if (orderOfAlphabet[index]==-1) orderOfAlphabet[index]=i;
        }
        for (int num : orderOfAlphabet) bw.write(num+" ");
        bw.flush();
        bw.close();
    }
}






