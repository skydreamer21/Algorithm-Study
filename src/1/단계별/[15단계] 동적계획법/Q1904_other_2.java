// IntelliJ 에서는 StackOverFlow Error

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1904_other_2 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int [N+1];
        arr[0] = 0;
        if(N>=1) {arr[1] = 1;}
        if(N>=2) {arr[2] = 2;}

        System.out.print(binary(N));
        br.close();
    }
    static int binary(int N) {
        if(arr[N]!=0||N==0||N==1) {
            return arr[N];
        }
        else {
            return arr[N] = (binary(N-1) + binary(N-2))%15746;
        }
    }
}