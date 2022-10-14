// 2742번 기찍 N

import java.io.*;

public class Q2742 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(bf.readLine());
        int A;
        for (int i=0;i<N;i++) {
            A=N-i;
            bw.write(A+"\n");
        }
        bw.flush();
        bw.close();
    }
}

/*
import java.util.Scanner;

public class Q2741 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=1;i<=N;i++) {
            System.out.println(i);
        }
    }
}
*/





