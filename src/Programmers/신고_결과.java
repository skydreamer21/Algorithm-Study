/*
import java.util.StringTokenizer;
import java.util.HashMap;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        StringTokenizer st;

        // ids : 각 이름에 번호를 붙이는 Map
        HashMap<String, Integer> ids = new HashMap<>();

        // 주어진 id_list를 통해 안에 있는 이름들에 번호를 늘려가며 붙여 Map에 저장
        int idx=0;
        for (String name : id_list) ids.put(name,idx++);

        int N = id_list.length;

        // boolean[reporter][person] : reporter 가 person을 신고했는지 여부 조사
        boolean[][] reports = new boolean[N][N];

        // 주어진 report 배열에 있는 모든 정보를 reports 배열에 넣기
        int _reporter, personReported;
        for (String rprt : report) {
            st = new StringTokenizer(rprt);
            _reporter = ids.get(st.nextToken());
            personReported = ids.get(st.nextToken());
            if (!reports[_reporter][personReported]) reports[_reporter][personReported]=true;
        }

        // isBanned[person] : person이 정지당했는지 여부 조사
        boolean[] isBanned = new boolean[N];
        int sum;
        for (int person=0;person<N;person++) {
            sum=0;
            for (int reporter=0;reporter<N;reporter++) {
                if(reports[reporter][person]) sum++;
            }
            if (sum>=k) isBanned[person] = true;
        }

        int[] answer = new int[N];
        int mail;
        for (int reporter=0;reporter<N;reporter++) {
            mail=0;
            for (int person=0;person<N;person++) {
                if (reports[reporter][person] && isBanned[person]) mail++;
            }
            answer[reporter] = mail;
        }

        return answer;
    }
}*/
