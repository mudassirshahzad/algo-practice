package com.mudassirshahzad.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandMinimumSteps {

    // Problem statement - src/main/resources/TreasureIslandMinimumSteps.md

    public static int getMinimumSteps(char[][] island) {

        if (island == null || island.length == 0) return 0;

        int steps = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));

        int[] rightMovement = { 1, 0 }; // Add 1 in x-coordinate
        int[] leftMovement = { -1, 0 }; // Add -1 in x-coordinate
        int[] upMovement = { 0, 1 }; // Add 1 in y-coordinate
        int[] downMovement = { 0, -1 }; // Add -1 in y-coordinate
        int[][] directions = { rightMovement, leftMovement, upMovement, downMovement };

        // island.length gives you number of rows
        // island[0].length gives you number of columns
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = Boolean.TRUE;

        while (!queue.isEmpty()) {

            int size = queue.size(); // Getting the size before the loop because the queue size changes during the loop
            for (int i = 0; i < size; i++) {

                Coordinate currentCoordinate = queue.poll();
                int x = currentCoordinate.x;
                int y = currentCoordinate.y;

                if (island[x][y] == 'X') return steps;

                Arrays.stream(directions).forEach(direction -> {

                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX >= 0 && newY >= 0 && newX < island.length && newY < island[0].length &&
                        !visited[newX][newY] && island[newX][newY] != 'D') {

                        visited[newX][newY] = Boolean.TRUE;
                        queue.add(new Coordinate(newX, newY));
                    }
                });
            }

            steps++;
        }

        return 0;

    }

    public static void main(String[] args) {

        // Case 1
        char[][] island = getSampleIsland1();
        int result = getMinimumSteps(island);
        System.out.println(String.format("%s ", result));

        // Case 2
        island = getSampleIsland2();
        result = getMinimumSteps(island);
        System.out.println(String.format("%s ", result));

    }

    static char[][] getSampleIsland1() {

        System.out.println("Case 1. Expected = 5");

        char[][] island = new char[][] {
            { 'O', 'O', 'O', 'O' },
            { 'D', 'O', 'D', 'O' },
            { 'O', 'O', 'O', 'O' },
            { 'X', 'D', 'D', 'O' }
        };

        return island;
    }

    static char[][] getSampleIsland2() {

        System.out.println("Case 2. Expected = 7");

        char[][] island = new char[][] {
            { 'O', 'O', 'O', 'D' },
            { 'D', 'O', 'D', 'D' },
            { 'D', 'O', 'D', 'X' },
            { 'O', 'O', 'O', 'O' }
        };

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
