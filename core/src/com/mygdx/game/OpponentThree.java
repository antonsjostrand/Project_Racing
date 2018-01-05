package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

import java.security.SecureRandom;
import java.util.ArrayList;

public class OpponentThree extends Racer {
    SecureRandom rand = new SecureRandom();
    ArrayList<Rectangle> boxList = new ArrayList<>();

    int x1, x2, x3, x4, y1, y2, y3, y4;

    public OpponentThree(String image, float x, float y, float sizeX, float sizeY) {
        super(image, x, y, sizeX, sizeY);

        getSprite().setOriginCenter();
    }


    public void followTrackLevelThree(){
        if (getX() >= 598 && getX() <= 610 && getY() >= 85 && getY() < 95) {
            setSpeedX(3);
            setSpeedY(0);
        }
        else if ((getX() >= 1240 && getX() <= 1320) && (getY() >= 85 && getY() < 110)) {
            setSpeedX(0);
            setSpeedY(3);
        }
        else if (getX() >= 1240 && getX() <= 1320 && (getY() >= 512 && getY() < 522)) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 512 && getY() < 522) {
            setSpeedY(-3);
            setSpeedX(0);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 420 && getY() < 430) {
            setSpeedX(3);
            setSpeedY(0);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 420 && getY() < 430) {
            setSpeedX(0);
            setSpeedY(-3);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 220 && getY() < 230) {
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 220 && getY() < 230) {
            setSpeedX(0);
            setSpeedY(-3);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 85 && getY() < 95) {
            setSpeedX(3);
            setSpeedY(0);
        }
    }

    public void changeDirectionLevelThree(){
        if (getX() >= 602 && getX() <= 606 && getY() >= 85 && getY() < 95) {
            getSprite().setRotation(0);
        }
        else if ((getX() >= 1240 && getX() <= 1320) && (getY() >= 85 && getY() < 110)) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 1240 && getX() <= 1320 && (getY() >= 512 && getY() < 522)) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 512 && getY() < 522) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 420 && getY() < 430) {
            getSprite().setRotation(360);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 420 && getY() < 430) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 220 && getY() < 230) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 220 && getY() < 230) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 85 && getY() < 95) {
            getSprite().setRotation(360);
        }
    }
}
