// 2577번 숫자의 개수
// 각 자리 수를 분리

import java.io.*;

public class Q2577 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int mul = A*B*C;
        int[] arr = new int[10];
        int num;
        int val = mul;
        while (val!=0) {
            num=val%10;
            arr[num]++;
            val=(val-num)/10;
        }
        for (int i=0;i<10;i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}




