package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15988 {
    private static final int MAX_LENGTH = 1000000;
    private static final int MODULAR_VALUE = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        long[] dp = new long[MAX_LENGTH + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= MAX_LENGTH; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i -3];
            if (dp[i] >= MODULAR_VALUE) dp[i] %= MODULAR_VALUE;
        }

        for (int i = 0; i < T; ++i) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }
        System.out.println(sb);
    }
}
