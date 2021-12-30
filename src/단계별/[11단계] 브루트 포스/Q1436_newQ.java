// 1436번 영화감독 숌 --- 변형 6이 세번

/*
<문제 정보>
 1. 종말의 숫자 : 6이 세번 들어간 숫자
 2. 666 -> 1666 -> 2666 -> ...
 3. N번째 종말의 숫자 출력
 4. N<=10000, N은 자연수

<프로그램 진행>
 1. N번째 숫자가 몇자리인지 알아낸다.
 2. 맨 앞 한자리를 알아낸다음 완전탐색

<필요 함수>
 1. N번째 숫자가 몇자리인지 알아내는 함수 -> 여기서 그전자리까지의 합도 return 해주어야 함
 2. N과 몇자리인지를 input으로 넣었을 때 맨 앞자리 숫자를 출력하는 함수
 3. N, 자릿수, 맨 앞자리를 넣었을 때 N번째 숫자를 알아내는 함수
 4. 주어진 숫자에 6이 3개 있는지 boolean return 함수

 */

import java.io.*;

public class Q1436_newQ {
    public static int[] getDigits (int N) {
        int info[] = new int[2];
        int cnt=3;
        int temp=0;
        while (true) {
            if (cnt==3) temp+=1;
            else temp+=((cnt-1)*(cnt-2)*(cnt-3)/6)*(int)Math.pow(9,cnt-4)*8+((cnt-1)*(cnt-2)/2)*(int)Math.pow(9,cnt-3);
            if (N<=temp) break;
            else cnt++;
        }
        temp-=((cnt-1)*(cnt-2)*(cnt-3)/6)*(int)Math.pow(9,cnt-4)*8+((cnt-1)*(cnt-2)/2)*(int)Math.pow(9,cnt-3);
        info[0]=cnt;
        info[1]=temp;
        return info;
    }

    // 이 함수는 4자리 이상 일때 씀
    public static int getFirstDigit (int N, int[] info) {
        int add = ((info[0]-1)*(info[0]-2)*(info[0]-3)/6)*(int)Math.pow(9,info[0]-4);
        int add_6 = ((info[0]-1)*(info[0]-2)/2)*(int)Math.pow(9,info[0]-3);
        int cnt = 1;
        while (true) {
            if(cnt!=6) info[1]+=add;
            else info[1]+=add_6;
            if(N<=info[1]) break;
            cnt++;
        }
        if(cnt!=6) info[1]-=add;
        else info[1]-=add_6;
        return cnt;
    }

    public static int getNthNumber (int N, int[] info, int firstNum) {
        int res = N-info[1];
        int cnt=0;
        int temp = (int)Math.pow(10,info[0]-1)*firstNum;
        while (cnt!=res) {
            if (IsThisTheNumber(temp)) cnt++;
            temp++;
        }
        return temp-1;
    }

    public static boolean IsThisTheNumber(int N) {
        int cnt=0;
        boolean theNumber=false;
        while (N>0) {
            if (N%10==6) cnt++;
            if (cnt>3) break;
            N/=10;
        }
        if (cnt==3) theNumber=true;
        return theNumber;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] info = getDigits(N);
        System.out.println(info[0] +" "+info[1]);
        int num;
        int firstNum=0;
        if (info[0]==3) num=666;
        else {
            firstNum=getFirstDigit(N,info);
            System.out.println(firstNum +" "+info[1]);
            num = getNthNumber(N,info,firstNum);
        }
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }
}