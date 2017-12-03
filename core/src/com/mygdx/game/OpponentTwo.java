package com.mygdx.game;

public class OpponentTwo extends Racer {

    public OpponentTwo (String image, float x, float y, float sizeX, float sizeY){
        super(image, x, y, sizeX, sizeY);

        getSprite().setOriginCenter();
    }

    //Metod som som flyttar motståndaren på level två
    public void followTrackLevelTwo() {
        if (getX() >= 602 && getX() <= 606 && getY() >= 115 && getY() < 125) {
            setSpeedX(3.1f);
            setSpeedY(0);
        }
        else if ((getX() >= 1244 && getX() <= 1253) && (getY() >= 115 && getY() < 133)) {
            setSpeedX(0);
            setSpeedY(3.1f);
        }
        else if (getX() >= 1244 && getX() <= 1253 && (getY() >= 484 && getY() < 493)) {
            setSpeedX(-3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 806 && getX() < 814 && getY() >= 484 && getY() < 493) {
            setSpeedY(-3.1f);
            setSpeedX(0);
        }
        else if (getX() >= 806 && getX() < 814 && getY() >= 277 && getY() < 287) {
            setSpeedX(-3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 467 && getX() < 477 && getY() >= 277 && getY() < 287) {
            setSpeedX(0);
            setSpeedY(3.1f);
        }
        else if (getX() >= 467 && getX() < 477 && getY() >= 452 && getY() < 462) {
            setSpeedX(-3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 130 && getX() < 140 && getY() >= 452 && getY() < 462) {
            setSpeedX(0);
            setSpeedY(-3.1f);
        }
        else if (getX() >= 130 && getX() < 140 && getY() >= 115 && getY() < 133) {
            setSpeedX(3.1f);
            setSpeedY(0);
        }
    }

    //Metod som förändrar en Sprites rotation/riktning på level två.
    public void changeDirectionLevelTwo(){
        if (getX() >= 602 && getX() <= 606 && getY() >= 115 && getY() < 125) {
            getSprite().setRotation(0);
        }
        else if ((getX() >= 1244 && getX() <= 1253) && (getY() >= 115 && getY() < 133)) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 1244 && getX() <= 1253 && (getY() >= 484 && getY() < 493)) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 806 && getX() < 814 && getY() >= 484 && getY() < 493) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 806 && getX() < 814 && getY() >= 277 && getY() < 287) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 467 && getX() < 477 && getY() >= 277 && getY() < 287) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 467 && getX() < 477 && getY() >= 452 && getY() < 462) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 130 && getX() < 140 && getY() >= 452 && getY() < 462) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 130 && getX() < 140 && getY() >= 115 && getY() < 133) {
            getSprite().setRotation(360);
        }
    }

    //Metod som ändrar motståndarens hastighet baserat på dess position.
    public void followTrackLevelThree(){
        if (getX() >= 602 && getX() <= 606 && getY() >= 115 && getY() < 125) {
            setSpeedX(3.1f);
            setSpeedY(0);
        }
        else if ((getX() >= 1255 && getX() <= 1265) && (getY() >= 115 && getY() < 125)) {
            setSpeedX(0);
            setSpeedY(3.1f);
        }
        else if (getX() >= 1255 && getX() <= 1265 && (getY() >= 512 && getY() < 522)) {
            setSpeedX(-3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 512 && getY() < 522) {
            setSpeedY(-3.1f);
            setSpeedX(0);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 375 && getY() < 385) {
            setSpeedX(3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 375 && getY() < 385) {
            setSpeedX(0);
            setSpeedY(3.1f);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 407 && getY() < 417) {
            setSpeedX(3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 407 && getY() < 417) {
            setSpeedX(0);
            setSpeedY(-3.1f);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 259 && getY() < 269) {
            setSpeedX(-3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 259 && getY() < 269) {
            setSpeedX(0);
            setSpeedY(3.1f);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 282 && getY() < 292) {
            setSpeedX(-3.1f);
            setSpeedY(0);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 282 && getY() < 292) {
            setSpeedX(0);
            setSpeedY(-3.1f);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 115 && getY() < 125) {
            setSpeedX(3.1f);
            setSpeedY(0);
        }
    }

    //Metod för att ändra riktningen på motståndarens sprite
    public void changeDirectionLevelThree(){
        if (getX() >= 602 && getX() <= 606 && getY() >= 115 && getY() < 125) {
            getSprite().setRotation(0);
        }
        else if ((getX() >= 1255 && getX() <= 1265) && (getY() >= 115 && getY() < 125)) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 1255 && getX() <= 1265 && (getY() >= 512 && getY() < 522)) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 512 && getY() < 522) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 385 && getY() < 395) {
            getSprite().setRotation(360);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 385 && getY() < 395) {
            getSprite().setRotation(450);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 407 && getY() < 417) {
            getSprite().setRotation(360);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 407 && getY() < 417) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 259 && getY() < 269) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 259 && getY() < 269) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 282 && getY() < 292) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 282 && getY() < 292) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 70 && getX() < 80 && getY() >= 115 && getY() < 125) {
            getSprite().setRotation(360);
        }
    }
}
