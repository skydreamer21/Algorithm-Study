package Necessary_Class;

public class MyStack <T extends Object> {
    int top;
    T[] stack;
    int size;

    public MyStack (int size) {
        this.top = -1;
        this.stack = (T[]) new Object[size];
        this.size = size;
    }

    public void push (T n) {
        this.stack[++top] = n;
    }

    public T pop() {
        return this.stack[top--];
    }

    public int size() {
        return this.top+1;
    }

    public void clear() {
        this.top = -1;
    }

    public boolean empty() {
        return top==-1;
    }

    public T peek() {
        return this.stack[top];
    }
}