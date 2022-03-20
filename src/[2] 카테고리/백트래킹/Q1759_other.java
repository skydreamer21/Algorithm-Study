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


import java.io.*;
import java.util.*;

public class Q1759_other{
    public static char[] alphabet;
    public static char[] result;
    public static boolean[] check;
    public static int L,C;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabet = new char[C];
        result = new char[L];
        check = new boolean[C];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<C;i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
        code(0,0,0,0);
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void code(int vowel, int consonant, int depth,int cur) {
        if(depth==L) {
            if(vowel>0 && consonant>1) {
                for(int i=0;i<L;i++)
                    sb.append(result[i] + "");
                sb.append("\n");
            }
            return;
        }
        for(int i=cur;i<C;i++) {
            if(!check[i]) {
                check[i] = true;
                char temp = alphabet[i];
                result[depth] = temp;
                if(temp=='a' || temp =='e' || temp=='i' || temp=='o' || temp=='u')
                    code(vowel+1, consonant, depth+1, i+1);
                else
                    code(vowel,consonant+1,depth+1,i+1);
                check[i] = false;
            }
        }

    }
}
