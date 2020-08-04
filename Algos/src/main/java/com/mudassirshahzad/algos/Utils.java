package com.mudassirshahzad.algos;

public class Utils {

    void print2DCharArray(char[][] array) {
        for (int row = 0; row <= array.length; row++) {
            for (int col = 0; col <= array[0].length; col++) {
                if (col == 0 && row == 0) { // Top right corner
                    System.out.print("  ");
                }
                else if (row == 0) { // First row
                    System.out.print(" " + (col - 1));
                }
                else if (col == 0) { // First column
                    System.out.print(" " + (row - 1));
                }
                else { // All other cases
                    System.out.print(" " + array[row - 1][col - 1]);
                }
            }
            System.out.println();
        }
    }

}
