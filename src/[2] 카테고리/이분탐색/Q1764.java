// 1764번 듣보잡 - [HashSet, HashMap] [Binary Search]
/*
<문제 정보>
 1. 듣보잡 사전순 출력

<변수 범위>
 1. 2초 / 256MB
 2. 듣, 보 N,M 500,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1764 {
    static int N;
    static String[] neverHeard;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        neverHeard = new String[N];
        for (int i=0;i<N;i++) neverHeard[i]=br.readLine();
        Arrays.sort(neverHeard);
        String neverSaw;
        PriorityQueue<String> pq = new PriorityQueue<>();
        while(M-->0){
            neverSaw=br.readLine();
            if(BS(neverSaw)) pq.add(neverSaw);
        }
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean BS (String key) {
        int lo=0;
        int hi=N-1;
        int mid;

        while(lo<=hi) {
            mid=(lo+hi)/2;
            if(neverHeard[mid].equals(key)) return true;
            else if(neverHeard[mid].compareTo(key)<0) lo=mid+1;
            else hi=mid-1;
        }
        return false;
    }
}
























