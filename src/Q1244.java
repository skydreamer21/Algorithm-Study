// 1244번 스위치 켜고 끄기 (S3)
/*
<문제 정보>
 1. 스위치 변화
    - 남학생 : 자신이 받은 수의 배수 스위치를 바꾼다.
    - 여학생 : 자신이 받은 스위치를 기준으로 상태가 대칭인 최대 구간의 스위치 상태를 바꾼다.
 2. 모든 학생들이 스위치를 변환 했을 때 마지막 스위치의 상태 출력

<변수 범위>
 1. 2초 / 128MB
 2. 스위치의 개수 1<=N<=100
 3. 학생수 100 이하 자연수
 4. 학생이 받는 스위치 숫자 -> 스위치 개수 이하의 자연수
 5. 남 : 1, 여 : 2

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 백준으로 옮길때 bw.write(sb.toString()) 을 빼먹음.... ㅋㅋㅋㅋ

import java.io.*;
import java.util.StringTokenizer;

public class Q1244 {
    static int N, numOfStudents;
    static boolean[] switchStatus;

    static final boolean ON = true;
    static final boolean OFF = false;

    static final int M = 1;
    static final int F = 2;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        N = Integer.parseInt(br.readLine());
        switchStatus = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) switchStatus[i] = Integer.parseInt(st.nextToken()) == 1;

        numOfStudents = Integer.parseInt(br.readLine());

        // ******************** 입력 & 메인 로직 ********************

        int gender, switchNum;

        for (int i=0;i<numOfStudents;i++) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            switchNum = Integer.parseInt(st.nextToken());
            switchControl(gender, switchNum);
        }

        // ******************** 정답 출력 ********************

        for (int i=1;i<=N;i++) {
            sb.append(switchStatus[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void switchControl(int gender, int switchNum) {
        if (gender == M) switchControl_male(switchNum);
        else switchControl_female(switchNum);
    }

    public static void switchControl_male(int switchNum) {
        for (int i=switchNum;i<=N;i+=switchNum) convertStatus(i);
    }

    public static void switchControl_female(int switchNum) {
        convertStatus(switchNum);
        int left = switchNum-1;
        int right = switchNum+1;
        while (left>=1 && right<=N) {
            if(switchStatus[left] == switchStatus[right]) {
                convertStatus(left--);
                convertStatus(right++);
            }
            else break;
        }
    }

    public static void convertStatus(int switchPos) {
        switchStatus[switchPos] = switchStatus[switchPos]==ON ? OFF : ON;
    }
}

















