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
 1. wordSort <- 길이가 같을 때 사전식 배열

 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q1181 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i=0;i<N;i++) arr[i]=br.readLine();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare (String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        wordSort(arr);
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for (int i=0;i<N-1;i++) {
            if (cnt==0) {
                sb.append(arr[i]).append("\n");
                if (arr[i].equals(arr[i+1])) cnt++;
                else if (i==N-2) sb.append(arr[i+1]).append("\n");
            }
            else if (!arr[i].equals(arr[i+1])) cnt=0;
            //System.out.printf("cnt : %d\n",cnt);

            /*
            if (cnt==0 || arr[i]!=arr[i+1]) {
                if (i!=0 && (cnt!=0 && arr[i]==arr[i-1])) sb.append(arr[i]).append("\n");
                if (arr[i]==arr[i+1]) cnt++;
                else cnt=0;
            }
            else cnt++;
             */
        }
        if (N==1) sb.append(arr[0]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void wordSort (String[] arr) {
        int cnt = 0;
        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].length() == arr[i + 1].length()) {
                if (cnt == 0) startIdx = i;
                if (i == arr.length - 2) {
                    endIdx = i + 1;
                    Arrays.sort(arr, startIdx, endIdx+1);
                }
                cnt++;
            }
            else if (cnt != 0) {
                endIdx = i;
                Arrays.sort(arr, startIdx, endIdx+1);
                cnt = 0;
            }
        }
    }
}