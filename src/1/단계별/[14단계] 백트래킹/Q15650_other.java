import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15650_other {

    static int N, M;
    static BufferedWriter bw;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sk = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(sk.nextToken());
        N = Integer.parseInt(sk.nextToken());
        result = new int[N];

        nCr(0, 0);
        bw.flush();
        bw.close();
    }

    private static void nCr(int s_idx, int depth) throws IOException {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = s_idx; i < M; i++) {
            result[depth] = i+1;
            nCr(i+1, depth+1);
        }
    }
}