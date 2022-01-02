// 1011번 Fly me to the Alpha Centauri
/*
<문제 정보>
 1. 한번 작동시 k만큼 움직이면 다음 작동때는 k-1, k, k+1만 이동 가능
 2. 맨처음 1, 맨 마지막도 1이 되게 해야함
 3. x 지점에서 y 지점까지 최소 몇번 작동해야 하는지 출력

<프로그램 진행>
 1. 1 -> 121 -> 12321 -> 1234321 -> .... 이중 몇번째인지 확인
 2. 위 수열은 n^2 수열! for문 돌릴 필요 X


<필요 함수>
  1. 정수 N을 받아 위의 수열중 몇번째인지, 얼마가 남는지 크기가 2인 배열로 return
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1011 {
    public static int[] getOrderInfo(long N) {
        int[] info = new int[2];
        int order = (int) Math.ceil(Math.sqrt(N));
        info[0]=order;
        info[1]=(int) ((long)order*order-N);
        return info;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] info = new int[2];
        StringTokenizer tk;
        String locations;
        long x;
        long y;
        long dis;
        int ans;
        for(int i=0;i<T;i++) {
            locations = br.readLine();
            tk = new StringTokenizer(locations);
            x = Long.parseLong(tk.nextToken());
            y = Long.parseLong(tk.nextToken());
            dis = y-x;
            info = getOrderInfo(dis);
            if (info[0]==1) ans=1;
            else {
                if (info[1]>info[0]-1) ans = info[0]*2-2;
                else ans = info[0]*2-1;
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}

/*
    public static int[] getOrderInfo(long N) {
        int num=1;
        int i=1;
        int[] info = new int[2];
        while (true) {
            if(N<=num) {
                info[0] = i;
                info[1] = (int)((long)num-N);
                break;
            }
            else {
                num+=2*i+1;
                i++;
            }
        }
        return info;
    }
*/


