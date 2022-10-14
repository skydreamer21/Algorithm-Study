/*
import java.util.ArrayList;

class Solution {
    static final int COMPLETE = 100;
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int days = 0;
        int workToBeDone = 0;
        int count;
        ArrayList<Integer> ans = new ArrayList<>();
        while(workToBeDone<len) {
            days++;
            dayAfter(progresses, speeds);
            count = 0;
            for (int i=workToBeDone;i<len;i++) {
                if (progresses[i]<COMPLETE) break;
                count++;
            }
            if (count>0) ans.add(count);
            workToBeDone += count;
        }
        int size = ans.size();
        int[] answer = new int[size];
        for (int i=0;i<size;i++) answer[i] = ans.get(i);
        return answer;
    }

    public static void dayAfter(int[] progresses, int[] speeds) {
        int N = progresses.length;
        for (int i=0;i<N;i++) progresses[i] += speeds[i];
    }
}*/
