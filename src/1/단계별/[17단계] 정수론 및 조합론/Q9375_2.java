// 9375번 패션왕 신해빈

/*
<문제 정보>
 1. 의상의 종류와 이름이 주어졌을 때 알몸이 아닌 상태로 의상을 입을 수 있는 경우의 수
 2. 의상 수 1<=n<=30
 3. 같은 종류의 의상은 하나만 입을 수 있다.

<프로그램 진행>
 1. HashMap

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Q9375_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        HashMap<String,Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N;
        String type;
        int ans;
        while(T-->0) {
            ans = 1;
            hm.clear();
            N = Integer.parseInt(br.readLine());
            while (N-->0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                type = st.nextToken();
                if (hm.containsKey(type)) hm.put(type,hm.get(type)+1);
                else hm.put(type,1);
            }
            for (int num : hm.values()) ans*=num+1;
            sb.append(ans-1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}