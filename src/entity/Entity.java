package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage up, down, right, left;
    public int dirNum;
    public BufferedImage[] directionArr;
    public Rectangle solidArea;
    public boolean collisionOn = false;

}
