package Programmers.level2;

import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class 퍼즐조각채우기 {
    static int[][] game_board;
    static int[][] table;
    static int N, numOfPuzzle;
    static boolean[][] visited;
    static boolean[] isUsed;
    static int maxPiece = 0;
    static ArrayList<Pos>[][] puzzles;

    static int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    static final int PIECE = 1;
    static final int EMPTY = -1;
    static final int ROTATE = 4;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        game_board = new int[N][N];
        table = new int[N][N];
        char[] input;
        for (int i=0;i<N;i++) {
            input = br.readLine().toCharArray();
            for (int j=0;j<N;j++) {
                game_board[i][j] = input[j] - '0';
            }
        }

        for (int i=0;i<N;i++) {
            input = br.readLine().toCharArray();
            for (int j=0;j<N;j++) {
                table[i][j] = input[j] - '0';
            }
        }


//        N = game_board.length;

        // printTable(table);
        // printTable(rotatedTable);

        // 1. puzzle 탐색 및 번호 매기기
        numOfPuzzle = 0;
        visited = new boolean[N][N];
        for (int i=0; i<N;i++) {
            for (int j=0;j<N;j++) {
                if (!visited[i][j]) {
                    if (table[i][j] == 0) table[i][j] = EMPTY;
                    else if (table[i][j] == PIECE) {
                        bfs(table, i, j, numOfPuzzle);
                        numOfPuzzle++;
                    }
                }
            }
        }

        // 2. puzzle 담기
        // puzzles[0] 은 0번 puzzle의 좌표가 담겨야한다.
        puzzles = new ArrayList[numOfPuzzle][4];
        for (int i=0; i<numOfPuzzle; i++) {
            for (int j=0; j<ROTATE; j++) {
                puzzles[i][j] = new ArrayList<>();
            }
        }

        int[][] rotatedTable = new int[N][N];
        copyTable(table, rotatedTable);
        for (int i=0; i<ROTATE; i++) {
            // System.out.printf("\n[%d번 방향 Table]\n", i+1);
            // printTable(rotatedTable);
            savePuzzle(rotatedTable, i);
            rotatedTable = rotate(rotatedTable);
        }


        /*for (int i=0; i<numOfPuzzle; i++) {
            System.out.printf("<%d번 퍼즐>\n", i);
            for (int j=0; j<ROTATE; j++) {
                System.out.printf("%d번 방향\n", j+1);
                for (Pos p : puzzles[i][j]) {
                    System.out.printf("(%d, %d) ", p.x, p.y);
                }
                System.out.println();
            }
            System.out.println();
        }*/


        // 3. puzzle 넣기
        isUsed = new boolean[numOfPuzzle];
        fill(1,1, 2,3);

        // System.out.printf("퍼즐 수 : %d\n", numOfPuzzle);
        // printTable(table);
    }

    public static void dfs(int x, int y, int piece) {
        if (x == -1 && y == -1) {
            maxPiece = Math.max(maxPiece, piece);
            return;
        }

        // 1. 채워 넣을 수 있는 것을 채워 넣는다.
        for (int i=0; i<numOfPuzzle; i++) {
            if (isUsed[i]) continue;

        }


        // 2. 다음 빈칸을 찾아서 재귀 호출


    }

    public static boolean fill(int tableX, int tableY, int puzzle, int rotate) {
        System.out.println("fill\n");
        // System.out.printf("numOfP : %d\n",numOfPuzzle);
        System.out.printf("%d\n",puzzles[3].length);
        // ArrayList<Pos> puzzlePiece = (ArrayList<Pos>)puzzles[puzzle][rotate].clone();
        // for (Pos p : puzzlePiece) {
        //     System.out.printf("(%d, %d) ", p.x, p.y);
        // }
        System.out.println();
        return true;

    }

    public static void savePuzzle(int[][] table, int rotate) {
        int puzzleIdx = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (table[i][j] != EMPTY) {
                    puzzleIdx = table[i][j];
                    puzzles[puzzleIdx][rotate].add(new Pos(i, j));
                }
            }
        }
    }

    public static void bfs(int[][] table, int x, int y, int num) {
        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(x,y));
        table[x][y] = num;
        visited[x][y] = true;

        Pos now;
        int nextX, nextY;
        boolean inRange;

        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<N;

                if (inRange && !visited[nextX][nextY] && table[nextX][nextY] == PIECE) {
                    visited[nextX][nextY] = true;
                    table[nextX][nextY] = num;
                    q.add(new Pos(nextX, nextY));
                }
            }
        }
    }

    public static int[][] rotate(int[][] table) {
        int[][] rotatedTable = new int[N][N];

        for (int i=0; N-(2*i)>0; i++) {
            rotateLayer(table, rotatedTable, i);
            // System.out.printf("i:%d\n",i);
            // printTable(rotatedTable);
        }

        return rotatedTable;
    }

    public static void rotateLayer(int[][] table, int[][] rotatedTable, int n) {
        // 한번의 길이는 N-2n
        for (int i=0; i<N-(2*n)-1;i++) {
            rotatedTable[n+i][N-n-1] = table[n][n+i];
            rotatedTable[N-n-1][N-n-1-i] = table[n+i][N-n-1];
            rotatedTable[N-n-1-i][n] = table[N-n-1][N-n-1-i];
            rotatedTable[n][n+i] = table[N-n-1-i][n];
        }
    }

    public static void printTable(int[][] table) {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                System.out.printf("%d ",table[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void copyTable(int[][] src, int[][] dest) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N ; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }

    public static void clearVisited() {
        for (int i=0;i<N;i++) {
            Arrays.fill(visited, false);
        }
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}