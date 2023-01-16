// 10170번 NFC West vs North (B5)
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q10170 {
    static final String SEPARATE_LINE = "-----------------------";
    static final boolean LEFT = true;
    static final boolean RIGHT = false;
    
    static int[] lengths;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        String[][] westInfo = {
                {"NFC West", "W", "L", "T"},
                {"Seattle", "13", "3", "0"},
                {"San Francisco", "12", "4", "0"},
                {"Arizona", "10", "6", "0"},
                {"St. Louis", "7", "9", "0"}
        };
    
        String[][] northInfo = {
                {"NFC North", "W", "L", "T"},
                {"Green Bay", "8", "7", "1"},
                {"Chicago", "8", "8", "0"},
                {"Detroit", "7", "9", "0"},
                {"Minnesota", "5", "10", "1"}
        };
        
        lengths = new int[]{15, 3, 2, 3};
    
        makeTeamInfo(sb, westInfo);
        sb.append("\n");
        makeTeamInfo(sb, northInfo);
        


        // ******************** 메인 로직 ********************



        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void makeTeamInfo(StringBuilder sb, String[][] info) {
        for (int row=0; row<info.length; row++) {
            for (int i=0; i<lengths.length; i++) {
                if (i < 2) {
                    sb.append(makeOutput(info[row][i], lengths[i], LEFT));
                } else {
                    sb.append(makeOutput(info[row][i], lengths[i], RIGHT));
                }
                
            }
            sb.append("\n");
            if (row==0) {
                sb.append(SEPARATE_LINE).append("\n");
            }
        }
    }
    
    public static String makeOutput(String value, int length, boolean direction) {
        if (direction) {
            return String.format("%-" + length + "s", value);
        } else {
            return String.format("%" + length + "s", value);
        }
    }
}
