// 18111번 마인크래프트 (S2) [구현]
/*
<문제 정보>
 1. 땅의 높이를 일정하게 맞출 때 걸리는 최소 시간과 땅의 높이
    - i,j 의 가장 위의 블록 제거하고 인벤토리로 -> 2초
    - 인벤토리에서 블록 하나 꺼내서 i,j 가장 위에 놓는다. -> 1초

<변수 범위>
 1. 1초 / 1024MB
 2. 세로 N, 가로 M 1<=M,N<=500
 3. 블록의 개수 0<=B<=6.4 * 10^7
 4. 땅의 높이는 0이상 256이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

/*
    1. 땅의 높이 정보를 1차원 배열로 받아 내림차순으로 정렬
    2. Max -> Min 까지 탐색
    3. 전부 Max로 맞추는데 드는 필요한 블럭 수를 계산
    4. 높이 포인터를 두고 max->min 내려가는 동안 알맞게 움직여서 해당 높이 이하의 땅의 수를 카운트 해줄 수 있도록
        4-1. 기준 높이가 낮아질 때마다 필요한 블럭 개수 수정 필요
            -> 포인터보다 낮은 높이를 가지고 있는 땅의 개수 만큼 줄어듬
    5. 해당 높이보다 높은 땅을 먼저 빼서 사용하능한 블럭 수를 최대로 만들어주고 해당 높이 이하의 땅을 탐색
 */



import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q18111 {
    static int N, M, sizeOfLand, numOfBlocks;
    static int minTime = Integer.MAX_VALUE;
    static int heightOfMinTime = 0;
    static Integer[] lands;

    static final int IMPOSSIBLE = -1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numOfBlocks = Integer.parseInt(st.nextToken());
        sizeOfLand = N*M;
        lands = new Integer[sizeOfLand];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                lands[i*M+j] = Integer.parseInt(st.nextToken());
            }
        }

        // ******************** 메인 로직 ********************

        // 1. 내림차순 정렬
        Arrays.sort(lands, (a,b) -> b-a);

        // 2. 모두 maxHeight로 만들기 위한 블럭수 계산
        int blocksNeedForHeight = getBlocksNeedForMaxHeight();

        int maxHeight = lands[0];
        int minHeight = lands[sizeOfLand-1];

        int flatteningTime, time;
        int indexOfRefHeight = 0;
        while (lands[indexOfRefHeight].equals(lands[indexOfRefHeight+1])) {
            indexOfRefHeight++;
            if (indexOfRefHeight+1 == sizeOfLand-1) break;
        }

        int usableBlocks = numOfBlocks;
        int timeForGetBlocks = 0;
        for (int height=maxHeight; height>=minHeight; height--) {
            // 1. 현재 height 가 기존 indexOfRefHeight의 다음 index 높이와 같아진다면 indexOfRefHeight 갱신
            if (indexOfRefHeight<sizeOfLand-1 && height == lands[indexOfRefHeight+1]) {
                indexOfRefHeight++;
                while (indexOfRefHeight<sizeOfLand-1 && lands[indexOfRefHeight].equals(lands[indexOfRefHeight+1])) {
                    indexOfRefHeight++;
                }
            }

//            System.out.printf("height : %d, refIdx : %d, blocksNeeded : %d, usableBlock : %d\n",height, indexOfRefHeight, blocksNeedForHeight, usableBlocks);


            // 2. 시간 계산 후 저장된 값과 비교
            flatteningTime = getTimeForFlattening(blocksNeedForHeight, usableBlocks);
            time = flatteningTime + timeForGetBlocks;

//            System.out.printf("flatteningTime : %d, time : %d\n",flatteningTime, time);

            if (flatteningTime!=IMPOSSIBLE && time < minTime) {
                minTime = time;
                heightOfMinTime = height;
            }

            // 3. 다음 높이에서 사용 가능한 블럭과 필요한 블럭 수정
            // indexOfRefHeight까지가 지금 height 이상인 블럭
            usableBlocks += indexOfRefHeight+1;
            timeForGetBlocks += 2*(indexOfRefHeight+1);
            blocksNeedForHeight -= sizeOfLand - (indexOfRefHeight+1);
        }

        // ******************** 정답 출력 ********************

        sb.append(minTime).append(" ").append(heightOfMinTime);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // heightLevel : 고르게 맞출 기준 높이
    // indexOfRefHeight : 기준 높이 보다 큰 높이를 가지고 있는 최대 인덱스
    public static int getTimeForFlattening(int blocksNeedForHeight, int usableBlocks) {
        // 2. 기준 높이 보다 낮은 땅들을 올린다. (불가능하면 IMPOSSIBLE(-1) return)
        if (usableBlocks < blocksNeedForHeight) return IMPOSSIBLE;

        // 2-2. 가능하다면 필요한 시간 return
        int time = blocksNeedForHeight;
        return time;
    }

    public static int getBlocksNeedForMaxHeight() {
        int blocks = 0;
        for (int i=0;i<sizeOfLand;i++) blocks += lands[0] - lands[i];
        return blocks;
    }
}
