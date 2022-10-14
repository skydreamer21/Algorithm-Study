import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Prim으로 구현한 코드
// 어떻게 Prim인지 이해해보기

public class Q4386_other {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        float[][] cood = new float[n][2];
        float[] minEdge = new float[n];
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cood[i][0] = Float.parseFloat(st.nextToken());
            cood[i][1] = Float.parseFloat(st.nextToken());
            minEdge[i] = Float.MAX_VALUE;
        }

        minEdge[0] = 0;
        float result = 0;

        for(int c=0; c<n; ++c) {
            float min = Float.MAX_VALUE;
            int v = 0;
            for(int i=0; i<n; ++i) {
                if(!visited[i] && min > minEdge[i]) {
                    min = minEdge[i];
                    v = i;
                }
            }

            result += min;
            visited[v] = true;

            for(int i=0; i<n; ++i) {
                float dis = (float) Math.sqrt((Math.pow(cood[v][0] - cood[i][0], 2)+(Math.pow(cood[v][1]-cood[i][1], 2))));
                if(!visited[i] && dis != 0 && dis<minEdge[i]) {
                    minEdge[i] = dis;
                }
            }
        }
        System.out.printf("%.2f",result);
    }
}