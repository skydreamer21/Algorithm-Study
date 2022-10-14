import java.io.*;
import java.util.Arrays;

public class Q9252_2{
    static Integer[][] dp;
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
        Arrays.fill(dp[0],0);
        for (int i=1;i<=len1;i++) dp[i][0]=0;

        int ans = solve(len1,len2);
        bw.write(String.valueOf(ans));
        bw.newLine();

        int x = len1;
        int y = len2;
        int idx = ans-1;
        while(idx>=0) {
            if (S1.charAt(x-1)==S2.charAt(y-1)) {
                sb.append(S1.charAt(x-1));
                x--;
                y--;
                idx--;
            }
            else if (dp[x][y].equals(dp[x-1][y])) x--;
            else if (dp[x][y].equals(dp[x][y-1])) y--;
        }
        sb.reverse();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int x, int y) {
        if(dp[x][y]==null){
            if(S1.charAt(x-1)==S2.charAt(y-1)) dp[x][y] = solve(x-1,y-1)+1;
            else dp[x][y]=Math.max(solve(x-1,y),solve(x,y-1));
        }
        return dp[x][y];
    }
}

