/**
 * 프로그래머스_42842_카펫_(lv 2)
 * 2022-03-11
 */

package programmers;

import java.util.Arrays;

public class programmers_level2_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        answer[0] = (int) (1 + brown / 4.0 + Math.sqrt(brown * brown / 16.0 - brown / 2.0 - yellow + 1));
        answer[1] = brown / 2 + 2 - answer[0];
        return answer;
    }


    public void printAnswer() {
        int[] brown = {10, 8, 24};
        int[] yellow = {2, 1, 24};
        int tc = brown.length;

        for (int i = 0; i < tc; ++i) {
            System.out.println(Arrays.toString(this.solution(brown[i], yellow[i])));
        }
    }
}
