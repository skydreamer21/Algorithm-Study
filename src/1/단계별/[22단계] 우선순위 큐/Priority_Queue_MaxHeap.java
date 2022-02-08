// Priority Queue 구현
/*

<구현 목록>
 1. 최대 힙
    - 최소 힙 만들기
    - 삽입
    - 삭제

 */

import java.io.*;
import java.util.StringTokenizer;

public class Priority_Queue_MaxHeap {
    static int[] empty = {0,1,3,7,15};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[100];
        for (int i=1;i<=size;i++) arr[i] = Integer.parseInt(st.nextToken());
        display_Heap(arr, size);
        Build_MaxHeap(arr,size);
        System.out.println("\n--------------------\n");
        display_Heap(arr, size);
        System.out.println("\n--------------------\n");
        delete(arr,size--);
        display_Heap(arr, size);
        System.out.println("\n--------------------\n");
        push(arr,10,size++);
        display_Heap(arr, size);

        bw.flush();
        bw.close();
        br.close();
    }

    // idx 위치부터 Min_Heap의 모양을 만듬.
    // 재귀와 반복문 모두 구현 가능

    /*
    Min_Heapify
        - 지정된 한개의 노드와 자식간의 관계를 Min_Heap형태로 만들어줌.
        - 이 때 swap이 일어난다면 바뀐 자식노드의 자식노드도 Min_Heap인지 체크하고 바꿈.
        - 어떠한 하나의 노드만 제외 하고 모두 Min_Heap일 때 쓰는 함수라고 생각하면 편함.
     */
    public static void Max_Heapify(int[] arr, int root, int size) {
        int left = 2*root;
        int right = 2*root+1;
        int max = root;
        if (left<=size && arr[left]>arr[max]) max = left;
        if (right<=size && arr[right]>arr[max]) max = right;
        if (max!=root) {
            swap(arr, root, max);
            Max_Heapify(arr,max,size);
        }
    }

    public static void Max_Heapify_up(int[] arr, int child) {
        int root = child/2;
        if (root!=0 && arr[child]>arr[root]) {
            swap(arr,root,child);
            Max_Heapify_up(arr,root);
        }
    }

    public static void Build_MaxHeap (int[] arr, int size) {
        // 마지막으로 자식노드를 가지는 노드
        int root = size/2;
        while (root>0) Max_Heapify(arr,root--,size);
    }

    public static void push(int[] heap, int n, int size) {
        heap[size+1] = n;
        Max_Heapify_up(heap,size+1);
    }

    public static void delete(int[] heap, int size) {
        heap[0]=heap[size];
        Max_Heapify(heap,0,size);
    }






    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void display_Heap (int[] arr, int size) {
        int height = (int)Math.ceil(Log_baseN(size+1));
        int line;
        int idx=1;
        for (int i=height;i>=1;i--) {
            line = height-i+1;
            int cnt = (int)Math.round(Math.pow(2,line-1));
            for (int j=0;j<empty[i];j++) System.out.print(" ");
            for (int j=0;j<cnt;j++) {
                System.out.print(arr[idx++]);
                if (idx>size) break;
                if (j!=cnt-1) {
                    for (int k=0;k<empty[i+1];k++) System.out.print(" ");
                }
            }
            if (idx>size) break;
            for (int j=0;j<empty[i];j++) System.out.print(" ");
            System.out.println();
        }
    }

    public static double Log_baseN (int num) {
        return Math.log10(num)/Math.log10(2);
    }
}