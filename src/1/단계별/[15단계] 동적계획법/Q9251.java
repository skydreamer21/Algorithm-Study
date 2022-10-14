// 9251번 LCS

/*
<문제 정보>
 1. LCS : 최장 공통 부분 수열
 -> 두 수열이 있을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것
 2. 주어진 두 문자열의 LCS 길이를 출력

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// <주의> 왜 공통부분이 항상 있다고만 생각했지.... 없을수도 있는데...

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q9251 {
    static int[][] common;
    static int[] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        String B = br.readLine();
        int idx=find_coorNum(A, B);
        //System.out.println(idx);
        int max=0;
        if(idx>0) {
            common = new int[idx][2];
            memo = new int[idx];
            memo[0]=1;
            find_coor(A,B);
            //printArr();
            for (int i=0;i<memo.length;i++) {
                //System.out.printf("%d번째 공통\n",i);
                if (LIS_coor(i)>max) max = memo[i];
            }
            //bw.write(Arrays.toString(memo));
            //bw.newLine();
            bw.write(String.valueOf(max));
        }
        else if (idx==0) bw.write(String.valueOf(0));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int LIS_coor (int n) {
        if (memo[n]==0) {
            for (int i=0;i<n;i++) {
                if (common[n][0]>common[i][0] && common[n][1]>common[i][1]) {
                    //System.out.println(i);
                    memo[n] = Math.max(memo[n],LIS_coor(i)+1);
                    //System.out.printf("memo[%d] = %d\n",n,memo[n]);
                }
            }
            if (memo[n]==0) memo[n]=1;
        }
        //System.out.printf("return : memo[%d] = %d\n",n,memo[n]);
        return memo[n];
    }

    public static int find_coorNum (String A, String B) {
        int idx=0;
        for (int i=0;i<A.length();i++) {
            for (int j=0;j<B.length();j++) {
                if (A.charAt(i)==B.charAt(j)) {
                    idx++;
                }
            }
        }
        return idx;
    }

    public static void find_coor (String A, String B) {
        int idx=0;
        for (int i=0;i<A.length();i++) {
            for (int j=0;j<B.length();j++) {
                if (A.charAt(i)==B.charAt(j)) {
                    common[idx][0]=i;
                    common[idx][1]=j;
                    idx++;
                }
            }
        }
    }

    public static void printArr() {
        for(int i=0;i<common.length;i++) System.out.println(Arrays.toString(common[i]));
        System.out.println();
    }
}