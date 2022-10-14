// 11723번 집합
/*
<문제 정보>
 1.

<변수 범위>
 1. 1.5초 / 4MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Q11723 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        String operation;
        int parameter = 0;
        while(N-- >0) {
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken();
            if (!operation.equals("all") && !operation.equals("empty")) parameter = Integer.parseInt(st.nextToken());
            switch(operation) {
                case "add" :
                    hs.add(parameter);
                    break;
                case "remove" :
                    hs.remove(parameter);
                    break;
                case "check" :
                    sb.append(hs.contains(parameter) ? 1 : 0).append("\n");
                    break;
                case "toggle" :
                    if (!hs.contains(parameter)) hs.add(parameter);
                    else hs.remove(parameter);
                    break;
                case "all" :
                    hs.clear();
                    for (int i=1;i<=20;i++) hs.add(i);
                    break;
                case "empty" :
                    hs.clear();
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}





















