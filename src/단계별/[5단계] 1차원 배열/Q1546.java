// 1546번 평균
// 최고점을 100점으로 환산해서 나머지 점수를 바꾸고 평균내기

/*
import java.io.*;
import java.util.StringTokenizer;

public class Q1546 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer tk = new StringTokenizer(s);
        double[] score = new double[N];
        double[] Modified_Score = new double[N];
        score[0] = Integer.parseInt(tk.nextToken());
        double max = score[0];
        double avg;
        double sum=0;
        double val;
        int i=1;
        // 점수 배열을 만들어주는 동시에 최댓값을 구함.
        while(tk.hasMoreTokens()) {
            val = Integer.parseInt(tk.nextToken());
            score[i]=val;
            if (val>max) max = val;
            i++;
        }
        // 최고점 100점 기준 점수 변환
        for (int j=0;j<N;j++) {
            Modified_Score[j]=score[j]/max*100;
            sum+=Modified_Score[j]; // 평균을 구하기 위한 합 계산
        }
        avg=sum/N;
        bw.write(String.valueOf(avg));
        bw.flush();
        bw.close();
    }
}
*/

// 배열 없이 구하기
// 그냥 원점수 다 합한다음에 변환해줘도 평균은 구함. 개별적인 점수는 X
import java.io.*;
import java.util.StringTokenizer;

public class Q1546 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer tk = new StringTokenizer(s);
        double max=Integer.parseInt(tk.nextToken());
        double sum=max;
        double Modified_Sum;
        double val;
        double avg;
        while(tk.hasMoreTokens()) {
            val=Integer.parseInt(tk.nextToken());
            sum+=val;
            if (val>max) max = val;
        }
        Modified_Sum=sum/max*100;
        avg=Modified_Sum/N;
        bw.write(String.valueOf(avg));
        bw.flush();
        bw.close();
    }
}



