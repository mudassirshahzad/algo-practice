package com.mudassirshahzad.algos;

class NumberOfIslands {

    // Problem statement - src/main/resources/NumberOfIslands.md

    public static void main(String... strings) {

        NumberOfIslands obj = new NumberOfIslands();

        if (obj.numIslands(obj.getSampleIsland1()) == 1
            && obj.numIslands(obj.getSampleIsland2()) == 3) {

            System.out.println("All tests passed");
        }
        else {

            System.out.println("Tests failures");
        }

    }

    int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } }; /* top, right, bottom, left */

    public void dfs(int row, int col, final char[][] grid) {

        grid[row][col] = '0'; /* so that we dont look at the parent again */
        for (int[] dir : directions) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0')
                continue;
            dfs(x, y, grid);
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islands++;
                    dfs(row, col, grid);
                }
            }
        }
        return islands;
    }

    char[][] getSampleIsland1() {

        System.out.println("Case 1. Expected Output = 1");

        char[][] island = new char[][] {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
        };

        return island;
    }

    char[][] getSampleIsland2() {

        System.out.println("Case 2. Expected Output = 3");

        char[][] island = new char[][] {
            { '1', '1', '0', '0', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' },
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