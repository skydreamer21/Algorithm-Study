// 11286번 절댓값 힙
/*
<문제 정보>
 1. 절댓값 힙을 이용해서 다음 연산 구현
    - 배열에 0이 아닌 정수 X를 넣는다.
    - 0이 입력되면 배열에서 절댓값이 가장 작은 값을 출력하고 배열에서 제거
    - 절댓값이 작은게 여러개이면 가장 작은수 출력하고 그 값을 제거
    (비어있는데도 0이 있다면 0 출력)

<변수 범위>
 1. 연산의 개수 N 1<=N<=100,000
 2. 입력되는 정수는 int 범위

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;

public class Q11286 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        absMin_Heap heap = new absMin_Heap(N);
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

class absMin_Heap {
    int[] arr;
    int size;

    public absMin_Heap (int N) {
        this.arr = new int[N];
        this.size=0;
    }

    public void push (int n) {
        this.arr[this.size+1] = n;
        this.size++;
        absMin_heapify_up(size);
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
        absMin_heapify_down(1);
        //System.out.println("<pop>");
        //System.out.println(Arrays.toString(this.arr));
        //System.out.printf("size : %d\n\n",size);
        return result;
    }

    public void absMin_heapify_down(int root) {
        int left = 2*root;
        int right = 2*root+1;
        int min = root;
        if (left<=this.size) {
            boolean left_check1 = Math.abs(this.arr[left])<Math.abs(this.arr[min]);
            boolean left_check2 = Math.abs(this.arr[left])==Math.abs(this.arr[min]);
            boolean left_check3 = this.arr[left]<this.arr[min];
            if (left_check1 || (left_check2 && left_check3)) min = left;
        }
        if (right<=this.size) {
            boolean right_check1 = Math.abs(this.arr[right])<Math.abs(this.arr[min]);
            boolean right_check2 = Math.abs(this.arr[right])==Math.abs(this.arr[min]);
            boolean right_check3 = this.arr[right]<this.arr[min];
            if (right_check1 || (right_check2 && right_check3)) min = right;
        }
        if (min!=root) {
            swap(root,min);
            absMin_heapify_down(min);
        }
    }

    public void absMin_heapify_up (int child) {
        int root = child/2;
        int val_child = this.arr[child];
        int val_root = this.arr[root];

        if (root!=0 && (Math.abs(val_child)<Math.abs(val_root) ||
                (Math.abs(val_child)==Math.abs(val_root) && val_child<val_root))) {
            swap(root, child);
            absMin_heapify_up(root);
        }
    }

    public void swap(int index1, int index2) {
        int temp = this.arr[index1];
        this.arr[index1] = this.arr[index2];
        this.arr[index2] = temp;
    }
}