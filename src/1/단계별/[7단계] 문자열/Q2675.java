// 2675번 문자열 반복
// 각문자당 R번씩 반복해서 새로운 문자열 생성

/*
필요함수
1. charArray 받아서 R번씩 반복해서 새로운 문자열 Return
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2675 {

    public static String newString(char[] arr, int R) {
        int length = arr.length;
        char[] newString = new char[R*length];
        for(int i=0;i<length;i++) {
            for (int j=0;j<R;j++) newString[R*i+j]=arr[i];
        }
        return String.valueOf(newString);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer tk;
        String Test;
        String P;
        char[] S;
        int R;
        for (int i=0;i<T;i++) {
            Test = br.readLine();
            tk=new StringTokenizer(Test);
            R = Integer.parseInt(tk.nextToken());
            S = tk.nextToken().toCharArray();
            P = newString(S,R);
            bw.write(P+"\n");
        }
        bw.flush();
        bw.close();
    }
}






