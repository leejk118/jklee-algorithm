/**
 * @package : baekjoon
 * @name    : boj_2636_치즈
 * @date    : 2022-04-06 오후 7:21 ~ 오후 8:46
 * @author  : 이정규
 * @version : 1.0.0
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int r, c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class boj_2636 {
    private static int R, C;
    private static int[][] matrix;
    private static boolean[][] isVisited;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int CHEESE = -1;
    private static final int NONE = 0;
    private static ArrayList<Node> startNodes = new ArrayList<>();
    private static int meltedDay = 1;

    public static void main(String[] args) throws IOException {
        input();
        init();
        simulation();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        matrix = new int [R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; ++j) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                matrix[i][j] = (matrix[i][j] == 1) ? CHEESE : NONE;
            }
        }
    }
    private static void init() {
        startNodes = getEdgeNodes();
    }
    private static ArrayList<Node> getEdgeNodes() {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < R; ++i) {
            nodes.add(new Node(i, 0));
            nodes.add(new Node(i, C - 1));
        }
        for (int i = 0; i < C; ++i) {
            nodes.add(new Node(0, i));
            nodes.add(new Node(R - 1, i));
        }
        return nodes;
    }
    private static void simulation() {
        while (!startNodes.isEmpty()) {
            ArrayList<Node> targetNodes = new ArrayList<>();
            targetNodes.addAll(startNodes);
            startNodes = new ArrayList<>();
            for (Node targetNode : targetNodes) {
                if (meltedDay == 1 && isVisited[targetNode.r][targetNode.c]) continue;
                setMeltCheese(targetNode);
            }
            meltedDay++;
        }
    }
    private static void setMeltCheese(Node startNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(startNode);
        isVisited[startNode.r][startNode.c] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; ++i) {
                int nr = node.r + dir[i][0];
                int nc = node.c + dir[i][1];

                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (isVisited[nr][nc]) continue;
                    if (matrix[nr][nc] == NONE) {
                        q.add(new Node(nr, nc));
                        isVisited[nr][nc] = true;
                    }
                    else if (matrix[nr][nc] == CHEESE) {
                        matrix[nr][nc] = meltedDay;
                        startNodes.add(new Node(nr, nc));
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }
    }
    private static void output() {
        System.out.println(meltedDay - 2);
        int previousCheese = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j){
                if (matrix[i][j] == meltedDay - 2) previousCheese++;
            }
        }
        System.out.println(previousCheese);
    }
}
