package Programmers.level2;

import java.util.PriorityQueue;

class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);
        int len = scoville.length;
        int first, second;
        boolean findAns = true;
        while (pq.peek() < K) {
            // System.out.printf("peek : %d\n",pq.peek());
            if (pq.size()==1) {
                findAns = false;
                break;
            }
            first = pq.poll();
            second = pq.poll();
            pq.add(first+(2*second));
        }
        return findAns ? len-pq.size() : -1;
    }
}