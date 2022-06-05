// 15829번 Hashing
/*
<문제 정보>
 1. 주어진 해시함수에 따라 주어진 문자열의 해시값을 정수로 출력
    - r : 31
    - M : 1234567891

<변수 범위>
 1. 1초 / 512MB
 2. small : 1<=L<=5
 3. Large : 1<=L<=50 -> 값은 long 이지만 중간에 나머지 계산

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// int 최댓값을 2,7.... 이라고 생각해서 틀림
// 2.147E9 입니다 (소숫점 셋째자리까지 표현)

import java.io.*;

public class Q15829 {
    static final int R = 31;
    static final int div = 1234567891;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(br.readLine());
        int order=0;
        long hashValue=0;
        int temp;
        int test = (int) exp(R,7);
//        int testHash =(int) ((long)test*8)%div;  -> int 캐스팅이 %div를 하기 전 괄호에 들어가기 때문에 원하는 값이 안나옴
//        int testHash =(int) (((long)test*8)%div); -> 이런식으로 %div 까지 감싸주어야 원하는 결과가 나옴
//        System.out.println(testHash);

        for (char c : br.readLine().toCharArray()) {
            /*temp = getEachCharHashValue(c-'a'+1,order++);
            System.out.printf("이번 문자 : %c, 더해질 해시값 : %d (%s)\n",c,temp,(temp>=div ? "NOOOOOO" : "YES"));
            hashValue+=temp;*/
            hashValue+=getEachCharHashValue(c-'a'+1,order++);
            hashValue%=div;
        }
        sb.append(hashValue);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int getEachCharHashValue(int alphabet, int order) {
        return (int) (((long)alphabet*exp(R,order))%div);
    }

    public static long exp(long a, int r) {
        if (r==0) return 1;
        if (r==1) return a;

        if (r%2==0) return exp((a*a)%div, r/2);
        else return (a*exp(a, r-1))%div;
    }
}
















