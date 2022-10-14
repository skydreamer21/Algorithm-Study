// 14003번 가장 긴 증가하는 부분 수열5
/*
<문제 정보>
 1. LIS

<변수 범위>
 1. 3초 / 512MB
 2. 수열의 크기 1<=N<=1,000,000
 3. 수열의 각 수 -1,000,000,000<=A_i<=1,000,000,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q14003_repeat {
    static int[] arr;
    static int[] memo;
    static Integer[] path;
    static int len=1; // 개수 & 다음에 memo에 삽입되어야할 idx


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int R = 1;
        while (R-->0) {
            len=1;
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            memo = new int[N];
            path = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[0]=memo[0]=Integer.parseInt(st.nextToken());

            //System.out.printf("i : %d\n",0);
            //System.out.println(Arrays.toString(memo));
            //System.out.println();

            int MaxIdx=0;
            for (int i=1;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(upperBound_insert(i)) {
                    MaxIdx=i;
                    sb.append(MaxIdx).append(" ");
                }

            System.out.printf("i : %d\n",i);
            System.out.print("memo : ");
            System.out.println(Arrays.toString(memo));
            System.out.print("path : ");
            System.out.println(Arrays.toString(path));
            System.out.println();


            }
            sb.append("\n");

            int[] LIS = new int[len];
            int idx=len-1; // LIS 배열에 집어넣을 index;
            int tmp_idx=MaxIdx; // path값 따라서 추적할 idx
            System.out.printf("mi : %d\n",tmp_idx);
            LIS[idx--]=arr[MaxIdx];
            for (int i=MaxIdx-1;i>=0;i--) {
                //System.out.printf("현재 i : %d\n",i);
                //System.out.printf("arr : %d, path : %d\n",arr[i],path[tmp_idx]);
                if(path[tmp_idx]==null) break;
                if(arr[i]==path[tmp_idx]) {
                    //System.out.printf("추척 i : %d\n",i);
                    LIS[idx--]=arr[i];
                    tmp_idx=i;
                }
            }
            sb.append(len).append("\n");
            for (int n : LIS) sb.append(n).append(" ");

            //이친구 없앨 대상
            sb.append("\n");

            //// 반복 끝
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    //memo에 알맞은 자리에 삽입
    public static boolean upperBound_insert (int idx) {
        int lo=0;
        int hi=len;
        int mid;
        boolean getMax=false;
        while(lo<hi) {
            mid = (lo+hi)/2;
            if (memo[mid]==arr[idx]) {
                if(mid>0) path[idx]=memo[mid-1];
                return false;
            }
            if (memo[mid]<arr[idx]) lo = mid+1;
            else hi=mid;
        }
        if(lo==len) {
            len++;
            getMax=true;
        }
        memo[lo]=arr[idx];
        path[idx]= (lo==0) ? null : memo[lo-1];
        return getMax;
    }
}
