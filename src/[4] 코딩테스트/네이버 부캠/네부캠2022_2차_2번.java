/*
    21 x 21 QR code

    인코딩 Table
    00 : 0   10 : A   20 : K   30 : U   40 : -
    01 : 1   11 : B   21 : L   31 : V   41 : _
    02 : 2   12 : C   22 : M   32 : W   42 : +
    03 : 3   13 : D   23 : N   33 : X   43 : =
    04 : 4   14 : E   24 : O   34 : Y   44 : space
    05 : 5   15 : F   25 : P   35 : Z
    06 : 6   16 : G   26 : Q   36 : .
    07 : 7   17 : H   27 : R   37 : *
    08 : 8   18 : I   28 : S   38 : #
    09 : 9   19 : J   29 : T   39 : $

    Input : String word, String error
    ex)     abc.ei       0xA0B1C2D3
 */

/*
    1. 모든 부분을 '0'으로 초기화
    2. default 로 찍혀 있는 코드를 찍는다. (+시작, 끝)

    3. Input 길이, Data #1 ~ #20, error #1 ~ #4 모두 숫자를 받아서 입력하는 방식
        - Input 이 들어가는 사각형의 모양과 방향에 따라 들어가는 순서가 달라짐
        - InputData 클래스로 각 숫자가 들어가는 공간을 구분
            * x, y, 모양(type), 방향(mode)
    4. Input 공간 코딩
    5. 주어진 인코딩 테이블을 HashMap으로 구현

    6. 각 input 종류에 따른 QRcode 입력 함수 작성 --> 1h 2m

    7. 길이 -> 데이터 -> 에러 순으로 데이터 encode --> 1h 23m
        - 숫자 -> 8비트 char 배열로 바꾸는 함수 필요

    8. char 배열을 String 1차원 배열로 바꿔서 출력

    <1h 25m> 1차 코딩 완료
 */



import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class 네부캠2022_2차_2번 {
    static char[][] QRcode = new char[21][21];

    // <index 정보> 0 : 길이, 1~20 : Data, 21~24 : error
    static InputData[] inputData = new InputData[25];

    // encoding Table
    static HashMap<Character, Integer> encodingTable = new HashMap<>();

    static final int SIZE = 21;

    // input 사각형 type
    static final boolean HORIZONTAL = true;
    static final boolean VERTICAL = false;

    // input 사각형 mode
    // 가로일 때
    static final boolean COUNTER_CLOCKWISE = true;
    static final boolean CLOCKWISE = false;
    // 세로일 때
    static final boolean UP = true;
    static final boolean DOWN = false;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************

        String word = br.readLine().toUpperCase();
        String error = br.readLine().toUpperCase();

        initQRcode();
        writeDefaultCode(); // -> 20m

        getInputData(); // -> 43m
        getEncodingTable(); // -> 50m

        // ******************** 메인 로직 ********************

        // 1. 길이 입력
        int len = word.length();
        writeQRcode(convertTo8bitBinary(len), 0);

        // 2. Data #1 ~ #20 입력
        int numOfPossibleData = Math.min(len, 20);
        int encodedKey;
        for (int i=1;i<=numOfPossibleData;i++) {
            encodedKey = encodingTable.get(word.charAt(i-1));
            System.out.printf("data : %c, encodedKey : %d\n",word.charAt(i-1), encodedKey);
            writeQRcode(convertTo8bitBinary(encodedKey), i);
        }

        // 3. Error #1 ~ #4 입력
        for (int i=1;i<=4;i++) {
            // error를 읽어서 각 에러에 맞는 숫자 가져오기
            encodedKey = hexToDecimal(error.charAt(2*i), error.charAt(2*i+1));
            System.out.printf("error : %c%c, encodedKey : %d\n",error.charAt(2*i), error.charAt(2*i+1), encodedKey);
            writeQRcode(convertTo8bitBinary(encodedKey), 20+i);
        }

        // ******************* 정답 출력 ********************

        String[] answer = new String[SIZE];
        for (int i=0;i<SIZE;i++) {
            answer[i] = String.valueOf(QRcode[i]);
        }

//        printAnswer(answer);
        printQRcode();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // ---------------- encode 함수 START ----------------

    // 숫자 -> 8비트 char 배열
    public static char[] convertTo8bitBinary (int num) {
        char[] binary = new char[8];

        int binaryDigitValue = 1<<7;
        for (int i=0;i<8;i++) {
            if (num >= binaryDigitValue) {
                binary[i] = '1';
                num -= binaryDigitValue;
            }
            else binary[i] = '0';
            binaryDigitValue >>= 1;
        }

        System.out.println("8bit binary");
        for (char c : binary) System.out.printf("%c ",c);
        System.out.println();

        return binary;
    }

    // 에러 -> 숫자
    public static int hexToDecimal(char c1, char c2) {
        // c1에 해당하는 10진수*16 + c2에 해당하는 10진수
        int num1 = hexDigitToDecimal(c1);
        int num2 = hexDigitToDecimal(c2);

        return num1*16 + num2;
    }

    // 16진수 한자리를 십진수로 변환
    public static int hexDigitToDecimal(char c1) {
        if (Character.isAlphabetic(c1)) return c1-'A'+10;
        else return c1-'0';
    }

    // ---------------- encode 함수 END ----------------




    // ---------------- QRcode Write 함수 START ----------------

    // 8비트 데이터와 input의 index가 주어질 때 QRcode 에 입력하는 함수
    public static void writeQRcode(char[] data, int inputIdx) {
        // 가로일 때
        if(inputData[inputIdx].type==HORIZONTAL) {
            writeHorizontal(data, inputData[inputIdx].x, inputData[inputIdx].y, inputData[inputIdx].mode);
        }

        // 세로일 때
        if(inputData[inputIdx].type==VERTICAL) {
            writeVertical(data, inputData[inputIdx].x, inputData[inputIdx].y, inputData[inputIdx].mode);
        }
    }

    // 8비트 데이터와 사각형의 가장 왼쪽 위 모서리 좌표 및 mode가 주어질 때 입력
    // 가로 입력
    public static void writeHorizontal(char[] data, int x, int y, boolean mode) {
        if(mode ==  COUNTER_CLOCKWISE) {
            QRcode[x+1][y+3] = data[0];
            QRcode[x+1][y+2] = data[1];

            QRcode[x][y+3] = data[2];
            QRcode[x][y+2] = data[3];
            QRcode[x][y+1] = data[4];
            QRcode[x][y] = data[5];

            QRcode[x+1][y+1] = data[6];
            QRcode[x+1][y] = data[7];
        }

        else {
            QRcode[x][y+3] = data[0];
            QRcode[x][y+2] = data[1];

            QRcode[x+1][y+3] = data[2];
            QRcode[x+1][y+2] = data[3];
            QRcode[x+1][y+1] = data[4];
            QRcode[x+1][y] = data[5];

            QRcode[x][y+1] = data[6];
            QRcode[x][y] = data[7];
        }
    }
    // 세로 입력
    public static void writeVertical(char[] data, int x, int y, boolean mode) {
        if(mode ==  UP) {
            QRcode[x+3][y+1] = data[0];
            QRcode[x+3][y] = data[1];
            QRcode[x+2][y+1] = data[2];
            QRcode[x+2][y] = data[3];
            QRcode[x+1][y+1] = data[4];
            QRcode[x+1][y] = data[5];
            QRcode[x][y+1] = data[6];
            QRcode[x][y] = data[7];
        }

        else {
            QRcode[x][y+1] = data[0];
            QRcode[x][y] = data[1];
            QRcode[x+1][y+1] = data[2];
            QRcode[x+1][y] = data[3];
            QRcode[x+2][y+1] = data[4];
            QRcode[x+2][y] = data[5];
            QRcode[x+3][y+1] = data[6];
            QRcode[x+3][y] = data[7];
        }
    }


    // ---------------- QRcode Write 함수 End ----------------



    // ---------------- QRcode 초기화 + Default Setting 함수 START ----------------

    // 모든 부분 '0'으로 초기화
    public static void initQRcode() {
        for (int i=0;i<SIZE;i++) Arrays.fill(QRcode[i], '0');
    }

    // default QRcode
    public static void writeDefaultCode() {
        // 꼭짓점 사각형 3개
        writeDefaultSquare(0,0);
        writeDefaultSquare(0, 14);
        writeDefaultSquare(14, 0);

        // 사각형 주변의 '1' -> row 순서대로
        QRcode[0][8] = '1';
        QRcode[1][8] = '1';
        QRcode[3][8] = '1';
        QRcode[4][8] = '1';
        QRcode[5][8] = '1';
        QRcode[6][10] = '1';
        QRcode[6][12] = '1';
        QRcode[8][0] = '1';
        QRcode[8][3] = '1';
        QRcode[8][4] = '1';
        QRcode[8][6] = '1';
        QRcode[8][8] = '1';
        QRcode[8][13] = '1';
        QRcode[8][15] = '1';
        QRcode[8][17] = '1';
        QRcode[8][19] = '1';
        QRcode[8][20] = '1';
        QRcode[10][6] = '1';
        QRcode[13][6] = '1';
        QRcode[13][8] = '1';
        QRcode[15][8] = '1';
        QRcode[18][8] = '1';
        QRcode[19][8] = '1';
        QRcode[20][8] = '1';

        // 시작과 끝
        QRcode[20][19] = '1';
        QRcode[20][20] = '1';

        QRcode[19][9] = '1';
        QRcode[20][10] = '1';
    }

    // default 코드 중 사각형를 찍는 코드 7x7 테두리, 안쪽 3x3 사각형
    public static void writeDefaultSquare(int x, int y) {
        // 7x7 테두리
        for (int i=0;i<7;i++) {
            QRcode[x][y+i] = '1'; // 위 테두리
            QRcode[x+6][y+i] = '1'; // 아래 테두리
            QRcode[x+i][y] = '1'; // 왼쪽 테두리
            QRcode[x+i][y+6] = '1'; // 오른쪽 테두리
        }

        // 안쪽 3x3 사각형
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                QRcode[x+2+i][y+2+j] = '1';
            }
        }
    }

    // ---------------- QRcode 초기화 + Default Setting 함수 END ----------------


    // ---------------- 데이터(input, encodeTable) 코딩 함수 START ----------------

    //  InputData 데이터 코딩 함수
    public static void getInputData() {
        // index 0~11 총 12개는 6개마다 (각각 3개씩 끊어서) 규칙이 있음.
        // for 문으로 작성해도 될 것 같지만 만약 데이터가 들어가는 장소가 바뀐다면, for문을 싹 갈아 엎어야 함
        // --> 하드코딩이 조금 더 유지보수에 좋을 것 같다고 생각하여 데이터 하나하나 모두 작성

        inputData[0] = new InputData(15, 19, VERTICAL, UP); // 길이
        inputData[1] = new InputData(11, 19, VERTICAL, UP); // Data #1
        inputData[2] = new InputData(9, 17, HORIZONTAL, COUNTER_CLOCKWISE); // Data #2
        inputData[3] = new InputData(11, 17, VERTICAL, DOWN); // Data #3
        inputData[4] = new InputData(15, 17, VERTICAL, DOWN); // Data #4
        inputData[5] = new InputData(19, 15, HORIZONTAL, CLOCKWISE); // Data #5

        inputData[6] = new InputData(15, 15, VERTICAL, UP); // Data #6
        inputData[7] = new InputData(11, 15, VERTICAL, UP); // Data #7
        inputData[8] = new InputData(9, 13, HORIZONTAL, COUNTER_CLOCKWISE); // Data #8
        inputData[9] = new InputData(11, 13, VERTICAL, DOWN); // Data #9
        inputData[10] = new InputData(15, 13, VERTICAL, DOWN); // Data #10
        inputData[11] = new InputData(19, 11, HORIZONTAL, CLOCKWISE); // Data #11

        inputData[12] = new InputData(15, 11, VERTICAL, UP); // Data #12
        inputData[13] = new InputData(11, 11, VERTICAL, UP); // Data #13
        inputData[14] = new InputData(7, 11, VERTICAL, UP); // Data #14
        inputData[15] = new InputData(2, 11, VERTICAL, UP); // Data #15

        inputData[16] = new InputData(0, 9, HORIZONTAL, COUNTER_CLOCKWISE); // Data #16

        inputData[17] = new InputData(2, 9, VERTICAL, DOWN); // Data #17
        inputData[18] = new InputData(7, 9, VERTICAL, DOWN); // Data #18
        inputData[19] = new InputData(11, 9, VERTICAL, DOWN); // Data #19
        inputData[20] = new InputData(15, 9, VERTICAL, DOWN); // Data #20

        inputData[21] = new InputData(9, 7, VERTICAL, UP); // Error #1
        inputData[22] = new InputData(9, 4, VERTICAL, DOWN); // Error #2
        inputData[23] = new InputData(9, 2, VERTICAL, UP); // Error #3
        inputData[24] = new InputData(9, 0, VERTICAL, DOWN); // Error #4
    }

    // encodeTable 데이터 코딩 함수
    public static void getEncodingTable() {
        int value = 0;

        // 0~9
        for (int i=0;i<=9;i++) encodingTable.put((char)('0'+i), value++);

        // A~Z
        for (int i=0;i<26;i++) encodingTable.put((char)('A'+i), value++);

        // 특수문자
        encodingTable.put('.', value++);
        encodingTable.put('*', value++);
        encodingTable.put('#', value++);
        encodingTable.put('$', value++);
        encodingTable.put('-', value++);
        encodingTable.put('_', value++);
        encodingTable.put('+', value++);
        encodingTable.put('=', value++);
        encodingTable.put(' ', value);
    }


    // ---------------- 데이터(input, encodeTable) 코딩 함수 END ----------------



    // QRcode 출력 함수 -> debug 용
    public static void printQRcode() {
        for (int i=0;i<SIZE;i++) {
            for (int j=0;j<SIZE;j++) System.out.printf("%c",QRcode[i][j]=='1' ? '⬜':'⬛');
            System.out.println();
        }
    }

    // answer 출력 함수
    public static void printAnswer(String[] answer) {
        for (int i=0;i<SIZE;i++) System.out.println(answer[i]);
    }

}

class InputData {
    int x, y;
    boolean type;
    boolean mode;

    public InputData(int x, int y, boolean type, boolean mode) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.mode = mode;
    }
}



















