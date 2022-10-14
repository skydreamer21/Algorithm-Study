// 11729번 하노이 탑 이동 순서

/*
<문제 정보>
 1. 하노이탑 초기상황 1번장대 원판 개수 N개
 2. 첫째 줄에 옮긴 횟수 K출력
 3. 두번째부터 수행 과정 출력 1 3 이면 1번째를 3번째에 옮긴다는 뜻

<프로그램 진행>
 1. 재귀함수
 2. 띄어쓰기랑 엔터까지 한번에 append

<필요 함수>
 1. move(start,mid,end,N) N개를 A에서 B로

 */

import java.io.*;


public class Q11729_2 {
    static StringBuilder sb = new StringBuilder();

    public static void move(int start, int mid, int end, int disks) {
        if(disks==1) sb.append(start+" "+end+"\n");
        else {
            move(start,end,mid,disks-1);
            sb.append(start+" "+end+"\n");
            move(mid,start,end,disks-1);
        }
    }

    public static void main(String args[]) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int N = Integer.parseInt(br.readLine());
       int times = (int) Math.pow(2,N)-1;
       move(1,2,3,N);
       bw.write(String.valueOf(times));
       bw.newLine();
       bw.write(sb.toString());
       bw.flush();
       bw.close();
    }
}