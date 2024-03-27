package main;

import java.awt.Graphics2D;
import java.awt.Color;

public class Board {
    final int MAX_COL = 8;
    final int MAX_ROW = 8;
    public static final int SQUARE_SIZE = 100;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE / 2;

    // Method to draw the checkerboard
    public void draw(Graphics2D g2) {
        // Variable to keep track of alternating colors
        int color = 0;

        // Loop through rows
        for (int row = 0; row < MAX_ROW; row++) {
            // Loop through columns
            for (int col = 0; col < MAX_COL; col++) {
                // Set color based on alternating pattern
                if (color == 0) {
                    g2.setColor(new Color(206, 206, 206)); // Light color
                    color = 1; // Toggle color
                } else {
                    g2.setColor(new Color(30, 47, 54)); // Dark color
                    color = 0; // Toggle color
                }

                // Draw the square
                g2.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
            // After each row, flip the color to maintain the checkerboard pattern
            color = (color + 1) % 2;
        }
    }
}