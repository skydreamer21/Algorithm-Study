// 15552번 빠른 A+B
// BufferedReader 와 BufferedWriter의 사용

import java.io.*;
import java.util.StringTokenizer;

public class Q15552 {
   public static void main(String args[]) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       String s;
       StringTokenizer tk;
       int T;
       T=Integer.parseInt(bf.readLine());
       int x;
       int y;
       int sum;
       for (int i=0;i<T;i++) {
           s=bf.readLine();
           tk = new StringTokenizer(s);
           x=Integer.parseInt(tk.nextToken());
           y=Integer.parseInt(tk.nextToken());
           sum=x+y;
           bw.write(sum+"\n");
       }
       bw.flush();
       bw.close();
   }
}







