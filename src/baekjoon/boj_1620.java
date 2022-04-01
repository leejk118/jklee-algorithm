package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> pokemon = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; ++i) {
            String input = br.readLine();
            pokemon.put("" + i, input);
            pokemon.put(input, "" + i);
        }

        for (int i = 1; i <= M; ++i) {
            String input = br.readLine();
            sb.append(pokemon.get(input) + "\n");
        }

        System.out.println(sb);
    }
}
