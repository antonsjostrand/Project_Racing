package com.mygdx.game;

public class OpponentTwo extends Racer {

    public OpponentTwo (String image, float x, float y, float sizeX, float sizeY){
        super(image, x, y, sizeX, sizeY);

        getSprite().setOriginCenter();
    }

    //Metod som som flyttar motståndaren på level två
    public void followTrackLevelTwo() {
        if (getX() >= 602 && getX() <= 606 && getY() >= 115 && getY() < 125) {
            setSpeedX(2.8f);
            setSpeedY(0);
        }
        else if ((getX() >= 1244 && getX() <= 1253) && (getY() >= 115 && getY() < 133)) {
            setSpeedX(0);
            setSpeedY(2.8f);
        }
        else if (getX() >= 1244 && getX() <= 1253 && (getY() >= 484 && getY() < 493)) {
            setSpeedX(-2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 806 && getX() < 814 && getY() >= 484 && getY() < 493) {
            setSpeedY(-2.8f);
            setSpeedX(0);
        }
        else if (getX() >= 806 && getX() < 814 && getY() >= 277 && getY() < 287) {
            setSpeedX(-2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 467 && getX() < 477 && getY() >= 277 && getY() < 287) {
            setSpeedX(0);
            setSpeedY(2.8f);
        }
        else if (getX() >= 467 && getX() < 477 && getY() >= 452 && getY() < 462) {
            setSpeedX(-2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 130 && getX() < 140 && getY() >= 452 && getY() < 462) {
            setSpeedX(0);
            setSpeedY(-2.8f);
        }
        else if (getX() >= 130 && getX() < 140 && getY() >= 115 && getY() < 133) {
            setSpeedX(2.8f);
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
        if (getX() >= 598 && getX() <= 610 && getY() >= 115 && getY() < 125) {
            setSpeedX(2.8f);
            setSpeedY(0);
        }
        else if ((getX() >= 1255 && getX() <= 1265) && (getY() >= 115 && getY() < 125)) {
            setSpeedX(0);
            setSpeedY(2.8f);
        }
        else if (getX() >= 1255 && getX() <= 1265 && (getY() >= 512 && getY() < 522)) {
            setSpeedX(-2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 55 && getX() < 60 && getY() >= 512 && getY() < 522) {
            setSpeedY(-2.8f);
            setSpeedX(0);
        }
        else if (getX() >= 55 && getX() < 60 && getY() >= 375 && getY() < 385) {
            setSpeedX(2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 375 && getY() < 385) {
            setSpeedX(0);
            setSpeedY(2.8f);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 445 && getY() < 450) {
            setSpeedX(2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 445 && getY() < 450) {
            setSpeedX(0);
            setSpeedY(-2.8f);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 235 && getY() < 240) {
            setSpeedX(-2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 235 && getY() < 240) {
            setSpeedX(0);
            setSpeedY(2.8f);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 282 && getY() < 292) {
            setSpeedX(-2.8f);
            setSpeedY(0);
        }
        else if (getX() >= 55 && getX() < 60 && getY() >= 282 && getY() < 292) {
            setSpeedX(0);
            setSpeedY(-2.8f);
        }
        else if (getX() >= 55 && getX() < 60 && getY() >= 115 && getY() < 125) {
            setSpeedX(2.8f);
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
        else if (getX() >= 55 && getX() < 60 && getY() >= 512 && getY() < 522) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 55 && getX() < 60 && getY() >= 385 && getY() < 395) {
            getSprite().setRotation(360);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 385 && getY() < 395) {
            getSprite().setRotation(450);
        }
        else if (getX() >= 962 && getX() < 972 && getY() >= 445 && getY() < 450) {
            getSprite().setRotation(360);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 445 && getY() < 450) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 1143 && getX() < 1153 && getY() >= 235 && getY() < 240) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 235 && getY() < 240) {
            getSprite().setRotation(90);
        }
        else if (getX() >= 957 && getX() < 967 && getY() >= 282 && getY() < 292) {
            getSprite().setRotation(180);
        }
        else if (getX() >= 55 && getX() < 60 && getY() >= 282 && getY() < 292) {
            getSprite().setRotation(270);
        }
        else if (getX() >= 55 && getX() < 60 && getY() >= 115 && getY() < 125) {
            getSprite().setRotation(360);
        }
    }
}
