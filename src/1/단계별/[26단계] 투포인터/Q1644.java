// 1644번 소수의 연속합
/*
<문제 정보>
 1. 어떤 자연수를 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 표현의 경우의 수를 출력

<변수 범위>
 1. 2초 / 128MB
 2. 자연수 N 1<=N<=4,000,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.ArrayList;

public class Q1644 {
    final static int Range = 4000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] numbers = new boolean[Range+1];
        ArrayList<Integer> PN = new ArrayList<>();
        numbers[0] = numbers[1] = true;

        // 에라토스테네스의 체
        for (int i=2;i<=Range;i++) {
            if (numbers[i]) continue;
            PN.add(i);
            if (i<=Math.sqrt(Range)) {
                for (int j=2;i*j<=Range;j++) numbers[i*j]=true;
            }
        }

        // 투포인터
        int left=0;
        int right=0;
        int sum=0;
        boolean flag=true;
        int cnt=0;
        while (right<PN.size()) {
            if(flag) sum+=PN.get(right);
            else sum-=PN.get(left-1);

            if (sum>=N) {
                if(sum==N) cnt++;
                left++;
                flag=false;
            }
            else {
                right++;
                flag=true;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
