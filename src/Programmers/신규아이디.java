/*
// ascii 소문자 97 ~ 122, 마침표 : 46, 빼기 : 45, 밑줄 : 95

class Solution {
    static int removed=0;

    static final char ZERO = '0';
    static final char NINE = '9';
    static final char PERIOD = '.';
    static final char DASH = '-';
    static final char UNDER_BAR = '_';

    public String solution(String new_id) {
        // 1단계
        char[] id = new_id.toLowerCase().toCharArray();
        int N = id.length;
        boolean[] id_edit = new boolean[id.length];
        System.out.println("1단계 완료 결과");
        printChar(id, id_edit);

        // 2단계
        for (int i=0;i<id.length;i++) {
            id_edit[i] = isCorrect(id[i]);
            if (!id_edit[i]) removed++;
        }
        System.out.println("2단계 완료 결과");
        printChar(id, id_edit);

        // 3단계
        boolean period=false;
        for (int i=0;i<id.length;i++) {
            if(!id_edit[i]) continue;
            if (period) {
                if (id[i]==PERIOD) {
                    id_edit[i]=false;
                    removed++;
                }
                else period = false;
            }
            else if (id[i]==PERIOD) period = true;
        }
        System.out.println("3단계 완료 결과");
        printChar(id, id_edit);

        // 4단계
        int idx = 0;
        while(idx<N && !id_edit[idx]) idx++;
        if (idx!=N && id[idx]==PERIOD) {
            removed++;
            id_edit[idx]=false;
        }
        idx = N-1;
        while(idx>=0 && !id_edit[idx]) idx--;
        if (idx!=-1 && id[idx]==PERIOD) {
            removed++;
            id_edit[idx]=false;
        }
        System.out.println("4단계 완료 결과");
        printChar(id, id_edit);

        // 5단계
        if (removed==N) {
            id[0] = 'a';
            id_edit[0] = true;
        }
        System.out.println("5단계 완료 결과");
        printChar(id, id_edit);

        // 6-1단계
        char[] id_recommend = new char[15];
        int len = 0;
        for (int i=0;i<N;i++) {
            if (!id_edit[i]) continue;
            id_recommend[len++] = id[i];
            if (len==15) break;
        }
        // 6-2 단계
        if (len==15 && id_recommend[14]==PERIOD) len--;
        System.out.println("6단계 완료 결과");
        printChar(id, id_edit);

        // 7단계
        char copy_char;
        System.out.printf("len : %d\n",len);
        if (len<=2) {
            copy_char = id_recommend[len-1];
            while(len<3) id_recommend[len++] = copy_char;
        }
        System.out.println("7단계 완료 결과");
        printChar(id, id_edit);


        StringBuilder sb = new StringBuilder();
        for (int i=0;i<len;i++) sb.append(id_recommend[i]);

        String answer = sb.toString();
        return answer;
    }

    public static boolean isCorrect(int c) {
        // System.out.printf("c : %d\n",c);
        if (c<97 || c>122) {
            if (c>=ZERO && c<=NINE) return true;
            if (c==PERIOD || c==DASH || c==UNDER_BAR) return true;
            return false;
        }
        return true;
    }

    public static void printChar(char[] id, boolean[] edit) {
        int len = id.length;
        for (int i=0;i<len;i++) {
            if (!edit[i]) continue;
            System.out.print(id[i]);
        }
        System.out.println();
    }
}*/
