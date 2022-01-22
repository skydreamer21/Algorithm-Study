// 2579번 계단 오르기

/*
<문제 정보>
 1. 사용가능 연산
    - X가 3으로 나누어떨어지면 3으로 나눈다
    - X가 2로 나누어떨어지면 2로 나눈다
    - 1을 뺀다.
 2. 정수 N이 주어질 때 연산을 사용해서 1을 만드려고 할 때,
 연산의 최소 사용수 출력
 3. 1<=N<=10^6

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1463 {
    static int[] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        memo[1]=0;
        if(N>1) memo[2]=1;
        if(N<3) bw.write(String.valueOf(memo[N]));
        else bw.write(String.valueOf(find(N)));
        //System.out.println(Arrays.toString(memo));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find (int n) {
        if (memo[n]==0 && n!=0 && n!=1 && n!=2) {
            if (n%3==0) memo[n]=find(n/3)+1;
            else if (n%3==1) {
                if (n%2==1) memo[n]=find(n-1)+1;
                else memo[n]=Math.min(find(n/2)+1,find(n-1)+1);
            }
            else {
                if (n%2==1) memo[n]=Math.min(find(n-1)+1,find(n-2)+2);
                else memo[n]=memo[n]=Math.min(find(n/2)+1,find(n-2)+2);
            }
        }
        return memo[n];
    }
}