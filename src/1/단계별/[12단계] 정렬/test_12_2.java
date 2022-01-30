import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Comparator;

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
        /* 2차원 배열 swap
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
        */

        // String[] arr = {"abc","abc","show","picture","bite","but","camera","butter","pen","can"};
         /*
         //Arrays.sort(arr,Collections.reverseOrder());
        Arrays.sort(arr, new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return o1.length()-o2.length();
             }
         });
         System.out.println(Arrays.toString(arr));
         */
        //System.out.println(arr[0]==arr[1]);
        String S = br.readLine();
        if(S.equals("")) System.out.println(1);
        else System.out.println(0);
    }
}