// 2775번 부녀회장이 될테야

/*
<문제 정보>
 1. a층의 b호에 살려면 자신의 아래층(-> (a-1)층)의 1호부터 b호까지
 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
 2. 0층부터 있고 0층의 i호에는 i명이 산다.
 3. k층의 n호에는 몇 명 살고 있는지 출력

<프로그램 진행>
1. 2차원 int 배열 사용
2. k층 n호를 구하기 위해서는 k층 n-1호 와 k-1층 n호 사람들을 더하면 나옴
3. 1호 사람들은 항상 한명, 0층 사람들은 n호에 n명

<필요 함수>
1. 초기 배열 생성 -> 1호사람들, 0층 사람들
2. k층 n호 사람수 return
 */

import java.io.*;

public class Q2775_2 {
    public static int[][] initApart(int k, int n) {
        int[][] apart = new int[k+1][n];
        for (int i=0;i<=k;i++) apart[i][0]=1;
        for (int i=0;i<n;i++) apart[0][i]=i+1;
        return apart;
    }

    public static int getKNpeople(int[][] apart) {
        int k=apart.length;
        int n=apart[0].length;
        for (int i=1;i<k;i++) {
            for (int j=1;j<n;j++) {
                apart[i][j] = apart[i][j-1] + apart[i-1][j];
            }
        }
        return apart[k-1][n-1];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());
        int k;
        int n;
        int[][] apart;
        int KNpeople;
        for (int i=0;i<T;i++) {
            k=Integer.parseInt(br.readLine());
            n=Integer.parseInt(br.readLine());
            apart = initApart(k,n);
            KNpeople = getKNpeople(apart);
            bw.write(KNpeople+"\n");
        }
        bw.flush();
        bw.close();
    }
}






