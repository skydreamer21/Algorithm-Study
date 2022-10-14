/*
// 'a' : 97(0), 'z' : 122(25) 총 26개
//

class Solution {

    static final char A = 'a';
    static final char Z = 'z';
    static final int IMPOSSIBLE = -1;
    static final boolean INTERSECTION = true;
    static final boolean UNION = false;
    static final int fracSetSize = 676;
    static final int mul = 65536;


    public int solution(String str1, String str2) {
        char[] s1 = str1.toLowerCase().toCharArray();
        char[] s2 = str2.toLowerCase().toCharArray();
        int[] fracSet1 = new int[fracSetSize];
        int[] fracSet2 = new int[fracSetSize];
        getFracSet(s1, fracSet1);
        getFracSet(s2, fracSet2);
        int intersection = getRelation(INTERSECTION, fracSet1, fracSet2);
        int union = getRelation(UNION, fracSet1, fracSet2);
        System.out.printf("aa_s1 : %d, aa_s2 : %d\n",fracSet1[0],fracSet2[0]);
        System.out.printf("inter : %d, union : %d\n",intersection, union);

        int answer;
        if (union==0) answer = mul;
        else {
            double ans = (float) intersection/union;
            ans*=mul;
            answer = (int) ans;
        }
        return answer;
    }

    public static int getRelation(boolean isIntersection, int[] fracSet1, int[] fracSet2) {
        int relation=0;
        for (int i=0;i<fracSetSize;i++) {
            if (isIntersection) relation+=Math.min(fracSet1[i], fracSet2[i]);
            else relation+=Math.max(fracSet1[i], fracSet2[i]);
        }
        return relation;
    }


    public static void getFracSet(char[] str, int[] fracSet) {
        int N = str.length;
        int idx;
        for (int i=0;i<N-1;i++) {
            idx = getIndex(str[i], str[i+1]);
            if (idx==IMPOSSIBLE) continue;
            fracSet[idx]++;
        }
    }

    public static int getIndex(int c1, int c2) {
        boolean OOB_Check_c1 = c1>=A && c1<=Z;
        boolean OOB_Check_c2 = c2>=A && c2<=Z;
        if (!OOB_Check_c1 || !OOB_Check_c2) return -1;

        return 26*(c1-A) + c2-A;
    }
}*/
