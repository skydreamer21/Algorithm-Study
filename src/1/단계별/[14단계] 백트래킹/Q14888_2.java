// 14888번 연산자 끼워넣기

/*
<문제 정보>
 1. N개의 수 사이에 N-1개의 연산자를 끼워넣아 나올 수 있는 결과중 최대값과 최솟값을 출력
 2. N / N개의 수 / + - x 나누기 개수
 3. 연산 우선순위 무시하고 순서대로 계산
 4. 2<=N<=11 / 각각의 숫자는 1이상 100이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q14888_2 {
    static int[] numList;
    static int[] operators = new int[4];
    static int max;
    static int min;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) numList[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++) operators[i] = Integer.parseInt(st.nextToken());
        //System.out.println("numList : "+Arrays.toString(numList));
        //System.out.println("operators : "+Arrays.toString(operators));
        max = -1000000001;
        min = 1000000001;
        find(numList[0],1);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void find(int temp, int depth) {
        if (depth==N) {
            if (temp>max) max = temp;
            if (temp<min) min = temp;
            return;
        }

        for (int i=0;i<4;i++) {
            if(operators[i]>0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        find(temp+numList[depth],depth+1);
                        break;

                    case 1 :
                        find(temp-numList[depth],depth+1);
                        break;

                    case 2 :
                        find(temp*numList[depth],depth+1);
                        break;

                    case 3 :
                        find(temp/numList[depth],depth+1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}