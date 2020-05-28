package com.mudassirshahzad.algos;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {

    // Problem statement - src/main/resources/ZombieInMatrix.md

    private static int minHours(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return -1;
        }

        Queue<Coordinate> queue = new LinkedList<>();
        int hours = 0;
        int humanCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    humanCount++;
                }
                else {
                    queue.add(new Coordinate(i, j));
                }
            }
        }

        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        // bfs
        while (!queue.isEmpty() && humanCount > 0) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Coordinate zombie = queue.poll();
                int x = zombie.x;
                int y = zombie.y;

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    // when new coordinates don't exceed the boundaries of the grid or the new coordinate is a human, only
                    // then turn that to a zombie
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;

                        // now that new coordinate is a zombie, add that to the queue so it can be processed in the next level
                        queue.add(new Coordinate(newX, newY));

                        humanCount--;
                    }
                }
            }

            hours++;
        }
        return humanCount == 0 ? hours : -1;
    }

    public static void main(String[] args) {

        if (minHours(getGrid1()) == 2) System.out.println("All tests passed");
        else System.out.println("Tests failed");

    }

    public static int[][] getGrid1() {

        System.out.println("Expected Output = 2");

        return new int[][] {
            { 0, 1, 1, 0, 1 },
            { 0, 1, 0, 1, 0 },
            { 0, 0, 0, 0, 1 },
            { 0, 1, 0, 0, 0 } };
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
