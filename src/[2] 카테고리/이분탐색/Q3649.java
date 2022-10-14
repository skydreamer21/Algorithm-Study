// 3649번 로봇 프로젝트 (G5)
/*
<문제 정보>
 1. 구멍의 너비를 두 개의 조각으로 정확히 채워야 한다.
    - 가능하다면 yes l1 l2 출력
        -> 여러개라면 l1, l2의 차이가 큰 것으로 출력
    - 불가능하다면 danger 출력

<변수 범위>
 1. 5초 / 256MB
 2. 1 <= x <= 20 (cm)
 3. 레고 조각 수 n 0 <= n <= 1_000_000
 4. 한 조각당 10cm 를 넘지 않는다.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 1cm = 10mm = 10_000_000
// 10cm = 100mm = 100_000_000


import java.io.*;
import java.util.Arrays;

public class Q3649 {
    static int hole, numOfPiece, numOfHalfOfHole;
    static int[] pieces;
    static boolean isPossible;

    static final int NM_TO_MM = 10_000_000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String inputOfHole;
        while ( ( inputOfHole = br.readLine() ) != null ) {
            // ******************** 입력 & 초기화 ********************

            isPossible = false;
            hole = Integer.parseInt(inputOfHole) * NM_TO_MM;
            if ( hole < 0 ) break;
            numOfPiece = Integer.parseInt(br.readLine());
            pieces = new int[numOfPiece];
//            System.out.printf("hole : %d, numOfPieces : %d\n", hole, numOfPiece);

            numOfHalfOfHole = 0;
            for (int i = 0; i < numOfPiece; i++) {
                pieces[i] = Integer.parseInt(br.readLine());
                if (pieces[i] == hole/2 ) numOfHalfOfHole++;
            }

            // ******************** 메인 로직 & 정답출력 ********************
            Arrays.sort(pieces);
            /*for (int i=0;i<numOfPiece;i++) {
                System.out.printf("%d ", pieces[i]);
            }
            System.out.printf("\n");*/

            for (int i = 0; i < numOfPiece; i++ ) {
                if (checkOtherPart(pieces[i], i+1)) {
                    if (pieces[i] * 2 == hole && numOfHalfOfHole < 2)  continue;
                    sb.append("yes ").append(pieces[i]).append(" ").append(hole - pieces[i]).append("\n");
                    isPossible = true;
                    break;
                }
            }

            if ( !isPossible ) sb.append("danger\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkOtherPart (int pieceLength, int loIdx) {
        int lo = loIdx;
        int hi = pieces.length;
        int mid; // 인덱스

        while (lo < hi) {
            mid = (lo + hi) / 2;
            if ( pieceLength + pieces[mid] == hole ) return true;
            else if (pieceLength + pieces[mid] < hole ) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
