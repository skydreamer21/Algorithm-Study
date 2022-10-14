// 2565번 전깃줄

/*
<문제 정보>
 1. 전깃줄의 개수와 전깃줄이 어떻게 연결되어 있는지 주어짐.
 2. 전깃줄이 서로 교차하지 않도록 제거해야할 전깃줄의 최소 갯수 출력
 3. 전깃줄 개수 N은 100이하 자연수
 4. 위치번호는 500 이하의 자연수, 한 위치에는 한개의 전깃줄만 연결

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Q2565 {
    static int[][] line;
    static int[] memo;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        line = new int[N+1][2];
        memo = new int[N+1];
        memo[1]=1;
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0]=Integer.parseInt(st.nextToken());
            line[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int max=0;
        for (int i=1;i<=N;i++) {
            if (find_LIS(i)>max) max = memo[i];
        }
        bw.write(String.valueOf(N-max));
        //bw.newLine();
        //bw.write(Arrays.toString(memo));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find_LIS (int n) {
        if (memo[n]==0 && n!=0) {
            for (int i=0;i<n;i++) {
                if (line[n][1]>line[i][1]) {
                    memo[n] = Math.max(memo[n],find_LIS(i));
                }
            }
            memo[n]++;
        }
        else if (n==0) return 0;
        return memo[n];
    }
/*
    public static void printArr() {
        for(int i=0;i<line.length;i++) System.out.println(Arrays.toString(line[i]));
        System.out.println();
    }
 */
}