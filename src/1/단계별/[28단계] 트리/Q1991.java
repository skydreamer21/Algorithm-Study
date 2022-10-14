// 1991번 트리 순회
/*
<문제 정보>
 1. 전위순회, 중위순화, 후위순회한 결과 출력

<변수 범위>
 1. 2초 / 128MB
 2. 이진트리 노드의 개수 26 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Q1991 {
    static Tree t;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        t = new Tree(N);
        int root,left,right;
        String S;
        while (N-- >0) {
            S = br.readLine();
            root = S.charAt(0)-'A';
            left = (S.charAt(2)=='.') ? -1 : S.charAt(2)-'A';
            right = (S.charAt(4)=='.') ? -1 : S.charAt(4)-'A';
            if (left!=-1) t.addLeft(root, left);
            if (right!=-1) t.addRight(root, right);
        }
        PreOrder();
        sb.append("\n");
        InOrder();
        sb.append("\n");
        PostOrder();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void PreOrder() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0); // root(1) 추가
        int now;

        while(!stack.isEmpty()) {
            now = stack.pollLast();
            sb.append((char)(now+'A'));
            for (int i=0;i<2;i++) {
                if (i==0 && t.get(now).right!=null) stack.add(t.get(now).right.getData());
                if (i==1 && t.get(now).left!=null) stack.add(t.get(now).left.getData());
            }
        }
    }

    public static void InOrder() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        int now;
        int left;
        int right;

        while(!stack.isEmpty()) {
            now = stack.pollLast();
            if (t.get(now).left!=null) {
                left = t.get(now).left.getData();
                if(!t.visited[left]) {
                    stack.add(now);
                    stack.add(left);
                    continue;
                }

            }
            sb.append((char)(now+'A'));
            t.visited[now]=true;
            if (t.get(now).right!=null) {
                right = t.get(now).right.getData();
                stack.add(right);
            }
        }
    }

    public static void PostOrder() {
        t.clear();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        int now;
        int left;
        int right;

        while(!stack.isEmpty()) {
            now = stack.pollLast();
            if (!t.get(now).isLeftNull()) {
                left = t.get(now).left.getData();
                if (!t.visited[left]) {
                    stack.add(now);
                    stack.add(left);
                    continue;
                }
            }
            if (!t.get(now).isRightNull()) {
                right = t.get(now).right.getData();
                if (!t.visited[right]) {
                    stack.add(now);
                    stack.add(right);
                    continue;
                }
            }
            sb.append((char)(now+'A'));
            t.visited[now]=true;
        }
    }
}

class treeNode {
    int data;
    treeNode left;
    treeNode right;

    public treeNode (int data) {
        this.data = data;
    }
    public int getData () {
        return this.data;
    }

    public boolean isLeftNull() {
        return left==null;
    }
    public boolean isRightNull() {
        return right==null;
    }
}

class Tree {
    treeNode[] tree;
    boolean[] visited;

    public Tree(int size) {
        tree = new treeNode[size];
        visited = new boolean[size];
        for (int i=0;i<size;i++) tree[i] = new treeNode(i);
    }

    public void addLeft(int root, int left) {
        this.tree[root].left = tree[left];
    }

    public void addRight(int root, int right) {
        this.tree[root].right = tree[right];
    }

    public treeNode get(int i) {
        return this.tree[i];
    }

    public void clear() {
        Arrays.fill(visited,false);
    }
}






























