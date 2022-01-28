// 1931번 회의실 배정

/*
<문제 정보>
 1. 한개 회의실 사용하는 N개의 회의 -> 사용표
 2. 각 회의 시작과 끝 시간이 주어져있을 때 회의가 겹치지 않게 하면서 회의실을 사용할
 수 있는 회의의 최대 갯수
 3. 시작시간과 끝나는 시간이 같을 수도 있음
 4. 1<=N<=100,000  /  시간들을 2^31-1 이하 자연수 또는 0

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 이런 식의 문제를 '활동 선택 문제 (Activity Selection problem) 이라고 함



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Q1931 {
    static int[][] times;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        times = new int[N][2];
        StringTokenizer st;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0]=Integer.parseInt(st.nextToken());
            times[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]) return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        //printArr();

        int cnt=1;
        int endTime = times[0][1];
        for (int i=1;i<N;i++) {
            if(times[i][0]>=endTime) {
                endTime = times[i][1];
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));


        bw.flush();
        bw.close();
        br.close();
    }
/*
    public static void printArr() {
        for (int i=0;i<times.length;i++) {
            System.out.println(Arrays.toString(times[i]));
        }
    }
 */
}