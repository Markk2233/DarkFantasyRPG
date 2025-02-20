package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
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

        screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
        screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;

        solidArea = new Rectangle();
        solidArea.x = 24 * gamePanel.scale;
        solidArea.y = 20 * gamePanel.scale;
        solidArea.width = 10 * gamePanel.scale;
        solidArea.height = 30 * gamePanel.scale;


        getPlayerImage();
        setDefaultValues();

    }


    private void setDefaultValues() {

        worldX = gamePanel.tileSize * 20;
        worldY = gamePanel.tileSize * 10;
        speed = 5;
        dirNum = 0;
        directionArr = new BufferedImage[]{down, up, left, right};

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

        if (keyHandler.downPressed == true ||
            keyHandler.upPressed == true ||
            keyHandler.rightPressed == true ||
            keyHandler.leftPressed == true) {


            if (keyHandler.downPressed == true) {
                dirNum = 0; // DOWN
            }
            else if (keyHandler.upPressed == true) {
                dirNum = 1; // UP
            }

            if (keyHandler.leftPressed == true) {
                dirNum = 2; // LEFT
            }
            else if (keyHandler.rightPressed == true) {
                dirNum = 3; // RIGHT
            }

            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            if (collisionOn == false) {

                switch (dirNum) {
                    case 0:
                        worldY += speed;
                        break;
                    case 1:
                        worldY -= speed;
                        break;
                    case 2:
                        worldX -= speed;
                        break;
                    case 3:
                        worldX += speed;
                        break;
                }

            }
        }

    }

    public void draw(Graphics g2) {

        BufferedImage image = null;
        image = directionArr[dirNum];

        g2.drawImage(image, screenX, screenY, (int)(gamePanel.tileSize * 1.8), (int)(gamePanel.tileSize * 1.8), null);
    }

}
