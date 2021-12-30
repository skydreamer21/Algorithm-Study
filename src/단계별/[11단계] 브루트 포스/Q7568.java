// 7568번 덩치

/*
<문제 정보>
 1. 키도 더 크고 몸무게도 더 많이 나가야 덩치가 높은 순위
 2. 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해짐. 만약 내 위로 k명 있으면 k+1 등
 2. N명의 사람의 키와 몸무게가 주어질 때, 덩치 순위를 출력

<프로그램 진행>
 1.

<필요 함수>
 1. 덩치 순위 알아내기

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q7568 {
    public static int getOrder(int[][] arr, int index) {
        int order=0;
        for (int i=0;i<arr.length;i++) {
            if(arr[i][0]>arr[index][0] && arr[i][1]>arr[index][1]) order++;
        }
        order+=1;
        return order;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];
        StringTokenizer st;
        String S;
        for (int i=0;i<N;i++) {
            S = br.readLine();
            st = new StringTokenizer(S);
            info[i][0]=Integer.parseInt(st.nextToken());
            info[i][1]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N;i++) bw.write(getOrder(info, i)+" ");
        bw.flush();
        bw.close();
    }
}