// 2343번 기타 레슨 (S1)
/*
<문제 정보>
 1. 순서가 있는 N개의 강의를 같은 길이의 M개의 블루레이로 녹화하려고 할 때 가능한 블루레이의 최소 길이
    - i번째 강의와 j번째 강의를 담으려면 그 사이 강의도 모두 담아야 한다.

<변수 범위>
 1. 2초 / 128MB
 2. 한 강의는 10,000분 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2343 {
    static int N, M;
    static int[] lectures;
    static int maxLenOfBlueRay;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];

        st = new StringTokenizer(br.readLine());
        maxLenOfBlueRay = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            maxLenOfBlueRay += lectures[i];
        }

        // ******************** 메인 로직 ********************

        int minBlueRayLength = binarySearchLB(M);

        // ******************** 정답 출력 ********************

        sb.append(minBlueRayLength);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearchLB (int key) {
        int lo = 0;
        int hi = maxLenOfBlueRay;
        int mid;

        while (lo < hi) {
            mid = (lo + hi) / 2; // mid는 BlueRay 길이
//            System.out.printf("lo : %d, hi : %d, mid : %d\n",lo,hi,mid);
            if (checkValidityOfBlueRayLength(key, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // 주어진 길이로 M개의 블루레이를 만들 수 있는지 체크
    public static boolean checkValidityOfBlueRayLength (int key, int blueRayLen) {
        int indexOfLecture = 0;
        int numOfBlueRay = 0;
        int lecturesInEachBlueRay;
        boolean isPossible = true;
        while (indexOfLecture < N) {
            lecturesInEachBlueRay = 0;
            while (indexOfLecture < N && lecturesInEachBlueRay + lectures[indexOfLecture] <= blueRayLen) {
                lecturesInEachBlueRay += lectures[indexOfLecture++];
            }
//            System.out.printf("각 블루레이 길이 : %d\n", lecturesInEachBlueRay);

            numOfBlueRay++;
            if (numOfBlueRay > key) {
                isPossible = false;
                break;
            }
        }
//        System.out.print(isPossible + "\n");
        return isPossible;
    }
}
