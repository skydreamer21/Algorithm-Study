// 5430번 AC

/*
<문제 정보>
 1. 새로운 언어 AC에는 두가지 함수 R(뒤집기), D(첫번째 수 버리기)가 있다.
    - 배열이 비어있는데 D를 사용하면 에러
 2. 수행할 함수가 주어졌을 때 최종 결과를 구하는 프로그램을 작성
 3. 테스트 케이스 최대 100개  /  수행할 함수 개수는 100,000 이하 자연수
    배열안의 수의 개수 N 100,000 이하 정수 /  배열 안 각각 수 100이하 자연수
 4. 에러 발생하면 error 출력

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 배열로 만들시 80936 772
// StringTokenizer 안쓰고 split으로 바로 배열로 저장했더니 (69908, 732) -> (75368, 544)
// char[] 만드는건 효과 X

import java.io.*;
//import java.util.StringTokenizer;

public class Q5430_3 {
    final static boolean LEFT = true;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String S; int N; String numS;
        boolean direction;
        boolean possible;
        int first; int last;
        while (T-->0) {
            possible = true;
            direction = LEFT;
            S = br.readLine();
            N = Integer.parseInt(br.readLine());
            String[] arr;
            first=0; last=N;
            numS = br.readLine();
            arr=numS.substring(1,numS.length()-1).split(",");
            for (char com : S.toCharArray()) {
                if (com=='R') direction=!direction;
                else if (first==last) {
                    possible=false;
                    break;
                }
                else {
                    if (direction==LEFT) first++;
                    else last--;
                }
            }
            if (possible) {
                if(first==last) {
                    sb.append("[]").append("\n");
                    continue;
                }
                sb.append("[");
                if (direction==LEFT) {
                    for(int i=first;i<last-1;i++) sb.append(arr[i]).append(",");
                    sb.append(arr[last-1]);
                }
                else if (direction!=LEFT) {
                    for(int i=last-1;i>first;i--) sb.append(arr[i]).append(",");
                    sb.append(arr[first]);
                }
                sb.append("]").append("\n");
            }
            else sb.append("error").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}