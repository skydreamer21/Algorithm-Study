
import java.io.*;

public class test_12 {
    public static void swap (int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
    public static void swap_arrInput(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String args[]) throws IOException {
        int a=3;
        int b=5;
        swap(a, b);
        int[] arr = new int[2];
        arr[0]=3;
        arr[1]=5;
        swap(arr[0],arr[1]);
        int[] arr2 = {3, 5};
        swap_arrInput(arr2,0,1);

        System.out.printf("a : %d, b : %d\n",a, b);
        System.out.printf("arr[0] : %d, arr[1] : %d\n",arr[0], arr[1]);
        System.out.printf("arr2[0] : %d, arr2[1] : %d",arr2[0], arr2[1]);
    }
}