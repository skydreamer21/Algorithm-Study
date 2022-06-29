/*
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    static HashMap<String, Integer> courses;
    static ArrayList<String> courseConfirmed = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for (int N : course) {
            courses = new HashMap<>(); // HashMap 초기화
            for (String menu : orders) {
                char[] foods = menu.toCharArray();
                if (N > foods.length) continue;
                Arrays.sort(foods);
                char[] combination = new char[N];
                getCourse(N, 0, 0, foods, foods.length, combination);
            }

            // 최댓값으로 바꿔야함
            int maxCount = 2;
            int count;
            Deque<String> stack = new ArrayDeque<>();
            for (Entry<String, Integer> entry : courses.entrySet()) {
                count = entry.getValue();
                if (count < maxCount) continue;

                if (count > maxCount) {
                    stack.clear();
                    maxCount = count;
                }
                stack.add(entry.getKey());
            }
            while(!stack.isEmpty()) courseConfirmed.add(stack.pollLast());
        }

        Collections.sort(courseConfirmed);
        int size = courseConfirmed.size();
        String[] answer = new String[size];
        for (int i=0;i<size;i++) answer[i] = courseConfirmed.get(i);
        return answer;
    }

    // menu를 N개의 combination으로 나눠 HashMap에 저장
    public static void getCourse (int N, int depth, int next, char[] foods, int len, char[] combination) {
        if (depth == N) {
            String course = String.valueOf(combination);
            if (!courses.containsKey(course)) courses.put(course, 1);
            else courses.replace(course, courses.get(course)+1);
            return;
        }

        if (next == len) return;

        for (int i=next;i<len;i++) {
            combination[depth] = foods[i];
            getCourse(N, depth+1, i+1, foods, len, combination);
        }

    }
}
*/