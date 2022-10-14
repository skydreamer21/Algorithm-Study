import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2629
 * */

//추의 개수 30개 이하
//구슬의 개수는 7개 이하
//구슬의 무게가 400000

//구슬의 무게로 만들 수 있는... 더하거나 뺴거나 사용 안하거나... 3가지의 경우의수를 가짐 조합의 개수를 세야 함npr
//nxn 행렬에

public class Q2629_other {
    static int n;
    static int m;
    static int cnt = 0;
    static int[] numArr;
    static int[][] numArr2 = new int[40][15001]; //DP 여기엔 무게가 가능하다는걸 담아야함.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numArr = new int[n];  //숫자배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        func(0,0); //메모이제이션

        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i<m;i++) {
            int test = Integer.parseInt(str.nextToken());
            if(test>15000) {
                sb.append("N ");
            } else {
                if(numArr2[n][test]==1) {
                    sb.append("Y ");
                } else {
                    sb.append("N ");
                }
            }

        }
        System.out.println(sb);
    }

    // 재귀인데 방식이 Bottom up
    // 못가는데는 아예 들르지를 않음
    // 시간복잡도는 비슷하더라도 반복문보다 조금더 효율적

    public static void func(int cnt, int result) {
        if(numArr2[cnt][result] !=0) return;//어차피 만들 수만 있으면 됨

        numArr2[cnt][result] = 1;// 거쳐가는 건 전부다 됨.
        if(cnt>=n) return;

        //사용하는 경우
        func(cnt+1,Math.abs(result+numArr[cnt]));
        //사용하지 않는 경우
        func(cnt+1,result);
        //반대쪽에 넘기는 경우
        func(cnt+1,Math.abs(result-numArr[cnt]));
    }
}