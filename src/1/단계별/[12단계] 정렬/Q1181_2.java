// 1181번 단어 정렬

/*
<문제 정보>
 1. 알파벳 소문자로 이루어진 N개의 단어 정렬
 2. 길이가 짧은 것부터 -> 길이가 같으면 사전 순으로
 3. 1<=N<=20,000, 문자열의 길이는 50을 넘지 않음
 4. 같은 단어가 여러번 입력된 경우에는 한번씩만 출력

<프로그램 진행>
 1. Arrays.sort


<필요 함수>
 1.

 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q1181_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i=0;i<N;i++) arr[i]=br.readLine();
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare (String o1, String o2) {
                if (o1.length()==o2.length()) return o1.compareTo(o2);
                else return o1.length()-o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append("\n");
        for (int i=1;i<N;i++) {
            if (!arr[i].equals(arr[i-1])) sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}