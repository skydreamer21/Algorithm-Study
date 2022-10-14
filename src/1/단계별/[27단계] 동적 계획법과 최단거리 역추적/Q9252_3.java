import java.io.*;

public class Q9252_3 {
    static int[][] dp;
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
        dp = new int[len1+1][len2+1];

        int ans = solve(len1,len2);
        bw.write(String.valueOf(ans));
        bw.newLine();

        int x = len1;
        int y = len2;
        while(x!=0 && y!=0) {
            if (S1.charAt(x-1)==S2.charAt(y-1)) {
                sb.append(S1.charAt(x-1));
                x--;
                y--;
            }
            else if (dp[x][y]==dp[x-1][y]) x--;
            else if (dp[x][y]==dp[x][y-1]) y--;
        }
        sb.reverse();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int len1, int len2) {
        for (int i=1;i<=len1;i++) {
            for (int j=1;j<=len2;j++) {
                if(S1.charAt(i-1)==S2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
}
