// 6209번 제자리 멀리뛰기 (G2)
// 22.3.7 pm 6:00 ~ 7:07 (1차 구현)
/*
<문제 정보>
 1. m개 작은 돌섬 제거한 뒤 학생들이 점프할 수 있는 최소거리의 최댓값 출력

<변수 범위>
 1. 1초 / 128MB
 2. 탈출구까지의 거리 1<=d<=1,000,000,00
 3. 돌섬의 수 0<=n<=50,000
 4. 제거할 수 있는 돌섬 수 (0<=m<=n)

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q6209_2 {
    static int D;
    static int N;
    static int[] isld;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        isld = new int[N+2];
        for (int i=1;i<=N;i++) isld[i]=Integer.parseInt(br.readLine());
        isld[N+1]=D;
        Arrays.sort(isld);
        bw.write(String.valueOf(f_BS(N-M+1)));

        bw.flush();
        bw.close();
        br.close();
    }

    // 최소 key조각이 나오려면 최소거리가 뭐보단 작아야 되냐? -> upperBound
    public static int f_BS (int key) {
        int lo = 0;
        int hi = D+1;
        int mid;
        int temp;
        int debug=0;
        while(lo<hi) {
//            if(debug++>100) break;
            mid = (lo+hi)/2;

            temp = f(mid);
//            System.out.printf("minD : %d, f(%d) : %d\n",mid,mid,temp);

            if(temp>=key) lo=mid+1;
            else hi=mid;
        }
        return lo-1;
    }

    // 주어진 거리 이상으로 자를 때 생기는 최대 조각 수
    public static int f (int dis) {
//        System.out.printf("f in,  dis : %d\n",dis);

        int start=0;
        int cnt=0;
        int debug=0;
        while(D>=isld[start]+dis) {
//            if(debug++>200) break;
            cnt++;
//            System.out.printf("start : %d, isld : %d, cnt : %d, ",start,isld[start],cnt);
            start=BS_up(isld[start]+dis,start);
//            System.out.printf("new start : %d\n",start);
            if(start==N+2) break;
            /*if (start==N+1 || start==N+2) {
                cnt--;
                break;
            }*/
        }
        return cnt;
    }

    public static int BS_up (int key, int start) {
        int lo = start;
        int hi = N+2;
        int mid;
        int debug=0;
        while(lo<hi) {
            mid=(lo+hi)/2;
//            System.out.printf("lo : %d, hi : %d, mid : %d, isld : %d\n",lo,hi,mid,isld[mid]);
//            if(debug++>100) break;
            if (isld[mid]==key) return mid;
            if(isld[mid]<key) lo = mid+1;
            else hi=mid;
        }
        return lo;
    }
}













