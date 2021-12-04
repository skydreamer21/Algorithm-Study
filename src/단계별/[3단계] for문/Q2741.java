// 2741번 N 찍기

import java.io.*;

public class Q2741 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(bf.readLine());
        for (int i=1;i<=N;i++) {
            bw.write(i+"\n");
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





