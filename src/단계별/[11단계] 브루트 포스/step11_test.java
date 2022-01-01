
import java.util.Scanner;
import java.util.LinkedList;

public class step11_test {
    public static void main(String args[]) {
        /* int 배열 초기값 : 0 / int 상수는 초기값이 없음
        int[] arr = new int[5];
        for (int num : arr) System.out.println(num);
        int a=0;
        System.out.println(a);
         */

        /* 0제곱 출력 1 가능
        int a=3;
        int b=(int)Math.pow(3,0);
        System.out.println(b);
         */

        /* a=b 했을 때 별개인지 : 별개임
        int a=3;
        int b=a;
        a++;
        System.out.println(a+" "+b);
         */

        /* boolean 초기값 -> null  배열과는 다름
        boolean A = false;
        System.out.println(A);
         */

        /* int -> String
         String.valueOf
         */

        /* LinkedList add

         */
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(3);
        arr.add(0,5);
        arr.add(1,10);
        for (Integer num : arr) System.out.println(num);
    }
}




