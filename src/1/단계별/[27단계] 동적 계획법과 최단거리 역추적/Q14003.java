import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q14003 {
    static int[] arr;
    static int[] memo;
    static Integer[] path;
    static int len=1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N];
        path = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr[0]=memo[0]=Integer.parseInt(st.nextToken());

        int MaxIdx=0;
        for (int i=1;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(upperBound_insert(i)) MaxIdx=i;

        }

        int[] LIS = new int[len];
        int idx=len-1;
        int tmp_idx=MaxIdx;
        LIS[idx--]=arr[MaxIdx];
        for (int i=MaxIdx-1;i>=0;i--) {
            if(path[tmp_idx]==null) break;
            if(arr[i]==path[tmp_idx]) {
                LIS[idx--]=arr[i];
                tmp_idx=i;
            }
        }

        sb.append(len).append("\n");
        for (int n : LIS) sb.append(n).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

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
        //path
        path[idx]= (lo==0) ? null : memo[lo-1];
        return getMax;
    }
}