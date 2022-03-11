/**
 * 프로그래머스_42586_기능개발_(lv 1)
 * 2022-03-09
 */

package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_42586 {
    private static final int[][] progresses = {{93, 30, 50}, {95, 90, 99, 99, 80, 99}, {7, 7, 7, 7}};
    private static final int[][] speeds = {{1, 30, 5}, {1, 1, 1, 1, 1, 1}, {50, 50, 50, 50}};

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int[] workHour = setWorkHour(progresses, speeds);

        Queue<Integer> q = new LinkedList<>();
        int currentWorkCount = 0;
        int currentWork = workHour[0];

        for (int i = 0; i < workHour.length; ++i) {
            if (q.isEmpty()) {
                q.add(workHour[i]);
                continue;
            }

            if (currentWork > workHour[i]) {
                q.add(workHour[i]);
                continue;
            }
            while(!q.isEmpty() && currentWork < workHour[i]) {
                q.poll();
                currentWorkCount++;
            }
            q.add(workHour[i]);
            currentWork = workHour[i];
            if (currentWorkCount > 0) {
                answerList.add(currentWorkCount);
            }
            currentWorkCount = 0;
        }

        while (!q.isEmpty()) {
            q.poll();
            currentWorkCount++;
        }

        if (currentWorkCount > 0) {
            answerList.add(currentWorkCount);
        }

        int[] answer = new int [answerList.size()];

        for (int i = 0; i < answerList.size(); ++i) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private int[] setWorkHour(int[] progresses, int[] speeds) {
        int[] workHour = new int [progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            workHour[i] = (int) Math.ceil((100 - progresses[i]) / (float) speeds[i]);
        }
        return workHour;
    }

    public void printAnswer() {
        int tc = progresses.length;

        for (int i = 0; i < tc; ++i) {
            System.out.println(Arrays.toString(solution(progresses[i], speeds[i])));
        }
    }
}
