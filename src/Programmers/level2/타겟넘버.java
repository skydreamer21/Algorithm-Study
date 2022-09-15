
// 오버헤드와 각종 상수계수들로 인해 N 최대 20일 때는 meet in the middle 이 효과를 크게 보지는 못함.
/*
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int count = 0;
    static ArrayList<Integer> sumSet1 = new ArrayList<>();
    static ArrayList<Integer> sumSet2 = new ArrayList<>();

    static final int IMPOSSIBLE = -1;

    public int solution(int[] numbers, int target) {
        // numbers 를 반씩 쪼개서 각각 dfs를 돌린다.
        // 0~mid , mid+1~end
        int len = numbers.length;
        int mid = len/2;
        dfs(0, mid+1, 0, numbers, 0); // 2^10 at max
        dfs(0, len-mid-1, mid+1, numbers, 0); // 2^10 at max

        Collections.sort(sumSet1); // log(2^10) * 2^10
        int sizeOfSet1 = sumSet1.size();
        int sizeOfSet2 = sumSet2.size();
        int key;
        int lo, hi;
        for (int i=0;i<sizeOfSet2;i++) { // 2 * log(2^10) * 2^10
            key = target - sumSet2.get(i);
            if (key<sumSet1.get(0) || key>sumSet1.get(sizeOfSet1-1)) continue;
            lo = BS_LowerBound(key);
            if (lo==IMPOSSIBLE) continue;
            hi = BS_UpperBound(key);
            count += hi-lo+1;
        }
        return count;
    }

    public static void dfs(int depth, int N, int startIdx, int[] numbers, int sum) {
        if (depth == N) {
            if (startIdx == 0) sumSet1.add(sum);
            else sumSet2.add(sum);
            return;
        }

        dfs(depth+1, N, startIdx, numbers, sum+numbers[startIdx+depth]);
        dfs(depth+1, N, startIdx, numbers, sum-numbers[startIdx+depth]);
    }

    public static int BS_LowerBound(int key) {
        int lo = 0;
        int hi = sumSet1.size();
        int mid;

        while(lo<hi) {
            mid = (lo+hi)/2;
            if (sumSet1.get(mid) < key) lo = mid+1;
            else hi = mid;
        }
        return sumSet1.get(lo) == key ? lo : IMPOSSIBLE;
    }

    public static int BS_UpperBound(int key) {
        int lo = 0;
        int hi = sumSet1.size();
        int mid;

        while(lo<hi) {
            mid = (lo+hi)/2;
            if (sumSet1.get(mid) <= key) lo = mid+1;
            else hi = mid;
        }
        return sumSet1.get(lo-1) == key ? lo-1 : IMPOSSIBLE;
    }
}




// class Solution {
//     static int count = 0;

//     public int solution(int[] numbers, int target) {
//         int len = numbers.length;
//         dfs(len, 0, numbers, target, 0);
//         return count;
//     }
// 2^20
//     public static void dfs(int N, int depth, int[] numbers, int target, int sum) {
//         if (depth == N) {
//             if(sum==target) count++;
//             return;
//         }

//         dfs(N, depth+1, numbers, target, sum+numbers[depth]);
//         dfs(N, depth+1, numbers, target, sum-numbers[depth]);
//     }
// }
*/