import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int N, numOfPuzzle;
    static int[][] board;
    static boolean[][] visited;
    static boolean[] isUsed;
    static boolean[][] isFilled;
    static int maxPiece = 0;
    static ArrayList<Pos>[][] puzzles;

    static int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    static final int PIECE = 1;
    static final int EMPTY = -1;
    static final int ROTATE = 4;

    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        board = new int[N][N];
        copyTable(game_board, board);

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

        /*
        for (int i=0; i<numOfPuzzle; i++) {
            System.out.printf("<%d번 퍼즐>\n", i);
            for (int j=0; j<ROTATE; j++) {
                System.out.printf("%d번 방향\n", j+1);
                System.out.printf("%d, %d\n", i, j);
                for (Pos p : puzzles[i][j]) {
                    System.out.printf("(%d, %d) ", p.x, p.y);
                }
                System.out.println();
            }
            System.out.println();
        }
        */



        // 3. puzzle 넣기
        isUsed = new boolean[numOfPuzzle];
        isFilled = new boolean[N][N];
        // fill(1,1, 2,3);
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (!isFilled[i][j] && board[i][j] == 0) {
                    dfs(i,j,0);
                }
            }
        }

        return maxPiece;
    }

    // 여기서 numOfPuzzle을 다른걸로 바꾸기만 하면 바로 오류
    public static ArrayList<Pos> getter (int puzzle, int rotate) {
        return puzzles[puzzle][rotate];
        // for (int i=0; i<numOfPuzzle; i++) {
        //     if (i==puzzle) {
        //         return puzzles[i][rotate];
        //     }
        // }
        // return new ArrayList<Pos>();
    }

    public static void dfs(int x, int y, int piece) {
        // System.out.printf("[IN] x : %d, y : %d, piece : %d\n", x, y, piece);
        // if (x == -1 && y == -1) {
        //     maxPiece = Math.max(maxPiece, piece);
        //     return;
        // }

        // 1. 채워 넣을 수 있는 것을 채워 넣는다.
        for (int i=0; i<numOfPuzzle; i++) {
            if (isUsed[i]) continue;
            for (int j=0; j<ROTATE; j++) {
                if (!fill(x,y,i,j)) continue;
                isUsed[i] = true;
                int addedPuzzleNum = getter(i, j).size();

                // 2. 다음 빈칸을 찾아서 재귀 호출
                for (int nextX=x; nextX<N; nextX++) {
                    for (int nextY=0; nextY<N; nextY++) {
                        if (nextX == x && nextY <= y) continue;
                        if (!isFilled[nextX][nextY] && board[nextX][nextY] == 0) {
                            dfs(nextX, nextY, piece + addedPuzzleNum);
                        }
                    }
                }
                maxPiece = Math.max(maxPiece, piece);

                isUsed[i] = false;
                unfill(x,y,i,j);
            }
        }
    }

    public static boolean fill(int tableX, int tableY, int puzzle, int rotate) {
        // System.out.println("fill\n");
        ArrayList<Pos> puzzlePiece = (ArrayList<Pos>)getter(puzzle, rotate).clone();
        // for (Pos p : puzzlePiece) {
        //     System.out.printf("(%d, %d) ", p.x, p.y);
        // }
        // System.out.println();

        int dx = tableX - puzzlePiece.get(0).x;
        int dy = tableY - puzzlePiece.get(0).y;
        int convertX, convertY;
        boolean inRange;
        for (Pos p : puzzlePiece) {
            convertX = p.x + dx;
            convertY = p.y + dy;
            inRange = convertX>=0 && convertY>=0 && convertX<N && convertY<N;
            if (!inRange || isFilled[convertX][convertY] || board[convertX][convertY] != 0) {
                return false;
            }
        }

        for (Pos p : puzzlePiece) {
            convertX = p.x + dx;
            convertY = p.y + dy;
            isFilled[convertX][convertY] = true;
        }
        return true;
    }

    public static void unfill(int tableX, int tableY, int puzzle, int rotate) {
        ArrayList<Pos> puzzlePiece = (ArrayList<Pos>)getter(puzzle, rotate).clone();

        int dx = tableX - puzzlePiece.get(0).x;
        int dy = tableY - puzzlePiece.get(0).y;
        int convertX, convertY;
        for (Pos p : puzzlePiece) {
            convertX = p.x + dx;
            convertY = p.y + dy;
            isFilled[convertX][convertY] = false;
        }
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