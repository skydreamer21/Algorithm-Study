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
import java.util.StringTokenizer;

public class forTest {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int size = 10000;
        File file = new File("C:\\Create\\Study Project\\백준 알고리즘\\testCase\\Q2263_4.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);
        sb.append(size).append("\n");
        for (int i=size;i>0;i--) sb.append(i).append(" ");
        sb.append("\n");
        for (int i=size;i>0;i--) sb.append(i).append(" ");
        writer.write(sb.toString());
        writer.close();

//        sb.setLength(0);
        /*BufferedReader reader = new BufferedReader(new FileReader("C:\\Create\\Study Project\\백준 알고리즘\\testCase\\Q2263.txt"));
        sb.append(reader.readLine()).append("\n");
        st = new StringTokenizer(reader.readLine());
        while(st.hasMoreTokens()) sb.append(Integer.parseInt(st.nextToken())).append(" ");
        sb.append("\n");
        st = new StringTokenizer(reader.readLine());
        while(st.hasMoreTokens()) sb.append(Integer.parseInt(st.nextToken())).append(" ");*/

//        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
