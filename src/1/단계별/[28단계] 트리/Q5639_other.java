import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q5639_other {
    static Object[] arr;
    static ArrayList<Integer> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String num = "";
        list = new ArrayList<>();

        while((num = br.readLine()) != null) {
            list.add(Integer.parseInt(num));
        }

        arr = list.toArray();

        Search(0, list.size());
        System.out.println(sb.toString());
    }

    private static void Search(int idx1, int idx2) {
        if(idx1 == idx2) return;

        int num = list.get(idx1);
        int rightIdx = Arrays.binarySearch(arr, idx1 + 1, idx2, num);
        // pre 에서 root에 대해 BS를 써도 사이에 들어갈 인덱스가 나옴!
        // 왼쪽트리 오른쪽 트리 자체는 오름차순이기 때문!
        // -> Inorder를 쓰지 않고 pre만으로도 찾기 가능!
        if(rightIdx < 0) rightIdx = (rightIdx + 1) * -1;

        Search(idx1 + 1, rightIdx);
        Search(rightIdx, idx2);
        sb.append(num).append('\n');
        // 위의 세개 순서가 말그대로 Post 순서
    }
}