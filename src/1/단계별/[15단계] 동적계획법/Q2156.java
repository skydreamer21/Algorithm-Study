// 2156번 포도주 시식

/*
<문제 정보>
 1. 연속 3잔을 마실 수 없음
 2. 각 잔마다 들어 있는 양이 나와 있음
 3. N개 중에서 위와 같은 규칙을 적용해서 마실 때 마실 수 있는 최대 양 출력
 4. 마지막 포도주 안마셔도 괜찮음
 57. 1<=N<=10,000 / 포도주 양은 1000 이하의 음이 아닌 정수


<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2156 {
    static int[] glass;
    static int[] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        glass = new int[N+1];
        memo = new int[N+1];
        Arrays.fill(memo,-1);
        for (int i=1;i<=N;i++) glass[i]=Integer.parseInt(br.readLine());
        memo[1] = glass[1];
        if(N>1) memo[2] = glass[1]+glass[2];
        if (N<3) bw.write(String.valueOf(memo[N]));
        else bw.write(String.valueOf(find(N)));
        //System.out.println(Arrays.toString(memo));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find (int n) {
        if (memo[n]==-1 && n!=0) {
            if (n==3) memo[n] = Math.max(glass[2]+glass[3],
                                    Math.max(glass[1]+glass[3],glass[1]+glass[2]));
            else {
                memo[n] = Math.max(find(n-4)+glass[n-2]+glass[n-1],
                             Math.max(find(n-3)+glass[n-1]+glass[n],find(n-2)+glass[n]));
            }
        }
        else if (n==0) return 0;
        return memo[n];
    }


}