import java.io.*;

public class test28 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int a = 'A';
        System.out.println((char)(2+'A'));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
