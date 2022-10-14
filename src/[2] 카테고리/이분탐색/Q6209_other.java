import java.io.*;
import java.util.*;

public class Q6209_other {
    static int D, M, N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+2];
        arr[N] = D;

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = D;
        int ans = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            //System.out.println("* "+ start + " " + end + " " + mid);

            int pos = 0;
            int cnt = 0;

            for(int i=1; i<=N+1; i++) {
                //System.out.println(arr[i] + " " + arr[pos] + " " + i + " " + pos + " " + cnt);
                if(arr[i] - arr[pos] < mid) {
                    cnt++;
                }
                else {
                    pos = i;
                }
            }

            if(cnt > M) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
//#이진탐색 #binarySearch
/*
while(start <= end) {
	int mid = (start + end) / 2;
	
	if(arr[mid] == target)
		return "O";
	else if(arr[mid] < target)
		start = mid + 1;
	else
		end = mid - 1;
}
*/