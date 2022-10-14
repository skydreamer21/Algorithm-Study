// 11650번 좌표 정렬하기

/*
<문제 정보>
 1. 2차원 평면 점 N개가 있을 때, x좌표가 증가하는 순으로 나열.
 2. 만약 x좌표가 같다면 y좌표가 증가하는 순서로 정렬
 3. 1<=N<=100,000 / x, y좌표는 절댓값이 100,000을 넘지않는 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Q11650_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<P4> arr = new ArrayList<>();
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new P4(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr);
        for (P4 point : arr) {
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class P4 implements Comparable<P4>{
    int x,y;

    public P4 (int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo (P4 o) {
        return (this.x==o.x) ? this.y-o.y : this.x-o.x;
    }
}



