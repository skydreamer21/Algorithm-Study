// 3053번 택시기하학

/*
<문제 정보>
 1. 반지름 R이 주어질때 유클리드 기하학에서의 원의 넓이와
 택시 기하학에서의 원의 넓이 출력

<프로그램 진행>
 1. 10.0 이 아닌 10.000000으로 나오게함에 주의 -> String.format

<필요 함수>
 1.

 */

import java.io.*;

public class Q3053 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double R = Double.parseDouble(br.readLine());
        double EuclidCircle = Math.PI*R*R;
        double TaxiCircle = 2*R*R;
        bw.write(String.format("%.6f",EuclidCircle)+"\n"+String.format("%.6f",TaxiCircle));
        bw.flush();
        bw.close();
    }
}