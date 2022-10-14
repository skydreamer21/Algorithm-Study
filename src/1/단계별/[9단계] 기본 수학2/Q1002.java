// 1002번 터렛

/*
<문제 정보>
 1. 특정 점에서 두 지점까지의 거리가 주어지고 두 지점의 좌표가 주어질 때
 특정 점이 될 수 있는 개수 구하기
 2. -> 두 원의 중심과 반지름이 나와 있을 때 교점의 개수 찾기

<프로그램 진행>
 1. 중심과 중심사이 거리와 반지름을 합한 값 비교
 2. 합 뿐만아니라 차이도 고려를 해줘야함.
 3. 큰 틀로 중심이 같을 때, 아닐때 나누고 반지름의 합을 써야할 때랑
 반지름의 차를 써야할 때랑 나누기

<필요 함수>
 1. 점과 점사이 거리 구하기
 2. 중심이 같은지 boolean return

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1002 {
    public static double getDistance (int[] arr) {
        double dis = Math.sqrt(Math.pow(arr[2]-arr[0],2)+Math.pow(arr[3]-arr[1],2));
        return dis;
    }
    public static boolean SameCenter (int[] arr) {
        if(arr[0]==arr[2] && arr[1]==arr[3]) return true;
        else return false;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        String S;
        int[] arr = new int[4];
        int R1;
        int R2;
        double dis;
        int intersection;
        for (int i=0; i<T; i++) {
            S = br.readLine();
            st = new StringTokenizer(S);
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            R1 = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            arr[3] = Integer.parseInt(st.nextToken());
            R2 = Integer.parseInt(st.nextToken());
            dis = getDistance(arr);
            if (SameCenter(arr)) {
                if (R1==R2) intersection = -1;
                else intersection = 0;
            }
            else {
                if (dis > R1+R2) intersection=0;
                else if (dis == R1+R2) intersection=1;
                else {
                    if (dis == Math.abs(R1-R2)) intersection = 1;
                    else if (dis > Math.abs(R1-R2)) intersection = 2;
                    else intersection = 0;
                }
            }
            bw.write(intersection+"\n");
        }
        bw.flush();
        bw.close();
    }
}