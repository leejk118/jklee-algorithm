/**
 * @package : baekjoon
 * @name : BOJ_1655
 * @date : 2022-03-18
 * @author : 이정규
 * @version : 1.0.0
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int number;

        for (int i = 0; i < N; ++i) {
            number = Integer.parseInt(br.readLine());

            if (minHeap.size() < maxHeap.size()) {
                minHeap.add(number);
            } else {
                maxHeap.add(number);
            }

            if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(maxHeap.poll());
            }
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
    }
}
