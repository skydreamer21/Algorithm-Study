// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class demo_test {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        sb.append(sol(A));



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int sol(int[] A) {
        Arrays.sort(A);
        int j=0;
        for (int i=1;i<=A.length;i++) {
            while(j<A.length && A[j]<i) j++;
            if (j==A.length) return A[A.length-1]<=0 ? 1 : A[A.length-1]+1;
//            System.out.printf("%d\n",A[j]);
            if (A[j]!=i) return i;
        }
        return A[A.length-1]<=0 ? 1 : A[A.length-1]+1;
    }

}
