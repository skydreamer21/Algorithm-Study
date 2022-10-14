// 10818번 최소, 최대

// 읽고 StringTokenizer로 token 분리,
// 입력이 엄청 많게 되면 while 문이 많이 돌아가게 되면서 메소드 호출에 부하?!
// while 안에 parseInt랑 nexttoken, 만약 배열이면 ..


import java.io.*;
import java.util.StringTokenizer;

public class Q10818 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int token;
        tk=new StringTokenizer(s);
        int min=Integer.parseInt(tk.nextToken());
        int max=min;
        // while (tk.countTokens()) 이면 시간 초과가 될 수 밖에.. 시그마 1부터 n까지 더한만큼 셈..

        while (tk.hasMoreTokens()) {
            token = Integer.parseInt(tk.nextToken());
            if (token>max) {
                max=token;
                continue;
            }
            else if (token<min) min = token;
        }
        bw.write(min+" "+max);
        bw.flush();
        bw.close();
    }
}


/*

// Scanner 가 역시 더 느림
// Buffer : 636ms, Scanner : 1692ms

import java.util.Scanner;

public class Q10818 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.nextLine();
        int min=sc.nextInt();
        int max=min;
        int num;
        for (int i=0;i<N-1;i++) {
            num=sc.nextInt();
            if (num<=max && num >=min) continue;
            else if (num>max) {
                max=num;
                continue;
            }
            else if (num<min) min = num;
        }
        System.out.printf("%d %d",min,max);
    }
}
*/





