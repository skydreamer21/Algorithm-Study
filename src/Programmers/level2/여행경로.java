import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    static int len;
    static boolean[] visited;
    static HashMap<String, ArrayList<Integer>> adjList = new HashMap<>();
    static Deque<String> path = new ArrayDeque<>();
    static boolean findAns = false;

    public String[] solution(String[][] tickets) {
        len = tickets.length;
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

        String depart, arrival;
        for (int i=0;i<len;i++) {
            depart = tickets[i][0];
            if (!adjList.containsKey(depart)) {
                adjList.put(depart, new ArrayList<>());
            }
            adjList.get(depart).add(i);
        }

        visited = new boolean[len];
        path.add("ICN");
        dfs(0, "ICN", tickets);

        String[] answer = path.toArray(new String[0]);
        return answer;
    }

    public static void dfs(int depth, String node, String[][] tickets) {
        // System.out.printf("[IN] depth : %d, node : %s\n", depth ,node);
        if (depth == len) {
            findAns = true;
            // System.out.printf("[OUT - findAns(Last)] depth : %d, node : %s\n", depth ,node);
            return;
        }

        if (adjList.get(node) == null) {
            // System.out.printf("[OUT - findAns(Last)] depth : %d, node : %s\n", depth ,node);
            return;
        }
        for (int ticketIdx : adjList.get(node)) {
            if (visited[ticketIdx]) continue;
            visited[ticketIdx] = true;
            path.add(tickets[ticketIdx][1]);
            dfs(depth+1, tickets[ticketIdx][1], tickets);
            if (findAns) {
                // System.out.printf("[OUT - findAns] depth : %d, node : %s\n", depth ,node);
                return;
            }
            path.pollLast();
            visited[ticketIdx] = false;
        }
        // System.out.printf("[OUT - Searched All] depth : %d, node : %s\n", depth ,node);
    }
}