import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1991_other {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
// 한쪽 자식이 없으면 0 입력
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            list[data].add(new Node(left, right));
        }

        preorder(5);
        sb.append("\n");
        inorder(5);
        sb.append("\n");
        postorder(5);
        System.out.println(sb.toString());

    }

    // 전위 순회 root - left - right
    static void preorder(int start) {
        for (Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            sb.append(start).append(" ");
            if (l != 0) preorder(l);
            if (r != 0) preorder(r);
        }
    }

    // 중위 순회 left - root - right
    static void inorder(int start) {
        for (Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if (l != 0) inorder(l);
            sb.append(start).append(" ");
            if (r != 0) inorder(r);
        }
    }

    // 후위 순회 left - right - root
    static void postorder(int start) {
        for (Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if (l != 0) postorder(l);
            if (r != 0) postorder(r);
            sb.append(start).append(" ");
        }
    }
}
