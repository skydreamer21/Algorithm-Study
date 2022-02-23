package Necessary_Class.Pair;

public class Pair {
    public int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.printf("(%d,%d) ",this.x,this.y);
    }
}
