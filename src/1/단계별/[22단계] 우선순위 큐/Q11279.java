// 11279번 최대 힙
/*
<문제 정보>
 1. 최대힙을 이용해서 다음 연산 구현
    - 배열에 자연수 x를 넣는다.
    - 0이 입력되면 배열에서 가장 큰 값을 출력하고 그값을 배열에서 제거
    (비어있는데도 0이 있다면 0 출력)

<변수 범위>
 1. 연산의 개수 N 1<=N<=100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.Arrays;

public class Q11279 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Max_Heap heap = new Max_Heap(N);
        while (N-->0) {
            int X = Integer.parseInt(br.readLine());
            if (X==0) sb.append(heap.pop()).append("\n");
            else heap.push(X);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Max_Heap {
    int[] arr;
    int size;

    public Max_Heap (int N) {
        this.arr = new int[N];
        this.size=0;
    }

    public void push (int n) {
        this.arr[this.size+1] = n;
        this.size++;
        max_heapify_up(size);
        //System.out.printf("<push %d>\n",n);
        //System.out.println(Arrays.toString(this.arr));
        //System.out.printf("size : %d\n\n",size);
    }

    public int pop() {
        if (this.size==0) return 0;
        int result = this.arr[1];
        this.arr[1] = this.arr[this.size];
        this.arr[this.size]=0;
        this.size--;
        max_heapify_down(1);
        //System.out.println("<pop>");
        //System.out.println(Arrays.toString(this.arr));
        //System.out.printf("size : %d\n\n",size);
        return result;
    }

    public void max_heapify_down(int root) {
        int left = 2*root;
        int right = 2*root+1;
        int max = root;
        if (left<=this.size && this.arr[left]>this.arr[max]) max = left;
        if (right<=this.size && this.arr[right]>this.arr[max]) max = right;
        if (max!=root) {
            swap(root,max);
            max_heapify_down(max);
        }
    }

    public void max_heapify_up (int child) {
        int root = child/2;
        if (root!=0 && this.arr[child]>this.arr[root]) {
            swap(root, child);
            max_heapify_up(root);
        }
    }

    public void swap(int index1, int index2) {
        int temp = this.arr[index1];
        this.arr[index1] = this.arr[index2];
        this.arr[index2] = temp;
    }
}