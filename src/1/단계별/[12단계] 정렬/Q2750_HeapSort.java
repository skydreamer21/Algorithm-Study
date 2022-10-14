// 2751번 수 정렬하기2 - HeapSort

/*
<문제 정보>
 1. N개의 수가 주어질 때, 오름차순으로 정렬하는 프로그램 작성
 2. 첫째줄 몇개인지 그다음부터 한줄당 숫자들이 주어짐.
 3. 개수<=1000, 주어지는 수는 중복되지 않고 절댓값이 1000보다 작거나 같은 정수

<프로그램 진행>
 1. HeapSort

<필요 함수>
 1.
 */

import java.io.*;

public class Q2750_HeapSort {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] heap = new int[N];
        for (int i=0;i<N;i++) heap[i]=Integer.parseInt(br.readLine());
        int size = heap.length;
        int root;
        int child;
        int temp;

        // 힙을 구성
        for (int i=1; i<size;i++) {
            child = i;
            while (child!=0) {
                root = (child-1)/2;
                if(heap[root]<heap[child]) {
                    temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                child = root;
            }
        }

        // 힙 사이즈를 하나씩 줄여가며 힙 구성
        for (int i=size-1;i>=0;i--) {
            temp=heap[0];
            heap[0]=heap[i];
            heap[i]=temp;
            root=0;
            child=1;
            while(child<i) {
                child = 2*root+1;
                if(child<i-1 && heap[child]<heap[child+1]) child++;
                if(child<i && heap[root]<heap[child]) {
                    temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                root = child;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : heap) sb.append(num).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}