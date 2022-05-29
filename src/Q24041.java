// 24041번 성싶당 밀키트 (G5)
/*
<문제 정보>
 1. 밀키트를 사서 재료를 최대 K개 까지 빼서 세균수가 G마리 이하가 되는 최대 날수를 출력
    - 구매 후 x 일에 i번째 재료의 세균수 : S_i x max(1,x-L_i)
    - O_i : 재료가 중요해서 뺄 수 없다면 0, 그렇지 않아서 뺄 수 있다면 1

<변수 범위>
 1. 2초 / 1024MB
 2. 재료의 수 1<=N<=200,000
 3. 1<=G<=10^9
 4. 0<=K<N
 5. 1<=S_i<=10^9
 6. 1<=L_i<=10^9
 7. 모든 재료의 S_i 합은 G를 넘지 않는다. (넘어버리면 하루도 못먹음)

<프로그램 진행>
 1. f(x) = 세균수
    - f(x) : 각 재료의 x일 후 세균수( O(N) ) 중 높은 순서대로 ( O(NlogN) ) K개를 뺀 세균수
    => f(x) 한번 계산시 O(NlogN)
 2. x 증가 -> 세균수 증가
 3. x가 일정 날 수를 넘어 서면 세균수가 G보다 많아진다.
    -> BS_UpperBound

** lo+hi 과정에서 overflow 가능성

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Q24041 {
    static int N, G, K;
    static int[][] ingredients;

    static final int S = 0;
    static final int L = 1;
    static final int O = 2;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ingredients = new int[N][3];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][S] = Integer.parseInt(st.nextToken());
            ingredients[i][L] = Integer.parseInt(st.nextToken());
            ingredients[i][O] = Integer.parseInt(st.nextToken());
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BS_UpperBound (int key) {
        int lo = 1;
        int hi = 2000000001;
        int mid;
        
        while(lo<hi) {
            // 더하는 과정에서 overflow 가능성 있음
        }
        return lo;
    }

    public static int numOfGerms (int days) {
        PriorityQueue<Ingredient> pq = new PriorityQueue<>();
        for (int i=0;i<N;i++) pq.add(new Ingredient(days, ingredients[i]));
        int removed = 0;
        int germs = 0;
        for (int i=0;i<N;i++) {
            if(pq.peek().isNecessary) {
                germs += pq.poll().germs;
                continue;
            }

            if(removed<K) {
                pq.poll();
                removed++;
            }
            else germs+=pq.poll().germs;
        }
        return germs;
    }
}

class Ingredient implements Comparable<Ingredient> {
    int germs;
    boolean isNecessary;

    public Ingredient (int days, int[] info) {
        this.germs = info[0] * (Math.max(1,days-info[1]));
        isNecessary = info[2]==0;
    }

    @Override
    public int compareTo(Ingredient o) {
        return o.germs - this.germs;
    }
}












