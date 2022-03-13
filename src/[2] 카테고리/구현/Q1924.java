// 1924번 2007년 (B1)
/*
<문제 정보>
 1. 2007 1.1 월요일일 때 x월 y일 무슨 요일?

<변수 범위>
 1. 2초 / 128MB


<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;



public class Q1924 {



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int sum=0;
        for (int i=1;i<x;i++) {
            if (i<=7) {
                if (i%2==1) sum+=31;
                if (i%2==0) {
                    if(i==2) sum+=28;
                    else sum+=30;
                }
            }
            else {
                if (i%2==1) sum+=30;
                else sum+=31;
            }
        }
        sum+=y;
        switch (sum%7) {
            case 0 :
                bw.write("SUN");
                break;
            case 1 :
                bw.write("MON");
                break;
            case 2 :
                bw.write("TUE");
                break;
            case 3 :
                bw.write("WED");
                break;
            case 4 :
                bw.write("THU");
                break;
            case 5 :
                bw.write("FRI");
                break;
            case 6 :
                bw.write("SAT");
                break;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

