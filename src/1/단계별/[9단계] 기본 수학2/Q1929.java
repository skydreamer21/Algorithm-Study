// 1929번 소수 구하기
/*
<문제 정보>
 1. M 이상 N이하의 소수를 모두 출력 (M<=N<=1,000,000)
 2. 사이에 소수가 하나 이상 있는 입력만 주어짐
 3. 한줄에 하나씩 증가하는 순서대로 소수 입력

<프로그램 진행>
 1. N까지의 소수를 모두 구해서 배열로 만들고 M이상의 소수들을 출력
 2. 에라토스테네스의 체 이용

<필요 함수>
  1. N이 입력일 때, N까지의 소수들이 담긴 배열을 return
  2. 배열과 한 정수가 주어지면 배열에서 해당 정수의 배수를 삭제한 배열을 return
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1929 {

    public static int[] getDeletedArray(int[] arr, int N) {
        int cnt=0;
        int index=0;
        Boolean first = true;
        /*
        아래 반복문이 시간이 많이 걸리는 이유
        1. 배열의 모든 값을 검사
        2. 소수에 해당하는 N이 들어왔기 때문에 N씩 더해가면서 false로만 바꿔주면 됨.
        3. 즉 바꿀 값이 정해져 있기 때문에 굳이 if문을 쓸 필요가 없음.
        4. 시작을 0으로 할 필요가 없음. 이 함수를 쓰는 과정에서 이미 앞에
        소수들에서 remove를 거쳤기 때문에 2,3,5,...N-1의 배수들은 이미 처리가 된 상태
        5. 따라서 시작을 N*N부터 하면 가장 빠름.
         */

        for (int i=0; i<arr.length; i++) {
            if (arr[i]%N==0) {
                if (first) first = false;
                else {
                    cnt++;
                    arr[i]=-1;
                }
            }
        }
        int[] newArr = new int[arr.length-cnt];
        for (int i=0; i<arr.length; i++) {
            if (arr[i]!=-1) {
                newArr[index]=arr[i];
                index++;
            }
        }
        return newArr;
    }

    public static int[] getPrimeNumberList (int N) {
        int sqrtNum = (int) Math.floor(Math.sqrt(N));
        int temp_Prime=2;
        int[] arr = new int[N-1];
        int index=0;
        for (int i=0; i<N-1; i++) arr[i]=i+2;
        while(temp_Prime<=sqrtNum) {
            arr=getDeletedArray(arr, temp_Prime);
            index++;
            temp_Prime=arr[index];
        }
        return arr;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        StringTokenizer st = new StringTokenizer(S);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] PrimeNum = getPrimeNumberList(N);
        for (int num : PrimeNum) {
            if (num >= M) bw.write(num+"\n");
        }
        bw.flush();
        bw.close();
    }
}




