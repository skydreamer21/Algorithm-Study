import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1764_other {

    public static int N,M;
    public static HashSet<String> hs=new HashSet<String>();
    public static ArrayList<String> ans = new ArrayList<String>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            //arr1[i]=br.readLine();
            hs.add(br.readLine());
        }
        for(int i=0; i<M; i++) {
            String s=br.readLine();
            if(hs.contains(s)) {
                ans.add(s);
            }

        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int i=0; i<ans.size(); i++) {
            sb.append(ans.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}