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

// 배열로 left, right 를 두어서 하는 것도 가능 (알고리즘은 덱을 쓰는것이랑 같음)
// LinkedList 가 리사이징이 없어서 시간적으로 유리한가? (38302354 - nudeactor  94904KB / 772ms)
// 38169723	quack337 78388KB 752ms
// 37590079	dlwoduq78	73420	660
// 37428147	linexy   72824	560

// 가정 일단 배열로 했을 때 좀더 빠르고, StringTokenizer delim이 적을수록 (substring),
// 명령을 char배열로 쓸 수록 빨라지는 듯.

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q5430 {
    final static boolean LEFT = true;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> q = new ArrayDeque<>();
        int T = Integer.parseInt(br.readLine());
        String S; int N;
        boolean direction;
        boolean possible;
        while (T-->0) {
            possible = true;
            direction = LEFT;
            S = br.readLine();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[,]");
            while(N-->0) q.add(Integer.parseInt(st.nextToken()));
            for (int i=0;i<S.length();i++) {
                if (S.charAt(i)=='R') direction=!direction;
                else if (q.isEmpty()) {
                    possible=false;
                    break;
                }
                else {
                    if (direction==LEFT) q.pollFirst();
                    else q.pollLast();
                }
            }
            if (possible) {
                sb.append('[');
                if (direction==LEFT && !q.isEmpty()) {
                    while(q.size()>1) sb.append(q.pollFirst()).append(',');
                    sb.append(q.pollFirst());
                }
                else if (direction!=LEFT && !q.isEmpty()) {
                    while(q.size()>1) sb.append(q.pollLast()).append(',');
                    sb.append(q.pollLast());
                }
                sb.append(']').append("\n");
            }
            else sb.append("error").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}