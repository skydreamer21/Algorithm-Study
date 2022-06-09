// 2461번 대표선수 (G2) [투포인터] - 실패 (시간 초과 코드)
/*
<문제 정보>
 1. 각각 M 명으로 구성된 N개의 학급에서 한명의 대표를 뽑을 때 대표들 능력치중 최대와 최소의 차이의 최솟값 출력

<변수 범위>
 1. 2초 / 256MB
 2. 1<=N,M<=1,000
 3. 능력치 0이상 10^9 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// O(N^3 logN) 이라 불가능

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2461 {
    static int N, M;
    static int[][] students;
    static int[] abilities;
    static int minDiff = 1_000_000_001;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        students = new int [N][M];
        abilities = new int[N*M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                students[i][j] = Integer.parseInt(st.nextToken());
                abilities[M*i+j] = students[i][j];
            }
            Arrays.sort(students[i]);
        }
        Arrays.sort(abilities);
        for (int n : abilities) System.out.printf("%d ",n);
        System.out.println();
        getMinDiff();
        sb.append(N==1 ? 0 : minDiff);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getMinDiff() {
        int left = 0;
        int right = 1;
        int tmp;
        while(right<N*M) {
            // left==right 일때 처리 필요
            if (abilities[right]-abilities[left]>minDiff)  {
                if (left<right) left++;
                else right++;
                continue;
            }
            boolean temp = isPossibleRange(left,right);
//            System.out.printf("left : %d, right : %d, possible : %b\n",abilities[left],abilities[right],temp);
            if (temp) {
                minDiff = Math.min(minDiff, abilities[right]-abilities[left]);
                if (minDiff==0) break;
                tmp = abilities[left++];
                while(abilities[left]==tmp) left++;
            }
            else {
                tmp = abilities[right++];
                while(right<N*M && abilities[right]==tmp) right++;
            }
        }
    }

    public static boolean isPossibleRange(int lowIdx, int highIdx) {
        int lowerBoundIdx;
        for (int i=0;i<N;i++) {
            if (abilities[lowIdx]>students[i][M-1] || abilities[highIdx]<students[i][0]) return false;

            lowerBoundIdx = BS_LowerBound(i,abilities[lowIdx]);
//            System.out.println(students[i][lowerBoundIdx]);
            if (students[i][lowerBoundIdx]>abilities[highIdx]) return false;
        }
        return true;
    }

    public static int BS_LowerBound(int classNum, int key) {
        int lo = 0;
        int hi = M-1;
        int mid;

        while (lo<hi) {
            mid = (lo+hi)/2;
            if(students[classNum][mid]==key) return mid;
            if(students[classNum][mid]<key) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}





















