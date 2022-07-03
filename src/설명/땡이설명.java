// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


package 설명;

import java.io.*;

public class 땡이설명 {

    // 메인함수
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = 10;
        // 1~ N 더한값 -> 함수
        N = Sum(N);

        // class 변수명 =
        Person 주땡 = new Person();


        int n;
        String str;
        float f;


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 1 ~ N 더한값을 반환 -> 함수
    public static int Sum(int N) {
        return 1;
    }
}



// 사람
// 값, 행동 -> 사람의 속성(attribute)
// 값 : 키, 몸무게
// 행동 : 먹다, 자다

// class 항상 생성자 함수를 기본 가지고 있다!!
//  class의 이름과 똑같은 생성자 함수를 가지고 있다!
class Person {
    // 값 -> property
    int height;
    int weight;

    // 함수 -> 메서드
    public void eat() {

    }

    public void sleep() {

    }
}














