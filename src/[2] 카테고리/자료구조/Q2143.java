// 2143번 두 배열의 합 (G3) [HashMap]
/*
<문제 정보>
 1. 두 배열에서 부 배열을 뽑아 합했을 때 그 합이 T가 되는 부배열 쌍 경우의 수 출력

<변수 범위>
 1. 2초 / 64MB
 2. -10^9 <= T <= 10^9
 3. 원소의 개수 각각 1,000개 이하
 3. 원소는 절댓값이 1,000,000 이하인 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;

public class Q2143 {
    static int N, M ,T;
    static int[] arr1, arr2;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr1 = prefixSum(st, N);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr2 = prefixSum(st, M);

        // ******************** 메인 로직 ********************
        // 1. arr1 에 대해서 모든 부분합을 구하고 (~1,000,000) 그 값을 key, 값이 나온 개수를 value로 저장한다.
        HashMap<Integer, Integer> sumValueMapOfArr1 = new HashMap<>();
        for (int i=0; i<=N; i++) {
            for (int j=i+1; j<=N; j++) {
                int sum = arr1[j] - arr1[i];

                if (sumValueMapOfArr1.containsKey(sum)) {
                    int count = sumValueMapOfArr1.get(sum);
                    sumValueMapOfArr1.put(sum, count+1);
                }
                else sumValueMapOfArr1.put(sum ,1);
            }
        }

        // 2. 1에서 저장한 HashMap의 key값을 정렬한 배열을 만든다.
//        Integer[] sumValuesOfArr1 = sumValueMapOfArr1.keySet().toArray(new Integer[0]);
//        Arrays.sort(sumValuesOfArr1);

        // 3. arr2 의 가능한 모든 부분합에 대해 합해서 T가 되는 합은 sumValeusOfArr1 에서 이분탐색을 통해 찾는다.
        long ans = 0;
        for (int i=0; i<=M; i++) {
            for (int j=i+1; j<=M; j++) {
                int sum = arr2[j] - arr2[i];
                if (sumValueMapOfArr1.containsKey(T - sum)) {
                    ans += sumValueMapOfArr1.get(T - sum);
                }
                /*
                if (binarySearch(sumValuesOfArr1, T - sum)) {
                    ans += sumValueMapOfArr1.get(T - sum);
                }
                 */
            }
        }

        // ******************** 정답 출력 ********************
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean binarySearch(Integer[] sumValuesOfArr, int key) {
        int lo = 0;
        int hi = N;
        int mid;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (sumValuesOfArr[mid] == key) return true;
            else if (sumValuesOfArr[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }

    public static int[] prefixSum (StringTokenizer st, int size) {
        int[] arr = new int[size+1];
        for (int i=1; i<=size; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        return arr;
    }
}
