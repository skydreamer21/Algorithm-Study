import java.util.stream.Stream;

class 큰수만들기 {
    static int N;
    static int[] code;
    static int[] tree;

    static final int MINUS_INF = Integer.MIN_VALUE;

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        N = number.length();
        code = Stream.of(number.split("")).mapToInt(Integer::parseInt).toArray();
        reverseArr();

        // for (int i=0;i<N;i++) {
        //     System.out.printf("%d ",code[i]);
        // }
        // System.out.println("\n");

        int treeSize = getTreeSize();
        tree = new int[treeSize];
        init(1,0,N-1);

        // for (int i=0;i<treeSize;i++) {
        //     System.out.printf("%d ",tree[i]);
        // }
        // System.out.println("\n");

        int endIdx = N-1;
        int remainNum = N - k;
        int idx;
        for (int i=remainNum-1;i>=0;i--) {

            idx = query(1,0,N-1,i,endIdx);
            // System.out.printf("i:%d, endIdx:%d, idx:%d\n",i,endIdx,idx);
            sb.append(code[idx]);
            endIdx = idx-1;
        }

        String answer = sb.toString();
        return answer;
    }

    public static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return;
        }

        int mid = (start+end)/2;
        init(2*node, start, mid);
        init(2*node+1, mid+1, end);
        int idx1 = tree[2*node];
        int idx2 = tree[2*node+1];
        if (code[idx1] > code[idx2]) tree[node] = idx1;
        else tree[node] = idx2;
    }

    public static int query (int node, int start, int end, int left, int right) {

        // 1. left~right 범위의 수가 없을 때
        if (left>end || right<start) return MINUS_INF;

        // 2. left~right 범위의 수만 있을 때
        if (start>=left && end<=right) return tree[node];

        int mid = (start + end)/2;
        int idx1 = query(2*node, start, mid, left,right);
        int idx2 = query(2*node+1, mid+1, end, left, right);
        if (idx1 == MINUS_INF) return idx2;
        if (idx2 == MINUS_INF) return idx1;
        if (code[idx1] > code[idx2]) return idx1;
        else return idx2;
    }

    public static void reverseArr() {
        int[] tmp = new int[N];
        for (int i=0;i<N;i++) tmp[i] = code[N-1-i];
        System.arraycopy(tmp,0,code,0,N);
    }

    public static int getTreeSize() {
        int h = (int) Math.ceil(Math.log(N)/Math.log(2));
        return 1<<(h+1);
    }
}


/*
import java.util.Stack;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}*/
