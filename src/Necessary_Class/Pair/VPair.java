package Necessary_Class.Pair;


public class VPair implements Comparable<VPair> {
    public int v,w;

    public VPair(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo (VPair V) {
        return this.w-V.w;
    }
}
