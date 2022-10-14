// 1759번 암호만들기 (G5) [backtracking]
/*
<문제 정보>
 1. 암호
    - 서로 다른 L개의 알파벳 소문자
    - 최소 한 개의 모음, 최소 두개의 자음으로 구성
    - 증가하는 알파벳 순
    - 사용한 문자의 종류 C가지

<변수 범위>
 1. 2초 / 128MB
 2. 3<=L<=C<=15

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 다시 짜보자...

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Q1759_r {
    static int L;
    static ArrayList<Integer> consonant = new ArrayList<>();
    static ArrayList<Integer> vowel = new ArrayList<>();
    static ArrayList<Integer> pwd = new ArrayList<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()); // C개의 문자 입력
        int alphabet;
        while (C-- >0) {
            alphabet = st.nextToken().charAt(0)-'a';
            if (alphabet==0 || alphabet==4 || alphabet==8 || alphabet==14 || alphabet==20) vowel.add(alphabet);
            else consonant.add(alphabet);
        }
        // 모음 최대 개수
        Collections.sort(consonant);
        Collections.sort(vowel);



        int maxVowel = Math.min(vowel.size(),L-2);
//        System.out.printf("maxG : %d\n",maxVowel);
        for (int i=1;i<=maxVowel;i++) {
            addPWD(i,0,0);
            pwd.clear();
        }

        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void addPWD(int g, int depth, int idx) {
        if (depth==g) {
            addConsonant(depth,0);
        }
        if (idx==vowel.size()) return;
        for (int i=idx;i<vowel.size();i++) {
            pwd.add(vowel.get(i)); // 만약 stack구조없이 배열로 한다면 boolean 일차원 배열을 하나 쓰면 됨 isUsed
            addPWD(g,depth+1,i+1);
            pwd.remove(depth);
        }
    }

    public static void addConsonant(int depth, int idx) {
        if (depth==L) {
            PriorityQueue<Integer> password = new PriorityQueue<>();
            password.addAll(pwd);
            char[] p = new char[pwd.size()];
            int i=0;
            while(!password.isEmpty()) p[i++]=(char)(password.poll()+'a');
//            System.out.println(String.valueOf(p));
            pq.add(String.valueOf(p));
        }
        if (idx==consonant.size()) return;
        for (int i=idx;i<consonant.size();i++) {
            pwd.add(consonant.get(i));
            addConsonant(depth+1,i+1);
            pwd.remove(depth);
        }
    }

}


