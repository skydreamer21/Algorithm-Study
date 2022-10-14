// 1065번 한 수
// 한 수 : 각 자리수가 등차수열

/*
필요함수
1. 3자리수를 한 수 인지 아닌지 True of False 출력
 */

import java.io.*;

public class Q1065 {

    public static boolean IsThisNumber(int num) {
        int diff1;
        int diff2;
        diff1 = num%10 - (num/10)%10;
        diff2 = (num/10)%10 - num/100;
        if (diff1==diff2) return true;
        else return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        for (int i=1;i<=N;i++) {
            if (i<=99) count++;
            else {
                if(IsThisNumber(i)) count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}





