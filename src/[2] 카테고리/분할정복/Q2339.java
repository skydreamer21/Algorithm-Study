// 2339번 석판 자르기 (G1) [분할 정복]
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
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2339 {
    static int N;
    static int[] jewelMap;
    static int[] dirtMap;

    static final int JEWEL = 2;
    static final int DIRT = 1;

    static final boolean HOR = true;
    static final boolean VER = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        jewelMap = new int[N];
        dirtMap = new int[N];

        int numOfJewels = 0;
        int numOfDirt = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> jewelPos = new ArrayList<>();
            ArrayList<Integer> dirtPos = new ArrayList<>();
            for (int j=0; j<N; j++) {
                int elem = Integer.parseInt(st.nextToken());

                if (elem == JEWEL) {
                    jewelPos.add(j);
                    numOfJewels++;
                }
                else if (elem == DIRT) {
                    dirtPos.add(j);
                    numOfDirt++;
                }
            }
            jewelMap[i] = getElemLine(jewelPos);
            dirtMap[i] = getElemLine(dirtPos);
        }

//        printElemMap(jewelMap);
//        printElemMap(dirtMap);


        // ******************** 메인 로직 ********************

        int ansHorizontal = divideConquer(numOfJewels, numOfDirt, 0, N-1, 0, N-1, HOR);
//        System.out.println("\n=============================================\n");
        int ansVertical = divideConquer(numOfJewels, numOfDirt, 0, N-1, 0, N-1, VER);
        int answer = ansHorizontal + ansVertical;

        // ******************** 정답 출력 ********************
        sb.append(answer ==0 ? -1 : answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // divide(jewels - 1) 번으로 주어진 크기를 나누는 경우의 수, 단 이번 나누는 방향은 mode
    // 나누려면 최소 줄이 3개 이상은 있어야 한다.
    public static int divideConquer (int jewels, int dirt, int left, int right, int up, int down, boolean mode) {
        /*System.out.printf("[IN] jewels : %d, dirt : %d, (left, right, up, down) = (%d, %d, %d, %d), mode : %s\n",
                jewels, dirt, left, right, up, down, mode==HOR ? "hor" : "ver");*/
        if (jewels == 1) {
            /*System.out.printf("[OUT - 포함된 jewel이 1개] jewels : %d, dirt : %d, (left, right, up, down) = (%d, %d, %d, %d), mode : %s\n",
                    jewels, dirt, left, right, up, down, mode==HOR ? "hor" : "ver");*/
            return dirt == 0 ? 1 : 0;
        }

        int numOfHorLines = down - up + 1;
        int numOfVerLines = right - left + 1;

        // 모든 줄이 2개 이하인데, 보석은 2개 이상 있으면 불가능
        if (numOfHorLines < 3 && mode == HOR) {
            /*System.out.printf("[OUT - 3줄 이하인데 보석 2개 이상] jewels : %d, dirt : %d, (left, right, up, down) = (%d, %d, %d, %d), mode : %s\n",
                    jewels, dirt, left, right, up, down, mode==HOR ? "hor" : "ver");*/
            return 0;
        }
        if (numOfVerLines < 3 && mode == VER) {
            /*System.out.printf("[OUT - 3줄 이하인데 보석 2개 이상] jewels : %d, dirt : %d, (left, right, up, down) = (%d, %d, %d, %d), mode : %s\n",
                    jewels, dirt, left, right, up, down, mode==HOR ? "hor" : "ver");*/
            return 0;
        }

        int numOfCases = 0;
        // mode == HOR
        if (mode == HOR) {
            for (int mid=up+1; mid<down; mid++) {
                int midLineJewel = countElemInMap(jewelMap, left, right, mid, mid);
                if (midLineJewel > 0) continue;
                int jewelsOfPiece1 = countElemInMap(jewelMap, left, right, up, mid-1);
                if (jewelsOfPiece1 == 0 || jewelsOfPiece1 == jewels) continue; // 한쪽 조각엔 없다는 뜻
                int dirtOfPiece1 = countElemInMap(dirtMap, left, right, up, mid-1);
                int jewelsOfPiece2 = countElemInMap(jewelMap, left, right, mid+1, down);
                int dirtOfPiece2 = countElemInMap(dirtMap, left, right, mid+1, down);

                int piece1 = divideConquer(jewelsOfPiece1, dirtOfPiece1, left, right, up, mid-1, !mode);
                int piece2 = divideConquer(jewelsOfPiece2, dirtOfPiece2, left, right, mid+1, down, !mode);
                numOfCases += piece1*piece2;
            }
        }

        else { // mode == VER
            for (int mid=left+1; mid<right; mid++) {
                int midLineJewel = countElemInMap(jewelMap, mid, mid, up, down);
                if (midLineJewel > 0) continue;
                int jewelsOfPiece1 = countElemInMap(jewelMap, left, mid -1, up, down);
                if (jewelsOfPiece1 == 0 || jewelsOfPiece1 == jewels) continue; // 한쪽 조각엔 없다는 뜻
                int dirtOfPiece1 = countElemInMap(dirtMap, left, mid -1, up, down);
                int jewelsOfPiece2 = countElemInMap(jewelMap, mid + 1, right, up, down);
                int dirtOfPiece2 = countElemInMap(dirtMap, mid + 1, right, up, down);

                int piece1 = divideConquer(jewelsOfPiece1, dirtOfPiece1, left, mid -1, up, down, !mode);
                int piece2 = divideConquer(jewelsOfPiece2, dirtOfPiece2, mid + 1, right, up, down, !mode);
                numOfCases += piece1*piece2;
            }
        }
//        System.out.printf("[OUT - All Searched][numOfCases : %d] jewels : %d, dirt : %d, (left, right, up, down) = (%d, %d, %d, %d), mode : %s\n",
//                numOfCases, jewels, dirt, left, right, up, down, mode==HOR ? "hor" : "ver");
        return numOfCases;
    }

    public static int countElemInMap (int[] map, int left, int right, int up, int down) {
        int size = right - left + 1;
        final int ON = (1 << size) - 1;
        int numOfJewels = 0;

        for (int i=up; i<=down; i++) {
            int intersect = ( map[i] >> left ) & ON;
            numOfJewels += Integer.bitCount(intersect);
        }

        return numOfJewels;
    }

    public static int getElemLine (ArrayList<Integer> elemPos) {
        int mask = 0;
        for (int pos : elemPos) {
            mask = mask | (1 << pos);
        }
        return mask;
    }

    public static void printElemMap(int[] map) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.printf("%d ", ((map[i] >> j) & 1));
            }
            System.out.println();
        }
    }
}
