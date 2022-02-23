// 9252번 LCS2
/*
<문제 정보>
 1. 첫째줄에 LCS 길이, 둘째줄에 LCS 출력
 2. LCS 길이가 0 이면 둘째줄 출력하지 않음

<변수 범위>
 1. 1초 / 256MB
 2. 문자열은 알파벳 대문자, 최대 1000글자

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.Arrays;

public class Q9252 {
    static Integer[][] dp;
    static Pair[][] path;
    static String S1;
    static String S2;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        S1 = br.readLine();
        S2 = br.readLine();
        int len1 = S1.length();
        int len2 = S2.length();
        dp = new Integer[len1+1][len2+1];
        path = new Pair[len1][len2];
        Arrays.fill(dp[0],0);
        for (int i=1;i<=len1;i++) dp[i][0]=0;

        int ans = solve(len1,len2);

        //for (int i=0;i<=len1;i++) System.out.println(Arrays.toString(dp[i]));
/*
        System.out.println();
        for (int i=0;i<len1;i++) {
            for (int j=0;j<len2;j++) {
                if(path[i][j]==null) System.out.print("null ");
                else path[i][j].print();
            }
            System.out.println();
        }
        System.out.println();
 */

        //System.out.printf("path[4][2] : (%d,%d)\n",path[4][2].x,path[4][2].y);

        char[] LCS = new char[ans];
        Pair now = new Pair(len1,len2);
        int idx = ans-1;
        while(idx>=0) {
            //System.out.printf("x : %d, y : %d, idx : %d\n",now.x,now.y,idx);
            if (S1.charAt(now.x-1)==S2.charAt(now.y-1)) LCS[idx--]=S1.charAt(now.x-1);
            if(idx>=0) now = new Pair(path[now.x-1][now.y-1].x,path[now.x-1][now.y-1].y);
        }

        sb.append(ans).append("\n");
        for (int i=0;i<ans;i++) sb.append(LCS[i]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int x, int y) {
        if(dp[x][y]==null){
            if(S1.charAt(x-1)==S2.charAt(y-1)) {
                dp[x][y] = solve(x-1,y-1)+1;
                path[x-1][y-1] = new Pair(x-1,y-1);
            }
            else {
                if(solve(x-1,y)>=solve(x,y-1)) {
                    dp[x][y]=solve(x-1,y);
                    path[x-1][y-1] = new Pair(x-1,y);
                }
                else {
                    dp[x][y]=solve(x,y-1);
                    path[x-1][y-1] = new Pair(x,y-1);
                }
            }
        }
        return dp[x][y];
    }
}


