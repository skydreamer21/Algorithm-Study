// 2141번 우체국 (G4) [math, greedy]
/*
<문제 정보>
 1. 각 사람들과의 거리의 합이 최소가 되는 지점에 우체국을 잡으려고 할 때 지점을 출력
 2. 가능한 위치가 여러개라면 작은 곳 출력

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2141 {
    static int N;
    static Pos3[] population;;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        population = new Pos3[N];
        int pos, pop;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            pos = Integer.parseInt(st.nextToken());
            pop = Integer.parseInt(st.nextToken());
            population[i] = new Pos3(pos, pop);
        }


        // ******************** 메인 로직 ********************
        Arrays.sort(population);
        long sum = 0;
        int postOffice = -1;
        for (Pos3 p : population) sum += p.pop;
        for (int i=0;i<N;i++) {
            sum -= 2*population[i].pop;
            if (sum <=0 ) {
                postOffice = population[i].pos;
                break;
            }
        }

        // ******************** 정답 출력 ********************
        sb.append(postOffice);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Pos3 implements Comparable<Pos3>{
    int pos, pop;

    public Pos3 (int pos, int pop) {
        this.pos = pos;
        this.pop = pop;
    }

    @Override
    public int compareTo(Pos3 o) {
        return this.pos - o.pos;
    }
}
