package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {

        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);

        getPlayerImage();
        setDefaultValues();

    }


    private void setDefaultValues() {

        worldX = gamePanel.tileSize * 20;
        worldY = gamePanel.tileSize * 10;
        speed = 5;
        dirNum = 0;
        directionArr = new BufferedImage[]{down, up, right, left};

    }

    public void getPlayerImage() {

        try {
            up = ImageIO.read(getClass().getResourceAsStream("/Entities/Player/Main_Character_Back.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/Entities/Player/Main_Character_Front.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/Entities/Player/Main_Character_Right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/Entities/Player/Main_Character_Left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {


        if (keyHandler.downPressed == true) {
            dirNum = 0; // DOWN
            worldY += speed;
        }
        else if (keyHandler.upPressed == true) {
            dirNum = 1; // UP
            worldY -= speed;
        }

        if (keyHandler.rightPressed == true) {
            dirNum = 2; // Right
            worldX += speed;
        }
        else if (keyHandler.leftPressed == true) {
            dirNum = 3; // LEFT
            worldX -= speed;
        }

    }

    public void draw(Graphics g2) {

        BufferedImage image = null;
        image = directionArr[dirNum];

        g2.drawImage(image, screenX, screenY, (int)(gamePanel.tileSize * 1.8), (int)(gamePanel.tileSize * 1.8), null);

    }

}
