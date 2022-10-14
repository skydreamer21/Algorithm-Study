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

// PriorityQueue, UnionFind

package Programmers.level2;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

class 수식_최대화 {
    static int N;
    static int[] nums;
    static int[] operatorList;
    static int[] parent;
    static int[] operatorOrder = new int[3];
    static boolean[] operatorVisited = new boolean[3];

    static long maxValue = 0; // 0이상의 값만 나오기 때문

    static final int SUM = 0;
    static final int SUB = 1;
    static final int MUL = 2;

    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression,"+-*");
        N = st.countTokens();
        nums = new int[N];
        operatorList = new int[N-1];
        parent = new int[N];
        for (int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
        int idx=0;
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) continue;
            switch(c) {
                case '+':
                    operatorList[idx++] = SUM;
                    break;
                case '-':
                    operatorList[idx++] = SUB;
                    break;
                case '*':
                    operatorList[idx++] = MUL;
            }
        }

        // System.out.println("numList");
        // for(int i=0;i<N;i++) System.out.printf("%d ",nums[i]);
        // System.out.println("\noperatorList");
        // for (int i=0;i<N-1;i++) System.out.printf("%c ", operatorList[i]==0 ? '+' : (operatorList[i]==1 ? '-' : '*'));
        // System.out.println();

        getMaxValue(0);

        return maxValue;
    }

    public static void getMaxValue(int depth) {
        if (depth == 3) {
            // 구한 우선순위대로 heap에 넣고 계산
            // 이 과정을 진행할때마다 heap과 parent는 초기화 시켜주어야 함
            // System.out.println("연산자 우선순위");
            int[] orderToOperator = new int[3];
            for (int i=0;i<3;i++) orderToOperator[operatorOrder[i]] = i;
            for (int i=0;i<3;i++) {
                // System.out.printf("%c : %d순위\n",i==0 ? '+' : (i==1 ? '-' : '*'), operatorOrder[i]+1);
            }
            parentInit();
            calculate(orderToOperator);
            return;
        }

        // operatorOrder의 index가 연산이고 값이 우선순위
        for (int i=0;i<3;i++) {
            if(operatorVisited[i]) continue;
            operatorVisited[i] = true;
            operatorOrder[depth] = i;
            getMaxValue(depth+1);
            operatorVisited[i] = false;
        }
    }

    public static void calculate(int[] orderToOperator) {
        PriorityQueue<Operator> pq = new PriorityQueue<>();
        for (int i=0;i<N-1;i++) pq.add(new Operator(operatorOrder[operatorList[i]],i,i,i+1));
        long[] copyNums = new long[N];
        for (int i=0;i<N;i++) copyNums[i] = nums[i];
        // System.arraycopy(nums,0,copyNums,0,N);  int[] -> long[] copy는 안됨


        /*
        연산은 연산자의 개수만큼 진행함
        1. pq에서 연산을 하나 뺀다.
        2. 연산에 포함된 번호 idx를 그룹화
        3. 연산을 진행하고 번호 idx의 root idx의 값을 바꿔준다.
            ** 이 때 연산을 진행할 값은 번호idx 의 root idx의 값으로 진행
        4. 연산자의 개수만큼 1~3 과정을 반복
        5. 마지막 값의 결과를 확인해 max값과 비교한다. (절댓값)
        주의사항 : 값이 long 범위로 나올 수 있기 때문에 처음부터 자료형을 long으로
        */
        Operator now;
        long tmp_res=0;
        long value1, value2;
        while (!pq.isEmpty()) {
            now = pq.poll();
            union(now.numIdx1, now.numIdx2);
            value1 = copyNums[now.numIdx1];
            value2 = copyNums[find(now.numIdx2)];
            // System.out.printf("v1 : %d, v2 : %d, 연산 : %c\n",value1, value2,
            // orderToOperator[now.operator]==0 ? '+' : (orderToOperator[now.operator]==1 ? '-' : '*'));
            switch(orderToOperator[now.operator]) {
                case SUM :
                    tmp_res = value1 + value2;
                    break;
                case SUB :
                    tmp_res = value1 - value2;
                    break;
                case MUL :
                    tmp_res = value1 * value2;
            }
            copyNums[find(now.numIdx2)] = tmp_res;
        }
        // System.out.printf("value : %d\n\n",Math.abs(copyNums[N-1]));
        maxValue = Math.max(maxValue, Math.abs(copyNums[N-1]));
    }

    public static void parentInit() {
        for (int i=0;i<N;i++) parent[i] = i;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        // index가 큰 쪽으로 함침
        if (a<b) parent[a] = b;
        else parent[b] = a;
    }
}


class Operator implements Comparable<Operator> {
    int operator, order;
    int numIdx1, numIdx2;
    // 이때 order은 operators의 index

    public Operator (int operator, int order, int numIdx1, int numIdx2) {
        this.operator = operator;
        this.order = order;
        this.numIdx1 = numIdx1;
        this.numIdx2 = numIdx2;
    }

    @Override
    public int compareTo(Operator o) {
        return this.operator == o.operator ? this.order - o.order : this.operator - o.operator;
    }
}

// class의 이름과 생성자 이름이 맞지 않으면
// error: invalid method declaration; return type required
// 이딴 에러가 뜰 수 있음

// generic 쓰는 곳에 error: cannot find symbol 이런 에러 떠도 위와 같은 오류
