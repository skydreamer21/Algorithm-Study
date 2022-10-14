// 2252번 줄 세우기 (G3) (실패)
/*
<문제 정보>
 1. 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램 작성

<변수 범위>
 1. 2초 / 128MB
 2. 학생 수 1<=N<=32,000
 3. 키를 비교한 횟수 1<=M<=100,000
 4. 학생들 번호는 1~N

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

/*
    1. 학생들의 키를 비교한 결과를 이용하여 정렬의 기준이 되는 Table을 만든다.
    2. Table 을 이용해 compareTo 함수로 비교를 할 수 있도록 한다. (X)
        -> Compare에서 이 요소들만 돌아서 순서를 매겨주는 것이 아님.
    3. PriorityQueue 를 활용하여 한명씩 꺼내며 줄을 세운다.
        -> 힙의 갱신 과정을 생각해봤을 때, 우선순위를 모르는 요소들이 있기 때문에 갱신이 제대로 일어나지 않을 수 있음

    방법 다시

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2252 {
    static int N, M;
    static int[][] compareTable;

    static final int CORRECT_ORDER = -1;
    static final int REVERSE_ORDER = 1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        compareTable = new int[N+1][N+1];

        // A -> B 순서라면 compareTable[A][B]=-1, compareTable[B][A]=1
        int firstStudent_in, secondStudent_in;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            firstStudent_in = Integer.parseInt(st.nextToken());
            secondStudent_in = Integer.parseInt(st.nextToken());
            compareTable[firstStudent_in][secondStudent_in] = CORRECT_ORDER;
            compareTable[secondStudent_in][firstStudent_in] = REVERSE_ORDER;
        }

        // ******************** 메인 로직 ********************

        // 1. 1~N이 들어있는 배열 생성
        Integer[] line = new Integer[N];
        for (int i=0;i<N;i++) line[i] = i+1;

        // 2. compareTable 을 이용하여 line 정렬
        Arrays.sort(line, (a,b) -> {
            System.out.printf("a : %d, b : %d, compareTable : %d\n",a,b,compareTable[a][b]);
            return compareTable[a][b];
        });

        // ******************** 정답 출력 ********************

        // 정렬된 배열에서 순서대로 출력
        for (int student : line) sb.append(student).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}












