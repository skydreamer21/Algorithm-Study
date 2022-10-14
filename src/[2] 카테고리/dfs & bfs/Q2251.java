// 2251번 물통 (G5) [bfs + bitMask]
/*
<문제 정보>
 1. A, B, C 세개의 물통이 있고 C만 꽉 차 있다. 한 쪽 물통이 꽉 차거나 빌 때까지 물을 옮기는 과정을 반복할 때 C에 들어 있을 수 있는 물의 양을 오름차순으로 출력

<변수 범위>
 1. 2초 / 128MB
 2. 각 물통의 부피 1 <= V <= 200

<프로그램 진행>
 1.

<필요 함수>
 1.

 */
// 7 6 5 4 3 2 1 0 -> 8bit  8bit*3 = 24bit

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Q2251 {
    static int[] bucketSize;

    static final int A = 0;
    static final int B = 1;
    static final int C = 2;
    static final int EIGHT_BIT_ON = 255;
    static final int EMPTY = 0;

    static int[][] directions = {{A, B}, {A, C}, {B, A}, {B, C}, {C, A}, {C, B}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        st = new StringTokenizer(br.readLine());
        bucketSize = new int[3];
        for (int i=0;i<3;i++) {
            bucketSize[i] = Integer.parseInt(st.nextToken());
        }

        // ******************** 메인 로직 ********************

        ArrayList<Integer> waterInLastBucket = new ArrayList<>(bfs());
        Collections.sort(waterInLastBucket);

        // ******************** 정답 출력 ********************

        for (int water : waterInLastBucket) sb.append(water).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static HashSet<Integer> bfs () {
        int initStatus = editMask(0, C, bucketSize[C]);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(initStatus);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(initStatus);

        HashSet<Integer> waterInLastBucket = new HashSet<>();
        waterInLastBucket.add(bucketSize[C]);

        int now, next;
        int from, to;

        while (!q.isEmpty()) {
            now = q.poll();
            for (int[] dir : directions) {
                from = dir[0];
                to = dir[1];
                next = moveWater(now, from, to);
                if (!visited.contains(next)) {
                    if (getNthNumOfMask(next, A) == EMPTY) {
                        waterInLastBucket.add(getNthNumOfMask(next, C));
                    }
                    q.add(next);
                    visited.add(next);
                }
            }
        }
        return waterInLastBucket;
    }

    public static int moveWater(int mask, int from, int to) {
        int waterInFromBucket = getNthNumOfMask(mask, from);
        int waterInToBucket = getNthNumOfMask(mask, to);
        int emptyVolumeInToBucket = bucketSize[to] - waterInToBucket;
        int movedWater = Math.min(emptyVolumeInToBucket, waterInFromBucket);

        int newMask;
        newMask = editMask(mask, from, waterInFromBucket - movedWater);
        newMask = editMask(newMask, to, waterInToBucket + movedWater);
        return newMask;
    }

    // index에 해당하는 숫자 가져오기
    public static int getNthNumOfMask(int mask, int index) {
        return (mask >> (index<<3)) & EIGHT_BIT_ON;
    }

    // index의 숫자를 value로 바꾸기
    public static int editMask(int mask, int index, int value) {
        return mask & ~(EIGHT_BIT_ON << (index<<3)) | (value << (index<<3));
    }

    public void printBucketStatus(int mask) {
        for (int i=0; i<3; i++) {
            System.out.printf("%d ", getNthNumOfMask(mask, i));
        }
        System.out.println();
    }
}