import java.io.*;

public class Q1904_other {
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = N;

        if (N > 3) {
            int a = 1;
            int b = 2;
            for (int i = 3; i <= N; i++) {
                result = (a + b) % 15746;
                a = b;
                b = result;
            }
        }

        System.out.println(result);
        br.close();
    }
}