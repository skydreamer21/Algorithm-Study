// 이 사람의 풀이가 동적계획법이라는 주제에 좀더 맞는 풀이
// 구했던 답을 "기억하며 풀기"

import java.io.*;

public class Q1003_other {

    static int memo1[];
    static int memo2[];
    static int num[];

    public static void main(String[] args) throws NumberFormatException, IOException {


        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        memo1 = new int[41];
        memo2 = new int[41];
        num = new int[N];


        for(int i=0; i<N ; i++) {
            num[i] = Integer.valueOf(br.readLine());
        }
        for(int i=0; i<N ; i++) {
            bw.write(String.valueOf(fiboA(num[i])));
            bw.write(" ");
            bw.write(String.valueOf(fiboB(num[i])));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();


    }

    private static int fiboA(int n) {
        if(n==0) {
            memo1[n] =1;
            return 1;
        }else if(n==1){
            memo1[n] =0;
            return 0;
        }else{
            if(memo1[n] >0) return memo1[n];
            memo1[n] = fiboA(n-1)+fiboA(n-2);
            return memo1[n];
        }

    }
    private static int fiboB(int n) {
        if(n==0) {
            memo2[n] =0;
            return 0;
        }else if(n==1){
            memo2[n] =1;
            return 1;
        }else{
            if(memo2[n]>0) return memo2[n];
            memo2[n] = fiboB(n-1)+fiboB(n-2);
            return memo2[n];
        }

    }

}