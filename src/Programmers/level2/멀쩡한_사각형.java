// w에서 시작해서 w*h까지 갑니다.

/*class Solution {
    public long solution(int w, int h) {
        return (long)w*h - (w+h) + GCD(Math.max(w,h), Math.min(w,h));
    }

    public static int GCD(int a, int b) {
        return b==0 ? a : GCD(b, a%b);
    }
}*/

/*class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h - (w+h) + GCD(Math.max(w,h), Math.min(w,h));
        return answer;
    }

    public static int GCD(int a, int b) {
        return b==0 ? a : GCD(b, a%b);
    }
}*/


// class Solution {
//     public long solution(int w, int h) {
//         int bigger = Math.max(w,h);
//         int smaller = Math.min(w,h);
//         long LCM = (long)w*h/GCD(bigger, smaller);

//         long lenOfSquare = w;
//         long step = h;
//         long numOfCM = lenOfSquare*step/LCM;

//         long answer = lenOfSquare*step - lenOfSquare - (step-numOfCM);

//         System.out.println(LCM);
//         System.out.println(numOfCM);
//         return answer;
//     }

//     public static int GCD(int a, int b) {
//         return b==0 ? a : GCD(b, a%b);
//     }
// }

// class Solution {
//     public long solution(int w, int h) {
//         long removed = 0;
//         long answer = 1;
//         int now=0;
//         int compareValue=0;
//         for (int i=1;i<=h;i++) {
//             if (now!=compareValue) removed++;
//             now += w;
//             while(now>compareValue) {
//                 removed++;
//                 compareValue += h;
//             }
//             // System.out.printf("%d에서 제거된 사각형 : %d AND compareValue : %d\n",now, removed, compareValue);
//         }
//         answer = w*h - removed;
//         return answer;
//     }
// }