import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// StringBuilder에 입력
// ArrayList : 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다.
public class Q1158_other {
    public static void main(String[] args) throws IOException {
        solving();
    }

    private static void solving() throws IOException {
        // 1. N K 를 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        int pplNum = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int nowIdx = K-1;
        // 2. 1번부터 N까지의 정수를 입력한다.
        List<Integer> list = new ArrayList<>(pplNum);
        for (int i = 1; i <= pplNum; i++) list.add(i);
        // 초기 입력
        sb.append("<");
        int deletedNum;
        int lastIdx;
        // 3. 배열이 빌 때까지 반복한다. (while문)
        while (list.size() > 1) {
            // 4. K번째 인덱스 제거
            lastIdx = list.size() -1;
            if (nowIdx< lastIdx)
                deletedNum = list.remove(nowIdx);   // 인덱스로 제거
                // 4-1. 길이가 인덱스 길이보다 큰 경우
            else if (nowIdx > lastIdx) {
                nowIdx = nowIdx - list.size();   // 길이만큼 빼기
                if (nowIdx <= lastIdx)
                    deletedNum = list.remove(nowIdx);
                else continue;
            }
            // 4-2. 인덱스가 같은 경우
            else {
                deletedNum = list.remove(nowIdx);
            }
            // 5. sb에 추가하고 인덱스 +K을 한다.
            sb.append(deletedNum).append(", ");
            nowIdx= nowIdx + K -1;   // size가 1 작아지므로 index도 -1을 빼준다.
        }
        sb.append(list.get(0)).append(">");
        // 6. 출력
        System.out.println(sb);
    }
}