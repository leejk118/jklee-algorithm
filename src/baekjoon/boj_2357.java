/**
 * @package : baekjoon
 * @name    : boj_2357_최솟값과 최댓값
 * @date    : 2022-04-04
 * @author  : 이정규
 * @version : 1.0.0
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a, b;

        int[] numbers = new int[N + 1];
        int[] maxTree = new int[N * 4];
        int[] minTree = new int[N * 4];
        for (int i = 1; i <= N; ++i) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        initSegmentTree(maxTree, numbers, 1, 1, N, "max");
        initSegmentTree(minTree, numbers, 1, 1, N, "min");

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(sum(minTree, a, b, 1, N, 1, Integer.MAX_VALUE, "min") + " "
                    + sum(maxTree, a, b, 1, N, 1, 0, "max") + "\n");
        }

        System.out.println(sb);
    }

    private static int initSegmentTree(int[] tree, int[] numbers, int index, int start, int end, String type) {
        if (start == end) {
            return tree[index] = numbers[start];
        }

        int mid = (start + end) / 2;
        int leftValue = initSegmentTree(tree, numbers, index * 2, start, mid, type);
        int rightValue = initSegmentTree(tree, numbers, index * 2 + 1, mid + 1, end, type);

        return tree[index] = (type.equals("max")) ? Math.max(leftValue, rightValue) : Math.min(leftValue, rightValue);
    }

    private static int sum(int[] tree, int left, int right, int start, int end, int index, int value, String type) {
        if (left > end || right < start) {
            return value;
        } else if (left <= start && end <= right) {
            return type.equals("max") ? Math.max(value, tree[index]) : Math.min(value, tree[index]);
        } else {
            int mid = (start + end) / 2;
            int leftValue = sum(tree, left, right, start, mid, index * 2, value, type);
            int rightValue = sum(tree, left, right, mid + 1, end, index * 2 + 1, value, type);
            return type.equals("max") ? Math.max(leftValue, rightValue) : Math.min(leftValue, rightValue);
        }
    }
}
