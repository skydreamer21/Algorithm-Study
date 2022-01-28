// 1541번 잃어버린 괄호

/*
<문제 정보>
 1. 0~9, +, - 로만 이루어진 식이 있을 때, 괄호를 적절히 쳐서 만들 수 있는 최솟값 출력
 2. 5자리 이하의 숫자들로 구성, 숫자가 0으로 시작 가능
 3. 식의 길이는 50이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// <다른 풀이> -를 기준으로 나눠서 각각의 덩어리에서 싹 더한 값들 구함.
// 그 값들 중 맨 처음 것만 +, 나머지는 싹 -

import java.io.*;
import java.util.Arrays;

public class Q1541 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        boolean first=false;
        int cnt=0;
        int first_idx=0;
        for (int i=0;i<s.length();i++) {
            if(s.charAt(i)=='+' || s.charAt(i)=='-') {
                cnt++;
                if (s.charAt(i)=='-') {
                    first=true;
                    if (i!=0) first_idx=cnt;
                    break;
                }
            }
        }
        String[] nums;
        if (s.charAt(0)=='-') nums = s.substring(1).split("\\+|-");
        else nums = s.split("\\+|-");
        //System.out.println(Arrays.toString(nums));
        //System.out.println(nums[0]);

        //System.out.println(first_idx);
        int sum=0;
        for (String num : nums) {
            if (!first) sum+=Integer.parseInt(num);
            else if (first_idx>0) {
                sum+=Integer.parseInt(num);
                first_idx--;
            }
            else sum-=Integer.parseInt(num);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}