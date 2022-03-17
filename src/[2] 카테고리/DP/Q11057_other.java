import java.io.*;
import java.util.Arrays;

public class Q11057_other {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] IN = new int[11];
        int[] OUT = new int[11];
        int sum = 0;
        Arrays.fill(IN, 1);
        for (int i = 1; i < N; i++) {
            OUT = new int[11];
            for (int j = 1; j < 11; j++) {
                for (int k = 1; k <= j; k++) {
                    OUT[j] += (IN[k] % 10007);
                }
            }
            IN = OUT;
        }
        for (int i = 1; i < 11; i++)
            sum+=IN[i];
        bw.write(String.valueOf(sum % 10007));
        bw.flush();
        bw.close();
    }
}