package com.mygdx.game;

import com.badlogic.gdx.ai.steer.Steerable;
import com.badlogic.gdx.ai.steer.SteeringAcceleration;
import com.badlogic.gdx.ai.steer.behaviors.Seek;
import com.badlogic.gdx.math.Vector;

public class Opponent extends Racer {

    public Opponent(String image, float x, float y, float sizeX, float sizeY){
        super(image, x, y, sizeX, sizeY);

        getSprite().setOriginCenter();
    }

    //Metod för att flytta motståndaren enligt dess koordinater
    public void followTrackLevelOne(){
        if(getX() <= 605 && getY() <= 100){
            setSpeedX(3);
            setSpeedY(0);
        }
        else if(getX() >= 1200 && getY() == 100){
            setSpeedX(0);
            setSpeedY(3);
        }
        else if(getX() >=1200 && getY() >= 500){
            setSpeedY(0);
            setSpeedX(-3);
        }
        else if(getX() <= 50 && getY() >= 500){
            setSpeedX(0);
            setSpeedY(-3);
        }
    }
    //Metod för att ändra riktningen på motståndare bild.
    public void changeDirectionLevelOne(){
        if(getX() >= 1200 && getY() == 100){
            getSprite().setRotation(90);
        }
        else if(getX() >= 1200 && getY() >=500){
            getSprite().setRotation(180);
        }
        else if(getX() <= 50 && getY() >= 500){
            getSprite().setRotation(270);
        }
        else if(getX() <= 50 && getY() <= 100){
            getSprite().setRotation(360);
        }
    }

    //Metod som som flyttar motståndaren på level två
    public void followTrackLevelTwo(){
        if((getX() >= 40 && getX() < 1200) && (getY() >= 90 && getY() <= 100)){
            setSpeedX(3);
            setSpeedY(0);
        }
        else if((getX() >= 1200) && (getY() >= 90 && getY() <= 100)){
            setSpeedX(0);
            setSpeedY(3);
        }
        else if((getX() >= 1200) && getY() >= 500) {
            setSpeedY(0);
            setSpeedX(-3);
        }
        else if((getX() >= 790 && getX() < 800 ) && (getY() >= 500)){
            setSpeedX(0);
            setSpeedY(-3);
        }
        else if((getX() <= 800 && getX() >= 790) && (getY() > 220 && getY() < 230)){
            setSpeedY(0);
            setSpeedX(-3);
        }
        else if((getX() > 450 && getX() < 460) && (getY() > 220 && getY() < 230)){
            setSpeedX(0);
            setSpeedY(3);
        }
        else if((getX() > 450 && getX() < 460) && (getY() >= 490 && getY() < 510)){
            setSpeedX(-3);
            setSpeedY(0);
        }
        else if((getX() > 40 && getX() < 60) && (getY() >= 490 && getY() < 510)){
            setSpeedX(0);
            setSpeedY(-3);
        }
    }

    //Metod som förändrar en Sprites rotation/riktning på level två.
    public void changeDirectionLevelTwo(){
        if((getX() >= 40 && getX() < 1200) && (getY() >= 90 && getY() <= 100)){
            getSprite().setRotation(0);
        }
        else if((getX() >= 1200) && (getY() >= 90 && getY() <= 100)){
            getSprite().setRotation(90);
        }
        else if((getX() >= 1200) && getY() >= 500) {
            getSprite().setRotation(180);
        }
        else if((getX() >= 790 && getX() < 800 ) && (getY() >= 500)){
            getSprite().setRotation(270);
        }
        else if((getX() <= 800 && getX() >= 790) && (getY() > 220 && getY() < 230)){
            getSprite().setRotation(180);
        }
        else if((getX() > 450 && getX() < 460) && (getY() > 220 && getY() < 230)){
            getSprite().setRotation(90);
        }
        else if((getX() > 450 && getX() < 460) && (getY() >= 490 && getY() < 510)){
            getSprite().setRotation(180);
        }
        else if((getX() > 40 && getX() < 60) && (getY() >= 490 && getY() < 510)){
            getSprite().setRotation(270);
        }
    }
}
