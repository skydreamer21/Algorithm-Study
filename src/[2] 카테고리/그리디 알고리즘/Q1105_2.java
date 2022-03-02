import java.io.*;
import java.util.StringTokenizer;

public class Q1105_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(num8(L,R)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int num8 (int l, int r) {
        int cnt=0;
        int tmp1=l;
        int tmp2=r;
        int num1;
        int num2;
        int len1 = (int) Math.log10(l)+1; // 첫번쨰 자리수
        int len2 = (int) Math.log10(r)+1; // 두번쨰 자리수
        System.out.printf("len1 : %d, len2 : %d\n",len1,len2);
        if (len1!=len2) return 0;
        for (int i=len1-1;i>=0;i--) {
            num1 = (int) (tmp1/Math.pow(10,i));
            num2 = (int) (tmp2/Math.pow(10,i));
            if(num1==num2 && num1==8) cnt++;
            else if (num1!=num2) break;
            tmp1 %= Math.pow(10,i);
            tmp2 %= Math.pow(10,i);
        }
        return cnt;
    }
}