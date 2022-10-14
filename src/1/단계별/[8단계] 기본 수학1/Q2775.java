// 2775번 부녀회장이 될테야

/*
<문제 정보>
 1. a층의 b호에 살려면 자신의 아래층(-> (a-1)층)의 1호부터 b호까지
 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
 2. 0층부터 있고 0층의 i호에는 i명이 산다.
 3. k층의 n호에는 몇 명 살고 있는지 출력

<프로그램 진행>

<필요 함수>
1. int 배열과 N을 넣어서 배열의 처음부터 N개의 수를 합한 값 return
2. int 배열을 넣어서 다음 층에 살고있는 사람들 수가 담긴 int배열 return
3. 초기배열 생성
 */

import java.io.*;

public class Q2775 {
    public static int getSum(int[] arr, int N) {
        int sum=0;
        for (int i=0;i<=N;i++) sum+=arr[i];
        return sum;
    }

    public static int[] getNextFloor(int[] arr) {
        int[] nextFloor = new int[arr.length];
        for (int i=0;i<arr.length;i++) nextFloor[i] = getSum(arr, i);
        return nextFloor;
    }

    public static int[] getfirstFloor(int N) {
        int[] firstFloor = new int[N];
        for(int i=0;i<N;i++) firstFloor[i]=i+1;
        return firstFloor;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());
        int k;
        int n;
        int[] firstFloor;
        int[] temp;
        int people;
        for (int i=0;i<T;i++) {
            k=Integer.parseInt(br.readLine());
            n=Integer.parseInt(br.readLine());
            firstFloor = getfirstFloor(n);
            temp = firstFloor;
            for (int j=0;j<k;j++) temp = getNextFloor(temp);
            people = temp[n-1];
            bw.write(people+"\n");
        }
        bw.flush();
        bw.close();
    }
}






