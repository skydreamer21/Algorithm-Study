/*
<Selection Sort Optimization>

 */


package Blog_Post.Sort;

import java.io.*;
import java.util.StringTokenizer;

public class SelectionSort_Opt {
    static int N;
    static int[] arr;

    public static void main(String args[]) throws IOException {
        FileReader rd = new FileReader("D:\\블로그\\Velog\\Algorithm\\Sort\\data.txt");
        BufferedReader br = new BufferedReader(rd);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
//        printArr();
//        int selectionSort = SelectionSort();
//        int selectionSort = SelectionSort_MinMax();
        int selectionSort = SelectionSort_Opt();
        printArr();
        System.out.printf("Selection Sort 반복 횟수 : %d\n",selectionSort);


//        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int SelectionSort_Opt() {
        int min;
        int minIdx=-1;
        int sorted=0;
        int count=0;
        int tmp;
        int tmp2;
        for (int i=0;i<N;i++) {
            min=Integer.MAX_VALUE;
            for (int j=sorted; j<N;j++) {
                count++;
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                    count++;
                }
            }
            sorted++;
            int idx = BS_upperBound(min, sorted);
            tmp = arr[idx];
            arr[idx] = arr[minIdx];
            count+=10;
            // minIdx 자리는 현재 비어있는 상태임
            // minIdx는 sorted보다 항상 뒤에 있음
            for (int j=idx+1;j<sorted;j++) {
                count++;
                tmp2 = arr[j];
                arr[j] = tmp;
                tmp = tmp2;
            }
            for (int j=sorted;j<N;j++) {
                count++;
                if (j==minIdx) {
                    sorted++;
                    arr[minIdx] = tmp;
                    count++;
                    continue;
                }

                if (tmp<arr[j]) {
                    sorted++;
                    if (j>minIdx) {
                        tmp = arr[j];
                        count++;
                        continue;
                    }
                    tmp2 = arr[j];
                    arr[j] = tmp;
                    tmp = tmp2;
                    count++;
                }

                else {
                    count++;
                    if (j>minIdx) break;
                    arr[minIdx] = tmp;
                    count++;
                    break;
                }
            }
            count++;
            if (sorted==N) return count;
        }
        return count;
    }

    public static int BS_upperBound(int key, int high) {
        int lo = 0;
        int hi = high;
        int mid;

        while(lo<hi) {
            mid = (lo+hi)/2;
            if (arr[mid]<=key) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }

    public static int SelectionSort() {
        int min;
        int minIdx=-1;
        int count=0;
        for (int i=0;i<N;i++) {
            min=Integer.MAX_VALUE;
            for (int j=i;j<N;j++) {
                count++;
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                    count++;
                }
            }
            swap(i,minIdx);
        }
        return count;
    }

    public static int SelectionSort_MinMax() {
        int min, max;
        int minIdx = -1;
        int maxIdx = -1;
        int count=0;
        for (int i=0;i<N/2;i++) {
            min=Integer.MAX_VALUE;
            max=Integer.MIN_VALUE;
            for (int j=i;j<N-i;j++) {
                count++;
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                    count++;
                    continue;
                }
                count++;
                if (arr[j] > max) {
                    max = arr[j];
                    maxIdx = j;
                    count++;
                }
            }
            swap(i,minIdx);
            swap(N-1-i,maxIdx);
        }
        return count;
    }

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArr() {
        for (int i=0;i<N;i++) System.out.printf("%d ",arr[i]);
        System.out.println();
    }
}












