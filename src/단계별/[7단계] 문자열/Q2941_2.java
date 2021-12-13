// 2941번 크로아티아 알파벳
/*
<문제 정보>
 1. 주어진 문자열이 몇개의 크로아티아 알파벳으로 이루어져있는지 출력
 2. 크로아티아 알파벳 특수 표시 : c=, c-, dz=, d-, lj, nj, s=, z=
 */

/*
<프로그램 진행>
 1.  특수 알파벳 배열만든뒤 contain이용해서 replace
 */

/*
<필요 함수>
 */

import java.io.*;

public class Q2941_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String[] croaticChar = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String word = br.readLine();
        String word_for_count = word;
        for (String croatic : croaticChar) {
            word_for_count = word_for_count.replace(croatic, "A");
        }
        int num = word_for_count.length();
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }
}






