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


//39662093	shipinwater
/*처음엔 그냥 Union-Find했는데 시간초과가 나와서 랭크를 써야한다는 소리를 듣고 찾아봄
        각 트리의 높이가 다를 때 높은 쪽으로 낮은 것이 붙어 그대로, 높이가 같으면 높이가 +1 된다.
        결론적으로 어느 루트를 이용하는 것이 이득인지 구분하는 것.

        근데 수업때 랭크랑 패스 압축을 같이 이용하면 성능이 안좋다고 했는데 그 이유가
        해당 루트 노드의 자식이 패스 압축이 일어날 때 다른 자식들이 압축이 안되었을 수 있어서
        해당 루트 노드의 랭크를 갱신하려면 다른 자식 또한 탐색해서 해야한다.
        그래서 랭크를 어떻게 쓰라는 건지 이해가 안되어서 동률님 코드 염탐

        보니까 랭크의 개념을 응용한 느낌이었다. 코드에선 랭크라고 하셨는데 랭크보단 해당 집합의 개수를 센 개념이 맞는 것 같다.
        왜냐하면 깊이끼리 더해서 사실상 개수를 센거다.
        해당 개념에서*/
// 무슨말인지 이해해보기

import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Q4195 {
    static HashMap<String, String> FN; //Friend_Network
    static HashMap<String, Integer> FNnum;

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
            FNnum = new HashMap<>();
            while (N-->0) {
                st = new StringTokenizer(br.readLine());
                f1 = st.nextToken();
                f2 = st.nextToken();
                if (!FN.containsKey(f1)) {
                    FN.put(f1,f1);
                    FNnum.put(f1,1);
                }
                if (!FN.containsKey(f2)) {
                    FN.put(f2,f2);
                    FNnum.put(f2,1);
                }
                sb.append(union(f1,f2)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String find (String name) {
        if (FN.get(name).equals(name)) return name;
        FN.put(name,find(FN.get(name)));
        return FN.get(name);
    }

    public static int union (String name1, String name2) {
        String f1 = find(name1);
        String f2 = find(name2);
        //System.out.printf("name1 : %s, name2 : %s\n",name1,name2);
        //System.out.printf("f1 : %s, f2 : %s\n\n",f1,f2);
        if (f1.compareTo(f2)==0) return FNnum.get(f1);
        else if(f1.compareTo(f2)>0) {
            FN.put(f1,f2);
            FNnum.put(f2,FNnum.get(f1)+FNnum.get(f2));
            return FNnum.get(f2);
        }
        else {
            FN.put(f2,f1);
            FNnum.put(f1,FNnum.get(f1)+FNnum.get(f2));
            return FNnum.get(f1);
        }
    }
}



























