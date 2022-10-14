// 3052번 나머지
// 입력받은 수 10개를 42로 나눴을 때 서로 다른 나머지 개수 세기

import java.io.*;
import java.util.Arrays;

public class Q3052 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[10];
        int[] res = new int[42];
        Arrays.fill(res,0);
        int val; // 나머지
        int count=0;
        for (int i=0;i<10;i++) {
            arr[i]=Integer.parseInt(br.readLine());
            val=arr[i]%42;
            res[val]++;
        }
        for (int x : res) {
            if (x!=0) count++;
        }
        //System.out.println(count);
        bw.write(String.valueOf(count)); //출력할땐 String으로 변환!
        bw.flush();
        bw.close();

    }
}




