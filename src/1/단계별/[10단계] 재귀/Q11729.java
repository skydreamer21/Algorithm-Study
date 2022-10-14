// 11729번 하노이 탑 이동 순서

/*
<문제 정보>
 1. 하노이탑 초기상황 1번장대 원판 개수 N개
 2. 첫째 줄에 옮긴 횟수 K출력
 3. 두번째부터 수행 과정 출력 1 3 이면 1번째를 3번째에 옮긴다는 뜻

<프로그램 진행>
 1. 재귀함수
 2.

<필요 함수>
 1. move(A,B,N) N개를 A에서 B로
 2. 1,2,3 중 start와 end에 쓰이지 않은 것

** 1번 비해 2번에 메모리는 크고 시간은 적음. 함수 받는 인자가 늘어나면..?
 */

import java.io.*;


public class Q11729 {
    static StringBuilder sb = new StringBuilder();

    public static int findMid(int start, int end) {
        int mid=0;
        for (int i=1;i<=3;i++) {
            if (i!=start && i!=end) mid=i;
        }
        return mid;
    }
    public static void move(int start, int end, int disks) {
        int mid = findMid(start, end);
        if(disks==1) sb.append(start).append(end);
        else {
            move(start,mid,disks-1);
            sb.append(start).append(end);
            move(mid,end,disks-1);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int times = (int) Math.pow(2,N)-1;
        String orderInfo;
        move(1,3,N);
        orderInfo = sb.toString();
        bw.write(String.valueOf(times));
        bw.newLine();
        for (int i=0; i<orderInfo.length();i+=2) {
            bw.write(orderInfo.charAt(i)+" "+orderInfo.charAt(i+1)+"\n");
        }
        bw.flush();
        bw.close();
    }
}