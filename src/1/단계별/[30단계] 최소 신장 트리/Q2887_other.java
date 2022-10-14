import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 내가 짠 코드랑 완전 같은 구성인데 300ms 정도 차이남
// 다른건 정렬할때 난 Arrays.sort를 썻고 이친구는 Collections.sort를 씀

class P{
    int idx, value;;
    public P(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

class PDistance {
    int idx1, idx2, distance;

    public PDistance(int idx1, int idx2, int distance) {
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.distance = distance;
    }
}

public class Q2887_other {

    public static int find(int[] arr, int num) {
        if (arr[num] == -1)
            return num;
        return arr[num] = find(arr, arr[num]);
    }

    public static boolean makeSet(int[] arr, int a, int b) {
        int p1 = find(arr, a);
        int p2 = find(arr, b);
        if (p1 == p2)
            return false;
        arr[p2] = p1;
        return true;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<P> listX = new ArrayList<>();
        List<P> listY = new ArrayList<>();
        List<P> listZ = new ArrayList<>();
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            listX.add(new P(N, Integer.parseInt(st.nextToken())));
            listY.add(new P(N,Integer.parseInt(st.nextToken())));
            listZ.add(new P(N, Integer.parseInt(st.nextToken())));
        }
        Comparator<P> comparator = new Comparator<P>() {

            @Override
            public int compare(P o1, P o2) {
                // TODO Auto-generated method stub
                return o1.value-o2.value;
            }

        };
        Collections.sort(listX, comparator);
        Collections.sort(listY, comparator);
        Collections.sort(listZ, comparator);

        PriorityQueue<PDistance> queue = new PriorityQueue<PDistance>(new Comparator<PDistance>() {

            @Override
            public int compare(PDistance o1, PDistance o2) {
                // TODO Auto-generated method stub
                return o1.distance-o2.distance;
            }

        });

        for(int i = 1; i < parent.length; i++) {
            P p1= listX.get(i), p2 = listX.get(i-1);
            queue.add(new PDistance(p1.idx, p2.idx, Math.abs(p1.value-p2.value)));
            p1= listY.get(i); p2 = listY.get(i-1);
            queue.add(new PDistance(p1.idx, p2.idx, Math.abs(p1.value-p2.value)));
            p1 = listZ.get(i); p2 = listZ.get(i-1);
            queue.add(new PDistance(p1.idx, p2.idx, Math.abs(p1.value-p2.value)));
        }
        int count= 0;
        int distance = 0;
        while(!queue.isEmpty()) {

            PDistance p = queue.poll();
            if(!makeSet(parent, p.idx1, p.idx2))continue;
            distance += p.distance;
            if(++count == N-1)break;
        }
        System.out.println(distance);
        br.close();
    }

}