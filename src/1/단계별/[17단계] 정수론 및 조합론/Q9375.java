// 9375번 패션왕 신해빈

/*
<문제 정보>
 1. 의상의 종류와 이름이 주어졌을 때 알몸이 아닌 상태로 의상을 입을 수 있는 경우의 수
 2. 의상 수 1<=n<=30
 3. 같은 종류의 의상은 하나만 입을 수 있다.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q9375 {
    static int[] num = new int[31];
    static String[] types = new String[31];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String clothes; String type;
        int cnt;
        int index_tmp;
        int N;
        for (int i=0;i<T;i++) {
            Arrays.fill(num,0);
            Arrays.fill(types,null);
            cnt=0;
            N = Integer.parseInt(br.readLine());
            while(N-->0) {
                st = new StringTokenizer(br.readLine());
                clothes = st.nextToken();
                type = st.nextToken();
                index_tmp = getItemIndex(types, type, cnt);
                if (index_tmp==-1) {
                    types[cnt]=type;
                    num[cnt++]++;
                }
                else num[index_tmp]++;
            }
            int ans=1;
            for (int j=0;j<cnt;j++) ans*=num[j]+1;
            ans-=1;
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getItemIndex(String[] types, String t, int cnt) {
        for (int i=0;i<cnt;i++) {
            if (types[i].equals(t)) return i;
        }
        return -1;
    }
}