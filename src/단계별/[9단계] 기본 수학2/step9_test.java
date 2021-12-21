// 자바 배열 변환 test
import java.io.*;

public class step9_test {
    public static void plusOne (int[] arr) {
        for (int i=0;i<arr.length;i++) arr[i]++;
    }
    public static void main(String args[]) {
        int[] arr = {4,5,6};
        int[] br = {5,6};
        int[] abr = new int[5];
        //for (int num : arr) System.out.println(num);
        plusOne(arr);
        //for (int num : arr) System.out.println(num);
        Boolean[] val = new Boolean[3];
        // Boolean 초기값은 null
        for (Boolean temp : val) System.out.println(temp);
    }
}




