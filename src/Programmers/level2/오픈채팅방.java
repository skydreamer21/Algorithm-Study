// 입장, 퇴장하는 id를 순서대로 담는 ArrayList
// user id 와 닉네임을 매칭하는 HashMap
/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {

    static HashMap<String, String> userID = new HashMap<>();
    static ArrayList<VisitLog> logs = new ArrayList<>();

    static final boolean ENTER = true;
    static final boolean LEAVE = false;

    public String[] solution(String[] record) {
        StringTokenizer st;
        boolean isEntrance;
        String option, id, nickName;
        for (String log : record) {
            st = new StringTokenizer(log);
            option = st.nextToken();
            id = st.nextToken();
            switch(option.charAt(0)) {
                case 'E' :
                    nickName = st.nextToken();
                    if (!userID.containsKey(id)) userID.put(id, nickName);
                    else if (!userID.get(id).equals(nickName)) {
                        userID.replace(id, nickName);
                    }
                    logs.add(new VisitLog(id, ENTER));
                    break;
                case 'L' :
                    logs.add(new VisitLog(id, LEAVE));
                    break;
                case 'C' :
                    nickName = st.nextToken();
                    userID.replace(id, nickName);
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] answer = new String[logs.size()];
        int idx=0;
        for (VisitLog log : logs) {
            if (log.isEntrance) {
                sb.append(userID.get(log.id)).append("님이 들어왔습니다.");
            }
            else {
                sb.append(userID.get(log.id)).append("님이 나갔습니다.");
            }
            answer[idx++] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }
}

class VisitLog {
    String id;
    boolean isEntrance;

    public VisitLog (String id, boolean isEntrance) {
        this.id = id;
        this.isEntrance = isEntrance;
    }
}

 */












