package Necessary_Class.Pair;

public class FlagPair {
    public int x,y;
    public boolean flag;
    public FlagPair(int x, int y) {
        this.x = x;
        this.y = y;
        this.flag = false;
    }

    public FlagPair(int x, int y, boolean flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
    }
}
