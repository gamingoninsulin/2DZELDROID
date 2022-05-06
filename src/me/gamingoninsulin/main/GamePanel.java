package me.gamingoninsulin.main;

import me.gamingoninsulin.entity.Player;
import me.gamingoninsulin.tiles.TileManager;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen settings
    final int originalTileSize = 16; // 16x16 size
    final int scale = 4; // scaling 16x3 = 84

    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;   // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow;  // 576 pixels

    // world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxScreenCol;
    public final int worldHeight = tileSize * maxScreenRow;


    // FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyH);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // better render performance

        this.addKeyListener(keyH);
        this.setFocusable(true);


    }

    public void startingGamThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {

        // game loop variables
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            // game loop stuff like fps
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer +=(currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                // Update loop
                update();
                // Draw screen loop
                repaint();
                //decrease delta timer -1
                delta--;
                drawCount++;
            }
            // shows FPC Counter in Console
//            if(timer >= 1000000000) {
//                System.out.println("FPS: "+ drawCount);
//                drawCount = 0;
//                timer = 0;
//            }
        }
    }
    public void update() {
        player.update();
    }
    public void paintComponent(Graphics g) { // draws tings on screen
        super.paintComponent(g); // always needed

        Graphics2D g2 = (Graphics2D) g;
            tileM.draw(g2); // draw this first then player
            player.draw(g2);
        g2.dispose();
    }
}
