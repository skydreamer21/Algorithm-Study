import java.io.*;
import java.util.StringTokenizer;

public class Q1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int L = Integer.parseInt(st.nextToken());
        //int R = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        String R = st.nextToken();
        int cnt=0;
        if (L.length()!=R.length()) bw.write(String.valueOf(0));
        else {
            for (int i=0;i<L.length();i++) {
                if(L.charAt(i)!=R.charAt(i)) break;
                else if (L.charAt(i)=='8') cnt++;
            }
        }
        bw.write(String.valueOf(cnt));


        //bw.write(String.valueOf(num8(L,R)));
        bw.flush();
        bw.close();
        br.close();
    }
}