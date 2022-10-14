// 2805번 나무 자르기
/*
<문제 정보>
 1. 나무 M미터 필요
 2. 절단기에 높이 H지정 -> 한줄에 지정한 높이만큼 수평으로 자름
  -> H이상인 나무는 잘리고 H미만인 나무는 안잘림
 3. 자른 후 필요한 만큼만 집으로 가져가려고 함.
 4. 적어도 M미터의 나무를 집에 가져가지 위해서 절단기에 설정할 수 있는 높이의 최댓값 출력
 5. 나무의 수 N 1,000,000 이하 자연수 / M은 2,000,000,000 이하의 자연수
 6. 높이는 1,000,000,000 이하의 자연수 또는 0

<프로그램 진행>
 1. UpperBound
 2. key 는 잘려진 나무 위쪽 길이의 합
 3. 정렬 필요 없고 주어진 나무길이 중 최댓값만 구하면 됨.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2805 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(BS_UpperBound(M)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BS_UpperBound (int key) {
        int min = 0;
        int max = getMax()+1;
        int mid;
        while (min<max) {
            mid = (min+max)/2;  // 주어진 최대 높이를 2배해도 int범위를 넘지않아서 괜찮지만 넘는지 안넘는지는 꼭 체크!
            if (cutTree(mid)>=key) min = mid+1;
            else max=mid;
        }
        return max-1;
    }

    public static long cutTree (int height) {
        long sum=0;
        for (int num : arr) {
            if (num>=height) sum+=num-height;
        }
        return sum;
    }

    public static int getMax () {
        int max = arr[0];
        for (int num : arr) max = Math.max(num, max);
        return max;
    }
}