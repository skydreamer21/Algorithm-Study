// 2836번 수상 택시 (G3) [스위핑]
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Q2836 {
    static int N, M;
    static long reverseDist = 0;
    static ArrayList<int[]> reverseClients = new ArrayList<>();

    static final int DEPART = 1;
    static final int ARRIVAL = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start > end) reverseClients.add(new int[] {start, end});
        }

        // ******************** 메인 로직 ********************
        Collections.sort(reverseClients, (a, b) -> a[DEPART] == b[DEPART] ? a[ARRIVAL] - b[ARRIVAL] : a[DEPART] - b[DEPART]);
        int end = -1;
        int tmpDist = 0;
        for (int[] client : reverseClients) {
//            System.out.printf("depart : %d, arrival : %d\n",client[DEPART], client[ARRIVAL]);
            if (client[DEPART] > end) {
//                System.out.printf("출발이 이전 끝보다 커서 새로운 선 그룹 생성\n");
                reverseDist += tmpDist;
//                System.out.printf("현재 더해진 tmpDist : %d\n",tmpDist);
                tmpDist = client[ARRIVAL] - client[DEPART];
//                System.out.printf(" 결과 reverseDist : %d\n",reverseDist);
            }

            // 출발점이 이전 끝 점보다 작거나 같으면
            else if (client[ARRIVAL] > end) {
//                System.out.printf("출발이 이전 끝보다 작지막 도착은 더 커서 차이만큼 추가\n");
                tmpDist += (client[ARRIVAL] - end);
            }

            else {
//                System.out.printf("출발, 도착 모두 이전 끝보다 작음 -> 할거 없음\n");
            }


            end = Math.max(end, client[ARRIVAL]);
        }
        reverseDist += tmpDist;
//        System.out.printf("현재 더해진 tmpDist : %d\n",tmpDist);
//        System.out.printf(" 결과 reverseDist : %d\n",reverseDist);

        long totalDist = M + (reverseDist*2);

        // ******************** 정답 출력 ********************
        sb.append(totalDist);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
