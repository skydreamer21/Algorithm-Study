// 2941번 크로아티아 알파벳
/*
<문제 정보>
 1. 주어진 문자열이 몇개의 크로아티아 알파벳으로 이루어져있는지 출력
 2. 크로아티아 알파벳 특수 표시 : c=, c-, dz=, d-, lj, nj, s=, z=
 */

/*
<프로그램 진행>
 1. 특수문자 시작 알파벳 : c,d,l,n,s,z 6개
 2. 시작 별로 switch 문으로 진행

 # 특수 알파벳 배열만든뒤 contain이용해서 replace 하면 코드 길이 다운 (제출번호 36262183)
 */

/*
<필요 함수>
1. String 넣으면 크로아티아 알파벳 개수 출력
 */

import java.io.*;

public class Q2941 {
    public static int getCroaticCharNum(String word) {
        int cnt=0;
        for(int i=0;i<word.length();i++) {
            switch (word.charAt(i)) {
                case 'c':
                    cnt++;
                    if (i==word.length()-1) break;
                    else if (word.charAt(i+1)=='=' || word.charAt(i+1)=='-') i++;
                    break;
                case 'd':
                    cnt++;
                    if (i==word.length()-1) break;
                    else if (word.charAt(i+1)=='-') {
                        i++;
                    }
                    else if (word.charAt(i+1)=='z') {
                        if (i==word.length()-2) {
                            cnt++;
                            i++;
                        }
                        else if (word.charAt(i+2)=='=') {
                            i+=2;
                        }
                        else {
                            cnt++;
                            i++;
                        }
                    }
                    break;
                case 'l' : case 'n':
                    cnt++;
                    if (i==word.length()-1) break;
                    else if (word.charAt(i+1)=='j') i++;
                    break;
                case 's' : case 'z':
                    cnt++;
                    if (i==word.length()-1) break;
                    else if (word.charAt(i+1)=='=') i++;
                    break;
                default:
                    cnt++;
            }
        }
        return cnt;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String croaticWord = br.readLine();
        int num = getCroaticCharNum(croaticWord);
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }
}

    /*
    public static int getCroaticCharNum(String word) {
        int cnt=0;
        int step=0;
        int dval=0;
        for(int i=0;i<word.length();i++) {
            switch (step) {
                case 0:
                    dval=0;
                    switch (word.charAt(i)) {
                        case 'c': case 'd': case 'l': case 'n': case 's': case 'z':
                            cnt++;
                            step++;
                            if (word.charAt(i)=='d') dval=1;
                            break;
                        default:
                            cnt++;
                    }
                    break;
                case 1:
                    switch (word.charAt(i)) {
                        case '=': case '-': case 'j':
                            step=0;
                            break;
                        case 'z':
                            if (dval==1) step++;
                            else {
                                cnt++;
                                dval=0;
                            }
                            break;
                        case 'c': case 'd': case 'l': case 'n': case 's':
                            cnt++;
                            if (word.charAt(i)!='d') dval=0;
                            break;
                        default:
                            cnt++;
                            step=0;
                    }
                    break;
                case 2:
                    switch(word.charAt(i)) {
                        case '=':
                            step=0;
                            break;
                        case 'c': case 'd': case 'l': case 'n': case 's': case 'z':
                            cnt+=2;
                            step--;
                            if (word.charAt(i)!='d') dval=0;
                            break;
                        default:
                            cnt+=2;
                            step=0;
                    }
            }
        }
        return cnt;
    }
*/





