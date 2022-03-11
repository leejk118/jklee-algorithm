/**
 * 프로그래머스_42862_체육복_(lv 1)
 * 2022-03-12
 */

package programmers;

import java.util.Arrays;

public class programmers_level1_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] isAttend = new boolean[n + 1];
        boolean[] canReserve = new boolean[n + 1];
        Arrays.sort(reserve);

        for (int i = 0; i <= n; ++i) {
            isAttend[i] = true;
            canReserve[i] = true;
        }
        for (int i = 0; i < lost.length; ++i) {
            isAttend[lost[i]] = false;
            canReserve[lost[i]] = false;
        }
        for (int i = 0; i < reserve.length; ++i) {
            if (!isAttend[reserve[i]]) {
                isAttend[reserve[i]] = true;
            }
        }
        for (int i = 0; i < reserve.length; ++i) {
            if (!canReserve[reserve[i]]) continue;
            if (1 <= reserve[i] - 1 && !isAttend[reserve[i] - 1]) {
                isAttend[reserve[i] - 1] = true;
                continue;
            }
            if (reserve[i] + 1 <= n && !isAttend[reserve[i] + 1]) {
                isAttend[reserve[i] + 1] = true;
                continue;
            }
        }
        for (int i = 1; i <= n; ++i) {
            if (isAttend[i]) {
                answer++;
            }
        }
        return answer;
    }


    public void printAnswer() {
        int[] n = {5, 5, 3, 7, 10, 7};
        int[][] list = {{2, 4}, {2, 4}, {3}, {2, 3, 4, 5}, {1, 2, 3, 4, 5}, {2,3,4}};
        int[][] reserve = {{1, 3, 5}, {3}, {1}, {2, 4, 6, 7}, {1, 2, 3, 4, 5}, {1,2,3,6}};

        int tc = n.length;
        for (int i = 0; i < tc; ++i) {
            System.out.println(this.solution(n[i], list[i], reserve[i]));
        }
    }
}
