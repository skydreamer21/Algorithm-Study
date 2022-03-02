// 5639번 이진 검색 트리
/*
<문제 정보>
 1. BST PreOrder가 주어질때 PostOrder 결과 구하기

<변수 범위>
 1. 1초 / 256MB
 2. 노드의 수 10,000개 이하
 3. 노드의 키값은 1,000,000 보다 작은 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Q5639 {
    static ArrayList<Integer> pre;
    static int[] in;
    static int[] post;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        pre = new ArrayList<>();
        String s;
        while(true) {
            s = br.readLine();
            if(s==null || s.equals("")) break;
            pre.add(Integer.parseInt(s));
        }
        int len = pre.size();
        in = new int[len];
        for (int i=0;i<len;i++) in[i] = pre.get(i);
        Arrays.sort(in);
        post = new int[len];
        getPostOrder(0,0,len,len-1,0);
        for (int n : post) sb.append(n).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPostOrder (int preS, int inS, int len, int postIdx, int level) {
        //System.out.printf("[IN - level : %d]\n",level);
        //System.out.printf("preS : %d, inS : %d, len : %d, postIdx : %d\n",preS,inS,len,postIdx);
        if(len==0) return;
        int root = pre.get(preS);
        //int preE = preS+len-1;
        int inE = inS+len-1;
        post[postIdx] = root;
        if(len==1) return;
        /*
        1. root In_idx 찾기
        2. left len, right len 찾기
        3. left, right 재귀함수
         */
        int in_root = BS(root, inS, inS+len-1);
        //System.out.printf("root : %d, root index : %d\n",root, in_root);
        //System.out.println();
        int left_len = in_root - inS;
        int right_len = inE-in_root;
        getPostOrder(preS+1,inS,left_len,postIdx-1-right_len,level+1);
        getPostOrder(preS+1+left_len,in_root+1,right_len,postIdx-1,level+1);

    }

    public static int BS (int key, int s, int e) {
        int lo = s;
        int hi = e;
        int mid;
        while (lo<=hi) {
            mid = (lo+hi)/2;
            if (in[mid]==key) return mid;
            else if (in[mid]<key) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }

}



























