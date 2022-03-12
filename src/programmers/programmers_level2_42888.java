/**
 * 프로그래머스_42888_오픈채팅방_(lv 2)
 * 2022-03-12
 */

package programmers;

import java.util.*;

public class programmers_level2_42888 {
    public String[] solution(String[] record) {
        Map<String, String> userInfo = new HashMap<>();
        List<String> messages = new ArrayList<>();

        for (int i = 0, length = record.length; i < length; ++i) {
            String[] records = record[i].split(" ");

            switch (records[0].toLowerCase()) {
                case "enter":
                    userInfo.put(records[1], records[2]);
                    messages.add(records[1] + "@님이 들어왔습니다.");
                    break;
                case "leave":
                    messages.add(records[1] + "@님이 나갔습니다.");
                    break;
                case "change":
                    userInfo.put(records[1], records[2]);
                    break;
                default: break;
            }
        }

        String[] answer = new String [messages.size()];
        for (int i = 0, length = messages.size(); i < length; ++i) {
            String[] messageInfo = messages.get(i).split("@");
            answer[i] = userInfo.get(messageInfo[0]) + messageInfo[1];
        }

        return answer;
    }


    public void printAnswer() {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        System.out.println(Arrays.toString(this.solution(record)));
    }
}
