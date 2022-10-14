// 13305번 주유소

/*
<문제 정보>
 1. 기름통 크기 무제한
 2. 1km 당 기름 1L
 3. 도시마다 L당 가격이 주어짐
 4. 도시간 도로의 길이가 각각 주어짐
 5. 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소 비용 출력
 6. 도시 N개 1<=N<=100,000   /   L당 가격과 도로 거리 모두 1,000,000,000 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q13305 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] roads = new int[N-1];
        int[] stations = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N-1;i++) roads[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) stations[i] = Integer.parseInt(st.nextToken());
        int start=find_min_idx(stations,0,N-2);
        //System.out.println(start);
        int end = N-2;
        int tmp_sum=0;
        long cost=0;
        while (true) {
            for (int i=start;i<=end;i++) tmp_sum+=roads[i];
            //System.out.print("부분합 : ");
            //System.out.println(tmp_sum);
            cost+=(long)stations[start]*tmp_sum;
            if (start ==0) break;
            end = start-1;
            start = find_min_idx(stations,0,end);
            //System.out.println(start);
            tmp_sum=0;
        }
        bw.write(String.valueOf(cost));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find_min_idx (int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;
        int min_idx=start;
        for (int i=start;i<=end;i++) {
            if (arr[i]<min) {
                min = arr[i];
                min_idx=i;
            }
        }
        return min_idx;
    }
}