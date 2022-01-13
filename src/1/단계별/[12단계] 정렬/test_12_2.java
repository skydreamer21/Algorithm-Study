import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_12_2 {
    public static void getAverage (int[] arr) {
        int sum=0;
        for (int num : arr) sum+=num;
        int average = sum/arr.length;
        System.out.println(average);
    }

    public static void printCoor (int[][] arr) {
        for (int i=0;i<arr.length;i++) System.out.println(Arrays.toString(arr[i]));
    }

    public static void main(String args[]) throws IOException {
        /* 배열 출력
        int[] arr= {1,2};
        System.out.println(arr.toString());
        System.out.println(Arrays.toString(arr));
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        getAverage(arr);
         */

        int N = Integer.parseInt(br.readLine());
        int[][] coor = new int [N][2];
        String input;
        StringTokenizer st;
        for (int i=0;i<N;i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            coor[i][0] = Integer.parseInt(st.nextToken());
            coor[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] temp = coor[0];
        coor[0] = coor[1];
        coor[1] = temp;
        printCoor(coor);

    }
}