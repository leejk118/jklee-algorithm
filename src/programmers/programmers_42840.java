/**
 * 프로그래머스_42840_모의고사_(lv 1)
 * 2022-03-11
 */

package programmers;

import java.util.Arrays;

public class programmers_42840 {
    private static final int[][] answerType = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int answerTypeLength = answerType.length;
        int[] answer = new int [answerTypeLength];
        int[] answerCount = new int[answerTypeLength];
        int maxCount = 0;

        for (int i = 0, length = answers.length; i < length; i++) {
            for (int j = 0; j < answerTypeLength; j++) {
                if (answers[i] == answerType[j][i % answerType[j].length]) {
                    answerCount[j]++;
                    maxCount = Math.max(maxCount, answerCount[j]);
                }
            }
        }
        int index = 0;
        for (int i = 0, length = answerCount.length; i < length; i++) {
            if (maxCount == answerCount[i]) {
                answer[index] = i + 1;
                index++;
            }
        }
        return Arrays.copyOfRange(answer, 0, index);
    }


    public void printAnswer() {
        int[][] answers = {{1,2,3,4,5}, {1,3,2,4,2}};
        int tc = answers.length;

        for (int i = 0; i < tc; ++i) {
            System.out.println(Arrays.toString(this.solution(answers[i])));
        }
    }
}
