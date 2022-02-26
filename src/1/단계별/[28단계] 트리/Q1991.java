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


public class Q1991 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        treeNode
        int root,left,right;
        String S;
        while (N-- >0) {
            S = br.readLine();
            root = S.charAt(0)-'A';
            left = (S.charAt(2)=='.') ? -1 : S.charAt(2)-'A';
            right = (S.charAt(4)=='.') ? -1 : S.charAt(4)-'A';




        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class treeNode {
    treeNode left;
    treeNode right;
    int size;

// treeNode 배열로 만들어서 하려고하는데 생성자를 어떻게 고쳐야함
    public treeNode (int data) {
        this.size=1;
    }

    public void addLeft (treeNode left) {
        this.left = left;
        size += left.size;
    }

    public void addRight (treeNode right) {
        this.right = right;
        size += right.size;
    }

    public int getSize() {
        return this.size;
    }

}

