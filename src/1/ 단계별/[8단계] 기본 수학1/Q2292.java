// 2292번 벌집
/*
<문제 정보>
 1. 벌집모양의 방  중앙 1부터 시계방향으로 돌아가며 1씩 커짐
 2. 1부터 N까지 최소경로로 간다면 방 몇개를 거치는지 출력
 */

/*
<프로그램 진행>
1. 일종의 원모양
2. 첫번째원(r=0) 1개, 두번째원(r=1) 6개, 세번째원(r=2) 12개...
(계차수열)  sum += 6*i; i++; 계차수열의 표현
 */

/*
<필요 함수>
1. 해당 숫자가 몇번째 원에 속해있는지 return
 */

import java.io.*;

public class Q2292 {
    public static int getCircleNo(int num) {
        int i=1;
        int val=1;
        while(num>val) {
            i++;
            val=3*i*i-3*i+1; // while자체가 sigma니까 굳이 계산 안해도됨
        }
        return i;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int num = Integer.parseInt(br.readLine());
        int circleNo = getCircleNo(num);
        bw.write(String.valueOf(circleNo));
        bw.flush();
        bw.close();
    }
}






