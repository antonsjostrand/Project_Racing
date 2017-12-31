package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.security.SecureRandom;

public class Powerup extends Figure {

    private SecureRandom rand = new SecureRandom();
    private int powerupX, powerupY;

    public Powerup(String image, float x, float y, float size){
        super(image, x, y, size);
        getSprite().setOriginCenter();
    }

    public void powerupDrawLevelOne(Figure powerup, Rectangle partOne, Rectangle partTwo, Rectangle partThree, Rectangle partFour, SpriteBatch batch) {
        if (powerup.figurePlacementPowerup(partOne) || powerup.figurePlacementPowerup(partTwo)
                || powerup.figurePlacementPowerup(partThree) || powerup.figurePlacementPowerup(partFour)) {
            powerup.draw(batch);
        } else {
            powerupX = rand.nextInt(1251);
            powerupY = rand.nextInt(503);

            if (powerupX <= 70) {
                powerupX = powerupX + 100;
                powerup.setX(powerupX);
            }
            if (powerupY <= 70) {
                powerupY = powerupY + 100;
                powerup.setY(powerupY);
            }
            if(powerupX >= 1295){
                powerupX = powerupX - 100;
                powerup.setX(powerupX);
            }
            if (powerupY >= 550){
                powerupY = powerupY - 100;
                powerup.setY(powerupY);
            }
            if  (powerupY >= 160){
                powerupY = powerupY - 50;
                powerup.setY(powerupY);
            }
            if (powerupY <= 460){
                powerupY = powerupY + 50;
                powerup.setY(powerupY);
            }
            if (powerupX >= 160){
                powerupX = powerupX - 50;
                powerup.setX(powerupX);
            }
            if(powerupX <= 1205){
                powerupX = powerupX + 50;
                powerup.setX(powerupX);
            }
            powerup.setX(powerupX);
            powerup.setY(powerupY);
        }
    }
}
