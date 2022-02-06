// 10816번 숫자 카드 2
/*
<문제 정보>
 1. 숫자 카드 N 개 중 주어진 수들이 적혀있는 숫자카드가 몇개인지 출력
 2. 1<=N<=500,000  /  카드에 적힌 수는 -10,000,000이상 10,000,000 이하 정수
 3. 1<=M<=500,000

<프로그램 진행>
 1. 중복된 카드가 있는 것을 고려

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1920 {
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int M = Integer.parseInt(br.readLine());
        int num;
        st = new StringTokenizer(br.readLine());
        while (M-- >0) {
            num = Integer.parseInt(st.nextToken());
            //System.out.println(num);
            sb.append(Binary_Search(num)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int Binary_Search (int n) {
        int left = 0;
        int right = arr.length-1;
        int mid; int mid2; int mid3;
        int temp;
        while (left<=right) {
            //System.out.printf("left : %d, right : %d\n",left,right);
            mid = (left+right)/2;
            if(arr[mid]==n) {
                mid2 = mid;
                //System.out.println("<left>");
                while (mid2>left && (arr[mid2]!=n || arr[mid2-1]==n)) {
                    //System.out.printf("left : %d, right : %d\n",left,mid2);
                    temp = (left+mid2)/2;
                    if (arr[temp]==n) mid2 = temp;
                    else left = temp;
                }
                //System.out.printf("mid2 : %d\n",mid2);

                mid3 = mid;
                //System.out.println("<right>");
                while (mid3 <right && (arr[mid3]!=n || arr[mid3+1]==n)) {
                    //System.out.printf("left : %d, right : %d\n",mid3,right);
                    temp = (mid3+right)/2;
                    if (arr[temp]==n) {
                        if (temp+1==right) {
                            if (arr[right]==n) mid3 = right;
                            else {
                                mid3 = temp;
                                break;
                            }
                        }
                        else mid3 = temp;
                    }
                    else right = temp;
                }
                //System.out.printf("mid3 : %d\n",mid3);
                return mid3 - mid2 + 1;
            }
            else if (arr[mid]>n) right = mid-1;
            else left = mid+1;
        }
        return 0;
    }
}