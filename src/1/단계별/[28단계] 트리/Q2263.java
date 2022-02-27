// 2263번 트리의 순회
/*
<문제 정보>
 1. 인오더, 포스트 오더가 있을 때, 프리오더 구하기

<변수 범위>
 1. 5초 / 128MB
 2. 이진 트리 정점 개수 1<=n<=100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;


public class Q2263 {
    static int[][] tree;
    static int[] InOrder;
    static int[] PostOrder;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        InOrder = new int[N+1];
        PostOrder = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int tmp;
        for (int i=1;i<=N;i++) {
            tmp = Integer.parseInt(st.nextToken());
            InOrder[tmp] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) PostOrder[i] = Integer.parseInt(st.nextToken());






        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class BS_stack {
    int[] stack;
    int end;

    public BS_stack (int size) {
        stack = new int[size+1];
        end = 0;
    }
    public int getSubData (int n) {
        return //InOrder data를 가져와야함함
    }

    public void push int n) {
        //BS_upperBound
        int lo = 0;
        int hi = end;
        int mid;

        while(lo<hi) {
            mid=(lo+hi)/2;
            if()
        }
    }
}































