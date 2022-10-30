// 1781번 컵라면 (G2) [우선순위큐]
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1781 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        int N = Integer.parseInt(br.readLine());
        Question[] questions = new Question[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int rewards = Integer.parseInt(st.nextToken());
            questions[i] = new Question(deadLine, rewards);
        }

        // ******************** 메인 로직 ********************
        Arrays.sort(questions);
        PriorityQueue<Question> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.rewards));

        for (Question question : questions) {
            int maxQuestion = question.deadLine;
            int size = pq.size();

            if (size < maxQuestion) {
                pq.add(question);
            }

            else if (size == maxQuestion && pq.peek().rewards < question.rewards) {
                pq.poll();
                pq.add(question);
            }
        }

        int totalRewards = 0;
        while (!pq.isEmpty()) {
            totalRewards += pq.poll().rewards;
        }

        // ******************** 정답 출력 ********************
        sb.append(totalRewards);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Question implements Comparable<Question> {
    int deadLine, rewards;

    public Question (int deadLine, int rewards) {
        this.deadLine = deadLine;
        this.rewards = rewards;
    }

    @Override
    public int compareTo (Question o) {
        return this.deadLine == o.deadLine ? o.rewards - this.rewards : this.deadLine - o.deadLine;
    }
}