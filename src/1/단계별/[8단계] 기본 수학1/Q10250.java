// 10250번 ACM 호텔

/*
<문제 정보>
 1. 층수, 각 층당 방 개수 입력 받아 N번째 온 손님이 들어갈 방번호 출력
 2. 층에 상관없이 작은 호수를 선호

<프로그램 진행>

<필요 함수>

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q10250 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer tk;
        int T = Integer.parseInt(br.readLine());
        String S;
        int floor;
        int room;
        int roomNo;
        for (int i=0;i<T;i++) {
            S=br.readLine();
            tk = new StringTokenizer(S);
            int H = Integer.parseInt(tk.nextToken());
            int W = Integer.parseInt(tk.nextToken());
            int N = Integer.parseInt(tk.nextToken());
            if (N%H==0) {
                floor = H;
                room = N/H;
            }
            else {
                floor = N%H;
                room=N/H+1;
            }
            roomNo = floor*100+room;
            bw.write(roomNo+"\n");
        }
        bw.flush();
        bw.close();
    }
}






