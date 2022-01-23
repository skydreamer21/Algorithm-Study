// 10844번 쉬운 계단 수

/*
<문제 정보>
 1. 계단 수 : 인접한 모든 자리의 차이가 1인 수
 2. N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보기
 3. 1<=N<=100 자연수
 4. 정답을 1,000,000,000 으로 나눈 나머지를 출력
  - int 최댓값이 2,147,483,647이므로 int 사용 가능

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.Arrays;

public class Q10844 {
    static int[][] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1][10];
        Arrays.fill(memo[1],1);
        bw.write(String.valueOf(find_ans(N)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int row, int col) {
        if (memo[row][col]==0) {
            if (col==0) memo[row][col] = find(row-1,1)%1000000000;
            else if (col==9) memo[row][col] = find(row-1,8)%1000000000;
            else memo[row][col]=(find(row-1,col-1)+find(row-1,col+1))%1000000000;
        }
        return memo[row][col];
    }

    public static int find_ans (int n) {
        int sum=0;
        for (int i=1;i<=9;i++) {
            sum+=find(n,i);
            sum%=1000000000;
        }
        return sum;
    }
}