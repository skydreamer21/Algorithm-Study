package Programmers.level3;

import java.util.Arrays;

class 입국심사 {
    static int N;
    static long INF = Long.MAX_VALUE;

    public long solution(int n, int[] times) {
        N = n;
        Arrays.sort(times);
        long timeForImmigration = binarySearch(times);

        return timeForImmigration;
    }

    public static long binarySearch(int[] times) {
        long lo = 0;
        long hi = INF;
        long mid;

        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (isEnough(times, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static boolean isEnough(int[] times, long t) {
        long sum = 0;
        for (int time : times) {
            sum += t / time;
            if (sum >= N) return true;
        }
        return false;
    }
}