// 4344번 평균은 넘겠지

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q4344 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        int C = Integer.parseInt(br.readLine());
        int N;
        String info;
        int count;
        int sum;
        double avg;
        double rate;
        String Round_Rate;
        int val;
        for (int i=0;i<C;i++) {
            info = br.readLine();
            tk = new StringTokenizer(info);
            N=Integer.parseInt(tk.nextToken());
            int[] score = new int[N];
            Arrays.fill(score,0);
            count=0;
            sum=0;
            for (int j=0;j<N;j++) {
                val=Integer.parseInt(tk.nextToken());
                sum+=val;
                score[j]=val;
            }
            avg=sum/N;
            for (int num : score) {
                if (num>avg) count++;
            }
            rate=(double)count/N*100;
            //Round_Rate=(double)Math.round(rate*1000)/1000;
            //위에껀 뭔가 더 추가를 하지 않는 이상 40.000% 표현이 안됨. 40.0%으로 나옴.
            Round_Rate=String.format("%.3f", rate);
            bw.write(Round_Rate+"%\n");
        }
        bw.flush();
        bw.close();
    }
}



