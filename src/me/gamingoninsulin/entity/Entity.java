package me.gamingoninsulin.entity;

import java.awt.image.BufferedImage;

public class Entity { // super class

    public int worldX, worldY;
    public int speed;

    public BufferedImage PlayerUp1, PlayerUp2, PlayerUp3, PlayerUp4, PlayerDown1, PlayerDown2, PlayerDown3, PlayerDown4,
                         PlayerLeft1, PlayerLeft2, PlayerLeft3, PlayerLeft4, PlayerRight1, PlayerRight2, PlayerRight3, PlayerRight4;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;


}
