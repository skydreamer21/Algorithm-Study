// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class demo {
    static int N;
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> order = new ArrayList<>();
        int[] count = new int[101]; // count[4] = 3;
//        int ord = 0;
        //  input :  2 7 5 9 4 1 2 3 5
        // (2,0) (7,1) (5, 2) (9,3)....

        // order : 2 7 5 9 4 1 3

        // 검색 : O(1) -> CountingSort

        // 0 1 2 3 4 5 6 7 8 9 10
        //   1 2 1 1 2   1   1       -> count

        // 입력
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (count[arr[i]]==0) order.add(arr[i]);
            count[arr[i]]++;
        }

//        Collections.sort(order);

        // 4 3 5 5 5 5 1 1

        // order : 4 3 5 1
        // count 0 1 2 3 4 5 6 7 8 ....
        //         2   1 1 4

        for (int p : order) {
            if (count[p]>1) sb.append(count[p]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

/*class Pair100 implements Comparable<Pair100>{
    int num;
    int order;

    public Pair100 (int num, int order) {
        this.num = num;
        this.order = order;
    }

    @Override
    public int compareTo(Pair100 o) {
        return this.order - o.order;
    }
}*/












