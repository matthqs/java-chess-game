package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a new JFrame window
        JFrame window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        window.setResizable(false); // Prevent window resizing

        // Create a new GamePanel instance
        GamePanel gp = new GamePanel();

        // Add the GamePanel to the JFrame window
        window.add(gp);
        window.pack(); // Pack the components in the window

        // Center the window on the screen
        window.setLocationRelativeTo(null);

        // Make the window visible
        window.setVisible(true);

        // Start the game by launching the game thread in the GamePanel
        gp.launchGame();
    }
}