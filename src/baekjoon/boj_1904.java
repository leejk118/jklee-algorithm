/**
 * @package : baekjoon
 * @name    : boj_1904_01타일
 * @date    : 2022-04-01
 * @author  : 이정규
 * @version : 1.0.0
 */
package baekjoon;

import java.util.Scanner;

public class boj_1904 {
    private static final int MODULAR = 15746;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 2];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = (dp[i] >= MODULAR) ? dp[i] % MODULAR : dp[i];
        }

        System.out.println(dp[N]);
    }
}
