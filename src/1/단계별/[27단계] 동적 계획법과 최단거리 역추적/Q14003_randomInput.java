// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q14003_randomInput {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        File file = new File("D:\\Programmer Study\\Algorithm-study\\src\\TestCase\\백준\\Q14003.txt");
        if(!file.exists()) file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);

        StringBuilder sb = new StringBuilder();
        //int N=0;
        //while(N==0) N = (int) (Math.random()*10)
        int N;
        int repeat = 1;

        while(repeat-->0) {
            N=100;
            sb.append(N).append("\n");
            long X;
            while(N-->0) {
                X =  (long) (Math.random()*2000000000)-1000000000;
                sb.append(X).append(" ");
            }
            sb.append("\n");
        }

        writer.write(sb.toString());
        writer.close();












        //bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
