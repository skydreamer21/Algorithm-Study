// 2580번 - 스도쿠

/*
<문제 정보>
 1. 빈칸이 0으로 주어질 때 모든 빈칸이 채워진 스도쿠 판의 최종모습 출력
 2. 답이 여러개인 경우 그중 하나만 출력

<프로그램 진행>
 1.

<필요 함수>
 1. firstCheck (들어갈 값이 하나밖에 없을 때 값 대입)
     - hasOnlyOne (값이 하나밖에 없다면 그 값을 return)
 2. Sudoku (백트래킹)
     - checkRow (Row에 중복값 없는지 체크 -> boolean return)
     - checkCol (Col ~)
     - checkBox (Box ~)
 3. printSudoku : sudoku 출력

 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Q2580 {
    static int[][] sudoku = new  int[9][9];
    static int blank=0;
    static int[][] blankList;
    static boolean find = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i=0;i<9;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<9;j++) {
                sudoku[i][j]=Integer.parseInt(st.nextToken());
                if(sudoku[i][j]==0) blank++;
            }
        }
        blankList = new int[blank][2];
        int idx=0;
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (sudoku[i][j]==0) {
                    blankList[idx][0]=i;
                    blankList[idx][1]=j;
                    idx++;
                }
            }
        }
        /*
        printSudoku(sudoku);
        printBlank(blankList);
        System.out.println(checkRow(blankList[0][0],blankList[0][1],4));
        System.out.println(checkCol(blankList[0][0],blankList[0][1],4));
        System.out.println(checkBox(blankList[0][0],blankList[0][1],4));
        System.out.printf("\nblank : %d개\n",blank);
         */
        System.out.println(Arrays.toString(blankList[28]));
        System.out.println(checkBox(blankList[28][0],blankList[28][1],1));
        firstCheck(); // 들어갈 값이 한개밖에 없는 것은 먼저 대입하고 시작
        System.out.println("firstcheck");
        printSudoku(sudoku);
        System.out.println();
        if (blank==0) printSudoku(sudoku);
        else sudoku(0);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void sudoku (int depth) throws IOException {
        if (depth == blankList.length) {
            printSudoku(sudoku);
            find = true;
            return;
        }

        for (int i=1;i<10;i++) {
            if (checkRow(blankList[depth][0],blankList[depth][1],i) &&
                checkCol(blankList[depth][0],blankList[depth][1],i) &&
                checkBox(blankList[depth][0],blankList[depth][1],i) &&
                !find) {
                sudoku[blankList[depth][0]][blankList[depth][1]]=i;
                sudoku(depth+1);
                sudoku[blankList[depth][0]][blankList[depth][1]]=0;
            }
        }

    }

    public static void firstCheck() {
        boolean[] possibleNum = new boolean[9];
        int x;
        int y;
        int theValue;
        for (int i=0;i<blankList.length;i++) {
            Arrays.fill(possibleNum,true);
            x = blankList[i][0];
            y = blankList[i][1];

            //Row
            for (int j=0;j<9;j++) {
                if (j!=y && sudoku[x][j]!=0) {
                    possibleNum[sudoku[x][j]-1]=false;
                }
            }
            // 들어갈 수 있는 값이 한개밖에 없으면 그 값을 대입하고 다음 빈칸 탐색
            theValue=hasOnlyOne(possibleNum);
            if(theValue!=0) {
                sudoku[x][y]=theValue;
                blank--;
                continue;
            }

            //Col
            for (int num=1;num<10;num++) {
                if(possibleNum[num-1]) {
                    for (int j=0;j<9;j++) {
                        if(sudoku[j][y]==num) {
                            possibleNum[num-1]=false;
                        }
                    }
                }
            }
            theValue=hasOnlyOne(possibleNum);
            if(theValue!=0) {
                sudoku[x][y]=theValue;
                blank--;
                continue;
            }

            //Box
            for (int num=1;num<10;num++) {
                if(possibleNum[num-1]) {
                    for (int j=(x/3)*3;j<(x/3)+3;j++) {
                        for (int k=(y/3)*3;k<(y/3)+3;k++) {
                            if(sudoku[j][k]==num) possibleNum[num-1]=false;
                        }
                    }
                }
            }
            theValue=hasOnlyOne(possibleNum);
            if(theValue!=0) {
                sudoku[x][y]=theValue;
                blank--;
                continue;
            }
        }
    }

    public static int hasOnlyOne (boolean[] possibleNum) {
        int theValue=0;
        int cnt=0;
        for (int i=0;i<9;i++) {
            if (possibleNum[i]) {
                theValue=i+1;
                cnt++;
            }
        }
        if(cnt==1) return theValue;
        else return 0;
    }


    public static boolean checkRow (int x, int y, int num) {
        boolean possible=true;
        for (int i=0;i<9;i++) {
            if (sudoku[x][i]==num && y!=i) {
                possible = false;
                break;
            }
        }
        return possible;
    }

    public static boolean checkCol (int x, int y, int num) {
        boolean possible=true;
        for (int i=0;i<9;i++) {
            if (sudoku[i][y]==num && x!=i) {
                possible = false;
                break;
            }
        }
        return possible;
    }

    public static boolean checkBox (int x, int y, int num) {
        boolean possible = true;
        for (int i=(x/3)*3;i<(x/3)+3;i++) {
            for (int j=(y/3)*3;j<(y/3)+3;j++) {
                if (sudoku[i][j]==num && (x!=i || y!=j)) {
                    possible = false;
                    break;
                }
            }
            if(!possible) break;
        }
        return possible;
    }

    public static void printSudoku (int[][] sudoku) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) sb.append(sudoku[i][j]).append(" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
/*
    public static void printBlank (int[][] blankList) {
        for (int i=0;i<blankList.length;i++) {
            System.out.print(Arrays.toString(blankList[i]));
            System.out.print(" ");
        }
        System.out.println();
    }
 */
}