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

// 분할정복 풀이도 있음


import java.io.*;
import java.util.StringTokenizer;


public class Q2263_more {
    static int[][] tree;
    static int[] InOrder;
    static int[] PostOrder;
    static int[] stack;
    static int end;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        InOrder = new int[N+1];
        PostOrder = new int[N+1];
        tree = new int[N+1][2];
        st = new StringTokenizer(br.readLine());
        int tmp;
        for (int i=1;i<=N;i++) {
            tmp = Integer.parseInt(st.nextToken());
            InOrder[tmp] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) PostOrder[i] = Integer.parseInt(st.nextToken());

        // stack 만들기 : stack에는 PostOrder의 값이 들어감
        stack = new int[N+1];
        stack[1] = PostOrder[N];
        end = 1; // endPoint

        // PostOrder 요소의 맨 뒤에부터 처음까지 반복 진행
      /*
        1. 요소가 Stack에서 어디에 들어갈지 찾는다.
        2. 해당 index에 넣고 end 변경
        3. end가 +1 이 됐다면 마지막의 right에 들어감
        4. end가 앞으로 변경됐다면 마지막으로 제거된 값의 left에 들어감
      */
        int idx;

        for (int i=N-1;i>=1;i--) {
            idx = BS_upperBound(PostOrder[i]);
            // System.out.printf("value : %d, InOrder_idx : %d\n",PostOrder[i],InOrder[PostOrder[i]]);
            //System.out.printf("goto : %d, end : %d\n",idx,end);
            if (idx==end+1) {
                end = idx;
                stack[end]=PostOrder[i];
                tree[stack[end-1]][1]=stack[end]; // 오른쪽 자식 설정
            }
            else if (idx<=end) {
                tree[stack[idx]][0] = PostOrder[i]; // 왼쪽 자식 설정
                end = idx;
                stack[end] = PostOrder[i];
            }
            // System.out.printf("stack status : ");
            // for (int j=1;j<=N;j++) {
            //   System.out.printf("%d(%d) ",stack[j],InOrder[stack[j]]);
            //   if (j==end) break;
            // }
            // System.out.println("\n");

        }

        // 여기까지 트리가 완성이 되었으니 마지막으로 PreOrder 출력
        // tree 출력
        // for (int i=1;i<=N;i++) {
        //   System.out.printf("%d : ",i);
        //   System.out.println(Arrays.toString(tree[i]));
        // }
        PreOrder(PostOrder[N]);








        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BS_upperBound (int key) {
        // key : 정점값이 들어와서 stack의 어디에 들어갈지 BS_upperBound로 찾아야함
        // 정렬되어 있는 요소 : stack의 PostOrder의 InOrder index들이 정렬되어 있는 상태
        // mid의 InOrder index가 들어가야할 자리를 찾아야함 -> key의 InOrder index와 비교

        int lo=1; // stack의 index
        int hi=end+1;
        int mid;

        while(lo<hi) {
            mid = (lo+hi)/2;
            if (InOrder[key]>=InOrder[stack[mid]]) lo=mid+1;
            else hi=mid;
        }

        return lo;
    }

    public static void PreOrder(int n) {
        sb.append(n).append(" ");
        for (int child : tree[n]) {
            if (child!=0) PreOrder(child);
        }
    }
}
