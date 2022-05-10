// 21611번 마법사 상어와 블리자드 (G1) [구현] [틀림]
/*
<문제 정보>
 1. 1×(폭발한 1번 구슬의 개수) + 2×(폭발한 2번 구슬의 개수) + 3×(폭발한 3번 구슬의 개수)
       ① 블리자드 마법
       ② 구슬 이동
       ③ 연속 4개 이상 구슬 폭발
       ④ 구슬 이동
       ⑤ 폭발할 구슬이 없을 때까지 ③,④ 반복
       ⑥ 연속한 구슬끼리 그룹지어 그룹당 구슬 2개로 바꿈 (개수, 종류)

<변수 범위>
 1. 1초 / 1024MB
 2. 3<=N<=49
 3. 1<=M<=100

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q21611 {
    static int N;
    static int magic;
    static int sharkX, sharkY;
    static int marbles;
    static int[][] map;
    static int[][] mapNumber;
    static int[] path;
    static int[] explodedMarbles = new int[4];
    static int[][] magics;

    static int[][] dir = {{0,0}, {-1,0},{1,0},{0,-1},{0,1}};
    static int[][] reverse_dir = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
    static final int EMPTY = 0;
    static final int SHARK = 9;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        magic = Integer.parseInt(st.nextToken());
        sharkX = (N+1)/2;
        sharkY = (N+1)/2;
        map = new int[N+1][N+1];
        mapNumber = new int[N+1][N+1];
        path = new int[N*N]; // 총 N*N-1 개 1 ~ N*N-1 까지
        // path[i] : i-1 칸에서 dir[path[i]] 방향으로 한칸 가면 i가 나온다. 즉 방향의 인덱스값
        magics = new int[magic][2];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        map[sharkX][sharkY] = SHARK;
        int direction, dist;
        for (int i=0;i<magic;i++) {
            st = new StringTokenizer(br.readLine());
            direction = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());
            magics[i][0] = direction;
            magics[i][1] = dist;
        }

        CreatePath();
        CreateMapNumber(); // N번 칸을 가려면 N-1번 칸에서 path[N] 방향으로 한칸 가면 된다.
        // N번칸에서 N-1칸으로 돌아가려면 reverse_dir[path[N]] 방향으로 한칸 가면 됨
        marbles = FindEnd();

//        System.out.printf("구슬의 개수 : %d\n",FindEnd());
//        PrintMap(mapNumber);

        /*CreatePath();
        for (int d : path) System.out.printf("%d ",d);*/

        /*PrintMap(map);
        useBlizzardMagic(direction, dist);
        PrintMap(map);
        for (int i=1;i<=3;i++) System.out.printf("%d \n",explodedMarbles[i]);*/

        for (int i=0;i<magic;i++) {
            System.out.printf("----- %d번째 Blizzard -----\n",i+1);
            useBlizzardMagic(magics[i][0], magics[i][1]);
            System.out.printf("<%d번째 최종>\n",i+1);
            System.out.printf("marble : %d개\n",marbles);
            PrintMap(map);
        }

        int ans = 0;
        for (int i=1;i<=3;i++) ans+=i*explodedMarbles[i];


        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void useBlizzardMagic(int direction, int dist) {
        Blizzard(direction, dist);
        /*System.out.println("1. Blizzard 끝난후");
        System.out.printf("marble : %d개\n",marbles);
        PrintMap(map);*/
        moveMarble();
        /*System.out.println("2. moveMarble 끝난후");
        System.out.printf("marble : %d개\n",marbles);
        PrintMap(map);
        int repeat = 1;*/
        while(ExplodeMarble()) {
            /*System.out.printf("3-%d. Explode 끝난후\n",repeat);
            System.out.printf("marble : %d개\n",marbles);
            PrintMap(map);*/
            moveMarble();
            /*System.out.printf("3-%d. moveMarble 끝난후\n",repeat++);
            System.out.printf("marble : %d개\n",marbles);
            PrintMap(map);*/
        }
        ConvertMarble();
        /*System.out.println("4. ConvertMarble 끝난후");
        System.out.printf("marble : %d개\n",marbles);
        PrintMap(map);*/
    }

    public static void ConvertMarble() {
        int totalMarble = marbles;
        int[][] copiedMap = new int[N+1][N+1];
        CopyMap(copiedMap);
        int marbleNumber=map[sharkX][sharkY-1];
        int marbleAmount=1;
        int x = sharkX;
        int y = sharkY-1;
        int resultX = sharkX;
        int resultY = sharkY-1;
        int resultDirectionIndex = 2; // 2번째 칸 차례라는 뜻
        boolean flag = false;

        for (int i=2;i<=totalMarble;i++) {
            x += dir[path[i]][0];
            y += dir[path[i]][1];
            /*System.out.printf("convert 과정 i:%d (%d,%d)\n", i, x, y);
            System.out.printf("result : (%d,%d)\n", resultX, resultY);*/
            if (marbleNumber == copiedMap[x][y]) marbleAmount++;
            if (marbleNumber != copiedMap[x][y] || i==totalMarble) {
                if (i==totalMarble && marbleNumber != copiedMap[x][y]) flag = true;
                /*if (i==24) {
                    System.out.printf("marbleAmount : %d, marbleNumber : %d\n",marbleAmount, marbleNumber);
                }*/
                map[resultX][resultY] = marbleAmount;
                if (resultDirectionIndex>=N*N) break;
                resultX += dir[path[resultDirectionIndex]][0];
                resultY += dir[path[resultDirectionIndex++]][1];
                /*if (i==25) {
                    System.out.printf("marbleAmount : %d, marbleNumber : %d\n",marbleAmount, marbleNumber);
                    System.out.printf("result : (%d,%d)\n", resultX, resultY);
                }*/
                map[resultX][resultY] = marbleNumber;
//                if (i==25) System.out.println(map[1][1]);
                marbles -= marbleAmount - 2;
                marbleAmount = 1;
                marbleNumber = copiedMap[x][y];
                /*if (i==25) System.out.println(map[1][1]);
                if (i==24) {
                    System.out.printf("marbleAmount : %d, marbleNumber : %d\n",marbleAmount, marbleNumber);
                    System.out.printf("resultDirectionIndex : %d, \n",resultDirectionIndex);
                }*/

                if (resultDirectionIndex>=N*N) break;
                resultX += dir[path[resultDirectionIndex]][0];
                resultY += dir[path[resultDirectionIndex++]][1]; // 다음 것을 위해
            }
        }
        marbles = marbles>=N*N ? N*N-1 : marbles;
        if (flag) {
            map[resultX][resultY] = marbleAmount;
            if (resultDirectionIndex>=N*N) return;
            resultX += dir[path[resultDirectionIndex]][0];
            resultY += dir[path[resultDirectionIndex]][1];
            map[resultX][resultY] = marbleNumber;
            marbles -= marbleAmount - 2;
        }
        MakeEmpty();
    }

    public static int FindEnd() {
        int x = 1;
        int y = 1;
        for (int i=N*N-1;i>=1;i--) {
            if (map[x][y]!=EMPTY) return mapNumber[x][y];
            x += reverse_dir[path[i]][0];
            y += reverse_dir[path[i]][1];
//            System.out.printf("(x,y) : (%d,%d)\n",x,y);
        }
        return 0;
    }

    public static boolean ExplodeMarble() {
        int x = sharkX;
        int y = sharkY;
        int savedValue;
        savedValue = SHARK; // 그 전 값이 저장되어있는 공간
        int cnt = 1;
        int tempX, tempY;
        boolean isExploded = false;
        int marbleNum = marbles;
//        System.out.printf("!구슬 개수 : %d\n",marbles);
        for (int i=1;i<=marbleNum;i++) { // i번 칸 조사
            x += dir[path[i]][0];
            y += dir[path[i]][1];
//            System.out.printf("%d,%d / cnt : %d\n",x,y,cnt);

            if (map[x][y] == savedValue) cnt++;
            // 다르다면 그전에 누적되서 쌓인값이 4개 이상인지 조사
            // 4개 이상이라면 전부 터뜨리고 값을 EMPTY로 바꾸어 줌
            // 4개 이상이 아니라면 savedValue에 현재값 저장하고 넘어감
            // else로 하면 맨 마지막에 터져야하는 구슬들이 못터지는 상황이 발생
            if (map[x][y] != savedValue || i==marbleNum) {
                if(cnt>=4) { // 폭발
                    isExploded = true;
                    tempX = x;
                    tempY = y;
                    for (int j=0;j<cnt;j++) {
                        tempX += reverse_dir[path[i-j]][0];
                        tempY += reverse_dir[path[i-j]][1];
                        map[tempX][tempY] = EMPTY;
                    }
                    marbles -= cnt;
                    explodedMarbles[savedValue] += cnt; // 폭발한 구슬 세기
                }

                savedValue = map[x][y]; // 공통
                cnt=1;
            }
            if (map[x][y] == EMPTY) break; // 이미 moveMarble을 거쳤기 때문에 바로 탈출해도 괜찮
        }
        /*System.out.println(isExploded);
        PrintMap(map);
        System.out.printf("구슬 개수 : %d\n",marbles);*/

        return isExploded;
    }

    public static void moveMarble() {
        int emptyPlace = 0;
        int dx, dy;
        int nowX = sharkX;
        int nowY = sharkY;
        int nextX, nextY;
        for (int i=1;i<N*N;i++) {
            dx = dir[path[i]][0];
            dy = dir[path[i]][1];
            nowX+=dx;
            nowY+=dy;
//            System.out.printf("now : (%d,%d)\n",nowX, nowY);
//            if (map[nowX][nowY] == EMPTY) emptyPlace++;
            nextX = nowX;
            nextY = nowY;
            for (int j=1;j<=emptyPlace && i+j<N*N;j++) {
                nextX += dir[path[i+j]][0];
                nextY += dir[path[i+j]][1];
            }

            while(map[nextX][nextY]==EMPTY) {
                // next의 칸 번호는 mapNumber[nextX][nextY]
                // 다음칸으로 가줘야함.
                if (mapNumber[nextX][nextY]>=N*N-1) break;
                int tmp_mapNum = mapNumber[nextX][nextY];
                nextX += dir[path[tmp_mapNum+1]][0];
                nextY += dir[path[tmp_mapNum+1]][1];
                emptyPlace++;
            }
//            System.out.printf("empty : %d\n", emptyPlace);
//            System.out.printf("next : (%d,%d)\n\n",nextX, nextY);
            map[nowX][nowY] = map[nextX][nextY];
        }
        MakeEmpty();

    }

    public static void Blizzard(int direction, int dist) {
        int dx = dir[direction][0];
        int dy = dir[direction][1];

        for (int i=1;i<=dist;i++) {
            map[sharkX+(dx*i)][sharkY+(dy*i)] = EMPTY;
            marbles--;
        }
    }

    public static void CreatePath() {
        int[] order = {3, 2, 4, 1};
        int repeat = 1;
        int repeatNum = 0;
        int repeatIncreaseElement = 0;
        int direction = 0; // order 배열의 인덱스


        for (int i=1;i<N*N-1;i++) {
            // 반복이 덜끝났다면 원래 방향 그대로
            if (repeatNum++<repeat) path[i] = order[direction];

            // 반복이 끝났다면 방향과 반복횟수 바꿔주기
            if (repeatNum>=repeat) {
                // 방향 바꾸기
                direction = (direction+1)%4;
                repeatNum = 0;
                repeatIncreaseElement++;

                // 반복 횟수는 방향을 두번바꾸면 반복횟수+1
                if (repeatIncreaseElement==2) {
                    repeat++;
                    repeatIncreaseElement = 0;
                }
            }
        }
        path[N*N-1] = path[N*N-2];
    }

    public static void CreateMapNumber() {
        int x = sharkX;
        int y = sharkY;
        for (int i=1;i<N*N;i++) {
            x+=dir[path[i]][0];
            y+=dir[path[i]][1];
            mapNumber[x][y] = i;
        }
    }

    public static void MakeEmpty() {
        int x = 1;
        int y = 1;
        for (int i=N*N-1; i>marbles; i--) {
            map[x][y] = EMPTY;
            x += reverse_dir[path[i]][0];
            y += reverse_dir[path[i]][1];
        }
    }

    public static void CopyMap(int[][] copy) {
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) copy[i][j] = map[i][j];
        }
    }

    public static void PrintMap(int[][] map) {
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) System.out.printf("%d ",map[i][j]);
            System.out.println();
        }
        System.out.println();
    }
}




















