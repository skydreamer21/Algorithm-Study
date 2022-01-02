// 10951번 A+B -4
// 프로그램이 끝나려면 먼저 다 받아야함
/*
// 파일에서 EOF 처리
import java.util.Scanner;

public class Q10951 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        int sum;
        while(sc.hasNextInt()) {
            x = sc.nextInt();
            y = sc.nextInt();
            sum = x+y;
            System.out.println(sum);
        }
    }
}
*/

// IDE에서 EOF 처리
import java.io.*;
import java.util.StringTokenizer;

public class Q10951 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        int x;
        int y;
        int sum;
        String input="";
        // 적어도 하나가 False이면 False가 됨
        while((input=br.readLine()) != null && !input.isEmpty()) {
            tk=new StringTokenizer(input);
            x=Integer.parseInt(tk.nextToken());
            y=Integer.parseInt(tk.nextToken());
            sum = x+y;
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
    }
}






