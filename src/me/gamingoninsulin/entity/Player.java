package me.gamingoninsulin.entity;

import me.gamingoninsulin.main.GamePanel;
import me.gamingoninsulin.main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;

    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            System.out.println("Loading Images START");
            PlayerUp1 = ImageIO.read(getClass().getResourceAsStream("../res/player/up1.png"));
            PlayerUp2 = ImageIO.read(getClass().getResourceAsStream("../res/player/up2.png"));
            PlayerUp3 = ImageIO.read(getClass().getResourceAsStream("../res/player/up3.png"));
            PlayerUp4 = ImageIO.read(getClass().getResourceAsStream("../res/player/up4.png"));
            System.out.println("Loading Images Up done");
            PlayerDown1 = ImageIO.read(getClass().getResourceAsStream("../res/player/down1.png"));
            PlayerDown2 = ImageIO.read(getClass().getResourceAsStream("../res/player/down2.png"));
            PlayerDown3 = ImageIO.read(getClass().getResourceAsStream("../res/player/down3.png"));
            PlayerDown4 = ImageIO.read(getClass().getResourceAsStream("../res/player/down4.png"));
            System.out.println("Loading Images Down done");
            PlayerLeft1 = ImageIO.read(getClass().getResourceAsStream("../res/player/left1.png"));
            PlayerLeft2 = ImageIO.read(getClass().getResourceAsStream("../res/player/left2.png"));
            PlayerLeft3 = ImageIO.read(getClass().getResourceAsStream("../res/player/left3.png"));
            PlayerLeft4 = ImageIO.read(getClass().getResourceAsStream("../res/player/left4.png"));
            System.out.println("Loading Images Left done");
            PlayerRight1 = ImageIO.read(getClass().getResourceAsStream("../res/player/right1.png"));
            PlayerRight2 = ImageIO.read(getClass().getResourceAsStream("../res/Player/right2.png"));
            PlayerRight3 = ImageIO.read(getClass().getResourceAsStream("../res/player/right3.png"));
            PlayerRight4 = ImageIO.read(getClass().getResourceAsStream("../res/player/right4.png"));
            System.out.println("Loading player Left, Right, Up, Down Complete");

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed == true || keyH.downPressed == true ||keyH.leftPressed == true || keyH.rightPressed) {
            if(keyH.upPressed) { // going up
                direction = "up";
                worldY -= speed;
            } else if(keyH.downPressed) { // going down
                direction = "down";
                worldY += speed;
            } else if(keyH.leftPressed) { // going left
                direction = "left";
                worldX -= speed;
            } else if(keyH.rightPressed) { // going right
                direction = "right";
                worldX += speed;
            }
            spriteCounter++;
            if(spriteCounter > 12) {
                if(spriteNumber == 1) {
                    spriteNumber = 2;
                } if (spriteNumber == 2) {
                    spriteNumber = 3;
                } if (spriteNumber == 3) {
                    spriteNumber = 4;
                } else if (spriteNumber == 4) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(spriteNumber == 1) {
                    image = PlayerUp1;
                }
                if(spriteNumber == 2) {
                    image = PlayerUp2;
                }
                if(spriteNumber == 3) {
                    image = PlayerUp3;
                }
                if(spriteNumber == 4) {
                    image = PlayerUp4;
                }
                break;
            case "down":
                if(spriteNumber == 1) {
                    image = PlayerDown1;
                }
                if(spriteNumber == 2) {
                    image = PlayerDown2;
                }
                if(spriteNumber == 3) {
                    image = PlayerDown3;
                }
                if(spriteNumber == 4) {
                    image = PlayerDown4;
                }
                break;
            case "left":
                if(spriteNumber == 1) {
                    image = PlayerLeft1;
                }
                if(spriteNumber == 2) {
                    image = PlayerLeft2;
                }
                if(spriteNumber == 3) {
                    image = PlayerLeft3;
                }
                if(spriteNumber == 4) {
                    image = PlayerLeft4;
                }
                break;
            case "right":
                if(spriteNumber == 1) {
                    image = PlayerRight1;
                }
                if(spriteNumber == 2) {
                    image = PlayerRight2;
                }
                if(spriteNumber == 3) {
                    image = PlayerRight3;
                }
                if(spriteNumber == 4) {
                    image = PlayerRight4;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }


}
