package com.mudassirshahzad.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandMinimumStepsV2 {

    // Problem statement - src/main/resources/TreasureIslandMinimumStepsV2.md

    private int getMinimumSteps(char[][] map) {

        if (map == null || map.length == 0) return 0;

        int rows = map.length, cols = map[0].length, steps = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (map[i][j] == 'S') {
                    steps = Math.min(steps, bfs(map, i, j));
                }
            }
        }

        return steps;
    }

    private int bfs(char[][] map, int row, int col) {

        if (map == null || map.length == 0) return 0;

        int steps = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(row, col));

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Coordinate coordinate = queue.poll();
                int x = coordinate.x;
                int y = coordinate.y;

                if (map[x][y] == 'X') return steps;

                Arrays.stream(directions).forEach(direction -> {

                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX >= 0 && newY >= 0 &&
                        newX < map.length && newY < map[0].length &&
                        !visited[newX][newY] && map[newX][newY] != 'D') {

                        visited[newX][newY] = true;
                        queue.add(new Coordinate(newX, newY));
                    }

                });

            }
            steps++;
        }

        return 0;
    }

    public static void main(String[] args) {
        TreasureIslandMinimumStepsV2 main = new TreasureIslandMinimumStepsV2();

        char[][] grid1 = main.getSampleIsland1();
        char[][] grid2 = main.getSampleIsland2();

        int tc1 = main.getMinimumSteps(grid1);
        int tc2 = main.getMinimumSteps(grid2);
        if (tc1 == 3 && tc2 == 2) {
            System.out.println("All Test Cases Passed!");
        }
        else {
            System.out.println("There are test failures!");
        }
    }

    char[][] getSampleIsland1() {

        System.out.println("Case 1. Expected Output = 3");

        char[][] island = new char[][] {
            { 'S', 'O', 'O', 'S', 'S' },
            { 'D', 'O', 'D', 'O', 'D' },
            { 'O', 'O', 'O', 'O', 'X' },
            { 'X', 'D', 'D', 'O', 'O' },
            { 'X', 'D', 'D', 'D', 'O' } };

        return island;
    }

    char[][] getSampleIsland2() {

        System.out.println("Case 2. Expected Output = 2");

        char[][] island = new char[][] {
            { 'S', 'O', 'O', 'S', 'S' },
            { 'D', 'O', 'D', 'O', 'O' },
            { 'O', 'O', 'O', 'O', 'X' },
            { 'X', 'D', 'D', 'O', 'O' },
            { 'X', 'D', 'D', 'D', 'O' } };

        return island;
    }

    static class Coordinate {

        int x;
        int y;

        public Coordinate(int x, int y) {

            this.x = x;
            this.y = y;
        }
    }

}
