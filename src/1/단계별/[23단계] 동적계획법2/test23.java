
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test23 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int sum=0;
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for (int i=0;i<12;i++) sum+=arr[i];
        System.out.println(sum);


        bw.flush();
        bw.close();
        br.close();
    }

}