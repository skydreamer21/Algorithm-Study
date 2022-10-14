// 2104번 부분배열 고르기 (P5) [Segment Tree & Divide Conquer]
/*
<문제 정보>
 1. score(arr, i, j) = sum(arr, i ,j) * min(arr, i ,j)
 2. 주어진 배열에서 위의 점수의 최댓값 출력

<변수 범위>
 1. 2초 / 128MB
 2. 1 <= N <= 100,000
 3. 배열의 원소는 1,000,000 이하의 음이 아닌 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2104 {
    static int N;
    static int[] arr;
    static long[][] tree;

    static final int SUM = 0;
    static final int MIN = 1;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new long[2][getTreeSize(N)+1]; // root node는 index 1 부터 시작
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // ******************** 메인 로직 ********************
        // 1. 세그먼트 트리 만들기
        init(SUM, 1, 0, N-1);
        init(MIN, 1, 0, N-1);

        /*
        System.out.printf("SUM Tree\n");
        for (int i=0; i<tree[SUM].length; i++) {
            System.out.printf("%d ", tree[SUM][i]);
        }
        System.out.println();
        System.out.printf("MIN Tree\n");
        for (int i=0; i<tree[MIN].length; i++) {
            System.out.printf("%d ", tree[MIN][i]);
        }
        System.out.println();
         */

        long maxScore = getMaxScore(0, N-1);

        // ******************** 정답 출력 ********************
        sb.append(maxScore);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // description : 주어진 start ~ end 구간에서 Score의 최댓값을 구합니다.
    // 분할 정복을 사용, mid를 기준으로 왼쪽, 오른쪽을 탐색한 후 mid를 포함하는 구간 중 최댓값을 탐색해서 비교
    public static long getMaxScore(int start, int end) {
        if (start > end) return -1;
        if (start == end) return (long) arr[start] * arr[start];

        // 1. 전체 구간에 대한 Score
        long scoreForWholeRange = getScore(start, end);

        // 2. 왼쪽, 오른쪽 구간에 대한 maxScore
        int mid = (start + end) / 2;
        long maxScore = Math.max(getMaxScore(start, mid-1), getMaxScore(mid+1, end));
        maxScore = Math.max(maxScore, scoreForWholeRange);

        // 3. mid를 포함하는 구간에 대한 maxScore
        long midScore = getMaxScoreForRangeIncludingMid(start, end);
        maxScore = Math.max(maxScore, midScore);

        return maxScore;
    }

    public static long getMaxScoreForRangeIncludingMid (int start, int end) {
        int mid = (start + end) / 2;
        int left = mid - 1;
        int right = mid + 1;

        long maxScore = (long) arr[mid] * arr[mid];
        while ( left >= start && right <= end ) {
            if (arr[left] > arr[right]) {
                maxScore = Math.max(maxScore, getScore(left, right-1));
                left--;
            }
            else {
                maxScore = Math.max(maxScore, getScore(left + 1, right));
                right++;
            }
        }

        while ( left >= start ) {
            maxScore = Math.max(maxScore, getScore(left, right-1));
            left--;
        }

        while ( right <= end ) {
            maxScore = Math.max(maxScore, getScore(left + 1, right));
            right++;
        }

        return maxScore;
    }

    public static long getScore(int from, int to) {
        return query(SUM, 1, from, to, 0,N-1) * query(MIN, 1, from, to, 0,N-1);
    }

    public static int getTreeSize (int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        return 1 << (h+1);
    }

    // init : node 값을 정합니다.
    public static long init(int mode, int node, int start, int end) {
        if (start == end) {
            return tree[mode][node] = arr[start];
        }

        int mid = (start + end) / 2;

        if (mode == SUM) {
            return tree[mode][node] = init(mode,node*2, start, mid) + init(mode, node*2 + 1, mid + 1, end);
        }
        else { // mode == MIN
            return tree[mode][node] = Math.min(init(mode,node*2, start, mid),init(mode, node*2 + 1, mid + 1, end));
        }
    }

    // left ~ right (기준 구간) 는 고정,
    // query가 재귀로 불러올수록 start ~ end 구간이 짧아서 결국엔 left ~ right에 포함되거나 포함되지 않거나로 나뉘게 된다.
    // description : start ~ end (배열 전체) 구간에서 주어진 기준 구간에 대해 function 을 구해라.
    public static long query(int mode, int node, int left, int right, int start, int end) {
        // 1. start ~ end 기준 구간을 벗어난 경우
        if (left > end || right < start) {
            return mode == SUM ? 0 : INF;
        }

        // 2. start ~ end 가 기준 구간에 완전히 포함된 경우
        if (start >= left && end <= right) {
            return tree[mode][node];
        }

        // 3. start ~ end 가 1, 2의 경우가 아닐 때 (기준구간 보다 크거나, 걸쳐 있거나...)
        int mid = (start + end) / 2;
        if (mode == SUM) {
            return query(mode, node*2, left, right, start, mid) + query(mode, node*2 + 1, left, right, mid+1, end);
        }
        else { // mode == MIN
            return Math.min(query(mode, node*2, left, right, start, mid)
                            , query(mode, node*2 + 1, left, right, mid+1, end));
        }
    }
}
