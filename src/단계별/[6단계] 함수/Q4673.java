// 4673번 셀프 넘버
// 10000보다 작거나 같은 셀프 넘버 출력
// 셀프 넘버 : n과 n의 각자리수의 합을 더해서 만들수 없는 수

/* 필요 함수
1. 각 자리수의 합 계산
2. d(n) - 4자리
3. 카운트가 되지 않은 배열의 (index+1)를 한줄에 하나씩 출력
 */

import java.io.*;
import java.util.Arrays;

public class Q4673 {

    public static int getSumOfDigit(int num) {
        String s = String.valueOf(num);
        int sum=0;
        for (int i=0;i<s.length();i++) {
            sum+=Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    public static int D_function(int num) {
        int result;
        result = num + getSumOfDigit(num);
        return result;
    }

    public static void printSelfNumbers(int[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<arr.length;i++) {
            if (arr[i]==0) bw.write(String.valueOf(i+1)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String args[]) throws IOException {
        int[] arr = new int[9999];
        Arrays.fill(arr, 0);
        for (int i=1;i<=9999;i++) {
            if (D_function(i)<10000) arr[D_function(i)-1]++;
        }
        printSelfNumbers(arr);
    }
}

/* d 함수 한번에
 private static void d(int i) {
        int sum = i;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
}

 */




