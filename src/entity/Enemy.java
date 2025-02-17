package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy extends Entity {

    GamePanel gamePanel;

    public Enemy(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        getEnemyImage();
        setDefaultValues();
    }

    private void setDefaultValues() {

        worldX = gamePanel.tileSize * 3;
        worldY = gamePanel.tileSize * 3;
        speed = 5;

    }

    public void getEnemyImage() {

        try {
            right = ImageIO.read(getClass().getResourceAsStream("/Entities/Enemy1/Enemy_right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/Entities/Enemy1/Enemy_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics g2) {

        BufferedImage image = null;
        image = left;

        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;


        g2.drawImage(image, screenX, screenY, (int)(gamePanel.tileSize * 1.8), (int)(gamePanel.tileSize * 1.8), null);

    }



}
