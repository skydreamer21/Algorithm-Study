// 2108번 통계학

/*
<문제 정보>
 1. N개의 수를 입력받으면 네가지 기본 통계값을 구하는 프로그램 작성
 -> 산술평균, 중앙값, 최빈값, 범위
 2. 1<=N<=500,000  N은 홀수 / 절댓값이 4,000 을 넘지 않는 정수
 3. 산술평균은 소숫점 이하 첫째 자리에서 반올림한 값
 4. 최빈값이 여러개 있을 때는 최빈값중 두 번째로 작은 값 출력

<프로그램 진행>
 1. 절댓값이 4000을 넘어가지 않는다면 범위에 들어가는 정수 개수는 8001개
 -> N보다 그 값이 작으므로 Counting Sort를 이용

<필요 함수>
 1. Sorting
 2. 산술평균
 3. 중앙값
 4. 최빈값
 5. 범위


 */

import java.io.*;
import java.util.Arrays;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        int[] statistics = getStatisticsFigures(arr);

        StringBuilder sb = new StringBuilder();
        for (int num : statistics) sb.append(num).append("\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }


    public static int[] getStatisticsFigures (int[] arr) {
        /*
        statistics arr Information
        0 Index : Average
        1 Index : Median
        2 Index : Mode
        3 Index : range
         */

        int[] statistics = new int[4];
        statistics[0] = getAverage(arr); // Average
        int size = arr.length;
        convertArr(arr);
        int[] sorted_arr = new int[size];
        int[] cnt = new int[findMax(arr)+1];

        for (int num : arr) cnt[num]++;
        //printCnt(cnt);
        statistics[2] = getMode(cnt)-4000; // Mode
        for (int i=1;i<cnt.length;i++) cnt[i]+=cnt[i-1];

        for (int i=size-1;i>=0;i--) {
            sorted_arr[cnt[arr[i]]-1] = arr[i];
            cnt[arr[i]]--;
        }
        statistics[1] = getMedian(sorted_arr)-4000; // Median
        statistics[3] = sorted_arr[size-1]-sorted_arr[0]; // range
        return statistics;
    }

    public static int findMax (int[] arr) {
        int max=arr[0];
        for(int num : arr) max=Math.max(num,max);
        return max;
    }

    public static int[] findMax_2 (int[] cnt) {
        /*
        <This function is for cnt arr>
        maxinfo Information
        0 Index : max value Index (first)
        1 Index : Is there duplicate max values (0 or more)
         */
        int[] maxinfo = new int[2];
        int max=cnt[0];
        for(int i=0;i<cnt.length;i++) {
            if (cnt[i]==max) maxinfo[1]++;
            else if (cnt[i]>max) {
                max=cnt[i];
                maxinfo[0]=i;
                maxinfo[1]=0;
            }
        }
        return maxinfo;
    }

    public static void convertArr (int[] arr) {
        for(int i=0;i<arr.length;i++) arr[i]+=4000;
    }

    public static int getAverage (int[] arr) {
        double sum = 0;
        for (int num : arr) sum+=num;
        int average = (int) Math.round(sum/arr.length);
        return average;
    }

    public static int getMedian (int[] arr) {
        int medianIndex = arr.length/2;
        return arr[medianIndex];
    }

    public static int getMode (int[] cnt) {
        int[] maxinfo = findMax_2(cnt);
        int max = cnt[maxinfo[0]];
        //System.out.println(Arrays.toString(maxinfo));
        //System.out.printf("max : %d\n",max);
        if (maxinfo[1]==0) return maxinfo[0];
        else {
            while(true) {
                maxinfo[0]++;
                if(cnt[maxinfo[0]]==max) return maxinfo[0];
            }
        }
    }

    public static void printCnt (int[] cnt) {
        for(int i=0;i<cnt.length;i++) {
            if(cnt[i]!=0) System.out.printf("%d : %d개\n", i-4000, cnt[i]);
        }
    }

}