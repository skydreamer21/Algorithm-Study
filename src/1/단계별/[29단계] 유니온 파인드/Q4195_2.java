// 4195번 친구 네트워크
/*
<문제 정보>
 1. 친구 네트워크에 몇명있는지 출력

<변수 범위>
 1. 3초 / 256MB
 2. 친구 관계의 수 F 100,000 이하 자연수
 3. 사용자 아이디 알파벳 대소문자로 이루어진 길이 20 이하의 문자열

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Q4195_2 {
    static HashMap<String, Integer> FN; //Friend_Network
    static int[] parent;
    static int[] FNnum;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N;
        String f1, f2;
        while (T-- >0) {
            N = Integer.parseInt(br.readLine());
            FN = new HashMap<>();
            parent = new int[N*2]; // N*2 : 최대 사람 명수
            FNnum = new int[N*2];
            initSet(N*2);
            int idx=0;
            while (N-->0) {
                st = new StringTokenizer(br.readLine());
                f1 = st.nextToken();
                f2 = st.nextToken();
                if (!FN.containsKey(f1)) FN.put(f1,idx++);
                if (!FN.containsKey(f2)) FN.put(f2,idx++); // Map을 사용해 하나의 이름을 하나의 숫자에 매치
                sb.append(union(FN.get(f1),FN.get(f2))).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initSet (int N) {
        for (int i=0;i<N;i++) {
            parent[i]=i;
            FNnum[i]=1;
        }
    }

    public static int find (int f_idx) {
        if(parent[f_idx] == f_idx) return f_idx;
        return parent[f_idx] = find(parent[f_idx]);
    }

    public static int union (int f_idx1, int f_idx2) {
        f_idx1 = find(f_idx1);
        f_idx2 = find(f_idx2);

        if (f_idx1!=f_idx2) {
            parent[f_idx2] = f_idx1; // f2그룹을 f1그룹에 합침
            FNnum[f_idx1]+=FNnum[f_idx2];
        }
        return FNnum[f_idx1];
    }
}



























