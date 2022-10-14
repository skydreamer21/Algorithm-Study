import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Q10815_2 {
    static int N, M;
    static boolean[] isIn;
    static final int MAX = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        isIn = new boolean[2*MAX+1];
        for(int i=0; i<N; i++){
            isIn[Integer.parseInt(st.nextToken())+MAX] = true;
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            if(isIn[Integer.parseInt(st.nextToken())+MAX])
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
