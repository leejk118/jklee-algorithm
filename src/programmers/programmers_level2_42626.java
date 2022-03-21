/**
 * @package : programmers
 * @name : programmers_level2_42626
 * @date : 2022-03-21
 * @author : 이정규
 * @version : 1.0.0
 */
package programmers;

import java.util.PriorityQueue;

public class programmers_level2_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sco : scoville) {
            pq.add(sco);
        }
        while (true) {
            if (pq.size() > 0 && pq.peek() >= K) {
                break;
            }
            if (pq.size() <= 1) {
                answer = -1;
                break;
            }
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }
        return answer;
    }

    public void printAnswer() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(this.solution(scoville, K));
    }
}
