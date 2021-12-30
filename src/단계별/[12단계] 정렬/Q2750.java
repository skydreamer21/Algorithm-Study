// 2750번 수 정렬하기

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.LinkedList;

public class Q2750 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> arr = new LinkedList<>();
        int temp;
        for (int i=0;i<N;i++) {
            temp=Integer.parseInt(br.readLine());
            if (i==0) arr.add(temp);
        }
        bw.flush();
        bw.close();
    }
}