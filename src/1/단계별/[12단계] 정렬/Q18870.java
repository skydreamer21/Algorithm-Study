// 18870번 좌표 압축 -> 185MB / 2700ms

/*
<문제 정보>
 1. 수직선 위에 N개의 좌표
 2. Xi를 좌표 압축한 Xi'는 Xi>Xj를 만족하는 서로 다른 좌표의 개수
 3. 1<=N<=1,000,000 / -10^9<=Xi<=10^9

<프로그램 진행>
 1. Arrays.sort


<필요 함수>
 1.

 */

/* 참고할만한 다른 풀이
37341055 (agfalcon12) - HashMap 사용 (이해 아직 못함) 245MB / 1460ms
37089807 (cgkim449) - 비공개 181MB / 1668ms
 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Q18870 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[N][2];
        int[] result = new int[N];
        for (int i=0;i<N;i++) {
            arr[i][0]=i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int cnt=0;
        // 숫자크기 순서대로 배열된 첫번째 원소의 원래 인덱스는 0개
        result[arr[0][0]] = cnt;
        for (int i=1;i<N;i++) {
            if (arr[i][1]!=arr[i-1][1]) cnt++;
            result[arr[i][0]]=cnt;
        }


        /*
        for (int i=1;i<N;i++) {
            for (int j=i-1;j>=0;j--) {
                if (arr[j][1]!=arr[i][1])  {
                    result[arr[i][0]]=j+1;
                    break;
                }
                else if (j==0) result[arr[i][0]]=0;
            }
        }

         */

        StringBuilder sb = new StringBuilder();
        for (int num : result) sb.append(num).append(" ");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}