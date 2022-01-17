// 10814번 나이순 정렬

/*
<문제 정보>
 1. 사람들의 나이와 이름이 가입한 순서대로 주어짐
 2. 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에오는 순서로
 3. 1<=N<=100,000
 4. 나이는 1이상 200이하, 이름은 알파벳 대소문자, 길이 100이하

<프로그램 진행>
 1. Arrays.sort
 2. Person 클래스


<필요 함수>
 1.

 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person {
    int age;
    String name;
    int order;

    Person (int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class Q10814 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Person[] arr = new Person[N];
        for (int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            arr[i] = new Person(Integer.parseInt(st.nextToken()),st.nextToken(),i+1);
        }
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age==o2.age) return o1.order-o2.order;
                else return o1.age-o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Person prs : arr) sb.append(prs.age).append(" ").append(prs.name).append("\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}