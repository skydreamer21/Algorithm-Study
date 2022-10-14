// 18258번 큐2
/*
<문제 정보>
 1. 정수를 저장하는 큐를 구현
    - push X : 정수 X를 큐 맨 뒤에 넣음
    - pop : 가장 앞에 있는 정수를 빼고 그 수를 출력. (없으면 -1)
    - size
    - empty
    - front : 가장 앞에 있는 정수 출력 (없으면 -1)
    - back : 가장 뒤에 있는 정수 출력 (없으면 -1)
 2. 명령의 수 N 2,000,000 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.StringTokenizer;
import Necessary_Class.MyQueue_Arr;

public class Q18258 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        MyQueue_Arr queue = new MyQueue_Arr(N);
        StringTokenizer st;
        String S;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            S = st.nextToken();
            switch(S) {
                case "push" :
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(queue.isEmpty()).append("\n");
                    break;
                case "front" :
                    sb.append(queue.front()).append("\n");
                    break;
                case "back" :
                    sb.append(queue.back()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}