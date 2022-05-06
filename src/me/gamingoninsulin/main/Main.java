package me.gamingoninsulin.main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame(); // creates a new frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // makes it you can close it with the  x button on the window
        window.setResizable(false);  // makes it not resizeable
        window.setTitle("RPG2D | Action RPG"); // sets tile of the game

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null); // position at center of screen
        window.setVisible(true);  // make the window visable

        gamePanel.startingGamThread(); // calls run method of the gamePanel Thread
    }
}
