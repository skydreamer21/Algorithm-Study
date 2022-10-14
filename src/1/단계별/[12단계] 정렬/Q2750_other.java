// 주어지는 숫자를 배열의 인덱스로 넣음
// 절댓값이 1000보다 작은 걸 이용해 총 2000 크기인 배열을 잡음

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q2750_other {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2001];

        for(int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000] = true;
        }

        for(int i = 0; i < 2001; i++) {
            if(arr[i]) {
                sb.append(i - 1000).append('\n');
            }
        }
        System.out.println(sb);
    }
}