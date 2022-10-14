// 2869번 달팽이는 올라가고 싶다

/*
<문제 정보>
 1. V미터인 막대를 올라가는데 낮에는 A올라가고 밤에는 B미터 떨어짐
 2. 다오르려면 며칠걸리는지 출력

<프로그램 진행>
1. 앞의 손익분기점 문제(1712번)랑 비슷한 결인데 기준점보다 높이 올라가면 안떨어짐
2. 마지막 날은 올라가기만 함. 따라서 V-A 높이 고려해야함
2. 하루에 (A-B)미터 오름, 올랐을 때 기준점 넘어가면 끝

<필요 함수>

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2869 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String S = br.readLine();
        StringTokenizer tk = new StringTokenizer(S);
        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());
        int V = Integer.parseInt(tk.nextToken());
        int newV = V-A;
        int HowManyDays;
        if (newV<=0) HowManyDays = 1;
        else {
            if (newV%(A-B)==0) HowManyDays=newV/(A-B)+1;
            else HowManyDays=newV/(A-B)+2;
        }
        bw.write(String.valueOf(HowManyDays));
        bw.flush();
        bw.close();
    }
}






