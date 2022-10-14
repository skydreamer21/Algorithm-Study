package Necessary_Class;

public class MyQueue_Arr {
    int front;
    int rear;
    public int[] arr;
    int size;

    public MyQueue_Arr (int size) {
        front=0; rear =0;
        arr = new int[size];
        this.size = size;
    }

    public void push (int n) {
        arr[rear++] = n;
    }

    public int pop() {
        return this.empty() ? -1 : arr[front++];
    }

    public int size() {
        return rear-front;
    }

    public boolean empty() {
        return front==rear;
    }

    public int isEmpty() {
        return this.empty() ? 1 : 0;
    }

    public int front() {
        return this.empty() ? -1 : arr[front];
    }

    public int back() {
        return this.empty() ? -1 : arr[rear-1];
    }
}