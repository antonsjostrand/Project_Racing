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

    public void powerupDrawLevelTwo(Figure powerup, Rectangle partOne, Rectangle partTwo, Rectangle partThree, Rectangle partFour, Rectangle partFive,
                                    Rectangle partSix, Rectangle partSeven, Rectangle partEight, SpriteBatch batch) {
        if (powerup.figurePlacementPowerup(partOne) || powerup.figurePlacementPowerup(partTwo)
                || powerup.figurePlacementPowerup(partThree) || powerup.figurePlacementPowerup(partFour)|| powerup.figurePlacementPowerup(partFive)
                || powerup.figurePlacementPowerup(partSix) || powerup.figurePlacementPowerup(partSeven)|| powerup.figurePlacementPowerup(partEight)) {

                powerup.draw(batch);
        }
        else {
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
            if (powerupX <= 810){
                powerupX = powerupX + 100;
                powerup.setX(powerupX);
            }
            if (powerupY >= 290){
                powerupY = powerupY - 50;
                powerup.setY(powerupY);
            }
            if (powerupX >= 560){
                powerupX = powerupX + 100;
                powerup.setX(powerupX);
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
            if (powerupX <= 420){
                powerupX = powerupX + 50;
                powerup.setX(powerupX);
            }
            if (powerupX >= 900){
                powerupX = powerupX - 50;
                powerup.setX(powerupX);
            }
            if (powerupY <= 235){
                powerupY = powerupY + 50;
                powerup.setY(powerupY);
            }
            powerup.setX(powerupX);
            powerup.setY(powerupY);
        }
    }

    public void powerupDrawLevelThree(Figure powerup, Rectangle partOne, Rectangle partTwo, Rectangle partThree, Rectangle partFive,
                                      Rectangle partSix, Rectangle partSeven, Rectangle partEight, Rectangle partNine, Rectangle partTen,
                                      Rectangle partEleven, SpriteBatch batch) {
        if (powerup.figurePlacementPowerup(partOne) || powerup.figurePlacementPowerup(partTwo)
                || powerup.figurePlacementPowerup(partThree) ||  powerup.figurePlacementPowerup(partFive) || powerup.figurePlacementPowerup(partSix)
                || powerup.figurePlacementPowerup(partSeven)|| powerup.figurePlacementPowerup(partEight) || powerup.figurePlacementPowerup(partNine)
                || powerup.figurePlacementPowerup(partTen) || powerup.figurePlacementPowerup(partEleven)) {

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
            if (powerupX >= 970){
                powerupX = powerupX - 100;
                powerup.setX(powerupX);
            }
            if (powerupY <= 330){
                powerupY = powerupY + 50;
                powerup.setY(powerupY);
            }
            if (powerupY <= 360){
                powerupY = powerupY + 25;
                powerup.setY(powerupY);
            }
            if  (powerupX <= 1135){
                powerupX = powerupX + 50;
                powerup.setX(powerupX);
            }
            if (powerupY >= 270){
                powerupY = powerupY - 50;
                powerup.setY(powerupY);
            }
            if (powerupY >= 300){
                powerupY = powerupY - 25;
                powerup.setY(powerupY);
            }
            if(powerupY >= 160){
                powerupY = powerupY - 50;
                powerup.setY(powerupY);
            }
            if (powerupX <= 1295){
                powerupX = powerupX + 50;
                powerup.setX(powerupX);
            }
            if (powerupY <= 470){
                powerupY = powerupY + 50;
                powerup.setY(powerupY);
            }
            if (powerupY >= 425){
                powerupY = powerupY - 50;
                powerup.setY(powerupY);
            }
            if (powerupX >= 880){
                powerupX = powerupX + 50;
                powerup.setX(powerupX);
            }
            if (powerupY >= 450){
                powerupY = powerupY - 50;
                powerup.setY(powerupY);
            }
            if (powerupX >= 1175){
                powerupX = powerupX - 50;
                powerup.setX(powerupX);
            }
            if (powerupY <= 230){
                powerupY = powerupY + 50;
                powerup.setY(powerupY);
            }
            if (powerupY <= 250){
                powerupY = powerupY + 50;
                powerup.setY(powerupY);
            }

            powerup.setX(powerupX);
            powerup.setY(powerupY);
        }
    }
}
