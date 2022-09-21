package Programmers.level2;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Arrays;

class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));

        Deque<String> q = new ArrayDeque<>();
        q.add(begin);
        visited.add(begin);

        String now;
        int size;
        int dist = 0;

        while(!q.isEmpty()) {
            dist++;
            size = q.size();

            for (int i=0; i<size; i++) {
                now = q.poll();

                for (String word : wordSet) {
                    if (!visited.contains(word) && checkConvertable(now.toCharArray(), word.toCharArray())) {
                        if (word.equals(target)) return dist;
                        visited.add(word);
                        q.add(word);
                    }
                }
            }
            wordSet.removeAll(visited);
        }
        return 0;
    }

    public static boolean checkConvertable(char[] from, char[] to) {
        int len = from.length;
        boolean isConverted = false;
        for (int i=0; i<len; i++) {
            if (from[i] != to[i]) {
                if (isConverted) return false;
                else isConverted = true;
            }
        }
        return isConverted;
    }
}