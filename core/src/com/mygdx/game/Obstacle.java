package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.security.SecureRandom;

public class Obstacle extends Figure {


    private SecureRandom rand = new SecureRandom();
    private float obstacleX, obstacleY;

    public Obstacle(String image, float x, float y, float size){
        super(image, x, y, size);
        getSprite().setOriginCenter();
    }

    public void obstacleDrawLevelOne(Figure obstacle, Rectangle partOne, Rectangle partTwo, Rectangle partThree, Rectangle partFour, SpriteBatch batch) {
        if (obstacle.figurePlacement(partOne) || obstacle.figurePlacement(partTwo) || obstacle.figurePlacement(partThree) || obstacle.figurePlacement(partFour)) {
            obstacle.draw(batch);
        } else {
            obstacleX = rand.nextInt(1251);
            obstacleY = rand.nextInt(503);

            if (obstacleX <= 70) {
                obstacleX = obstacleX + 100;
                obstacle.setX(obstacleX);
            }
            if (obstacleY <= 70) {
                obstacleY = obstacleY + 100;
                obstacle.setY(obstacleY);
            }
            if(obstacleX >= 1295){
                obstacleX = obstacleX - 100;
                obstacle.setX(obstacleX);
            }
            if (obstacleY >= 550){
                obstacleY = obstacleY - 100;
                obstacle.setY(obstacleY);
            }
            if  (obstacleY >= 160){
                obstacleY = obstacleY - 50;
                obstacle.setY(obstacleY);
            }
            if (obstacleY <= 460){
                obstacleY = obstacleY + 50;
                obstacle.setY(obstacleY);
            }
            if (obstacleX >= 160){
                obstacleX = obstacleX - 50;
                obstacle.setX(obstacleX);
            }
            if(obstacleX <= 1205){
                obstacleX = obstacleX + 50;
                obstacle.setX(obstacleX);
            }
            obstacle.setX(obstacleX);
            obstacle.setY(obstacleY);
        }
    }
}
