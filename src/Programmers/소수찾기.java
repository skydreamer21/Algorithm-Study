//import java.util.Arrays;
//
//class Solution {
//    static boolean[] isPrime;
//
//    public int solution(int n) {
//        isPrime = new boolean[n+1];
//        Arrays.fill(isPrime, true);
//        isPrimeNum(n);
//        int answer = 0;
//        for (int i=2;i<=n;i++) {
//            if(isPrime[i]) answer++;
//        }
//        return answer;
//    }
//
//    public static void isPrimeNum(int n) {
//        for (int i=2;i<Math.sqrt(n);i++) {
//            for (int j=i*i;j<=n;j+=i) isPrime[j] = false;
//        }
//    }
//}