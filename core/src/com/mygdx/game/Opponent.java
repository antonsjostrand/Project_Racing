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
    public void followTrack(){
        if(getX() <= 605 && getY() <= 100){
            setSpeedX(3);
            setSpeedY(0);
        }
        else if(getX() >= 1200 && getY() == 100){
            setSpeedX(0);
            setSpeedY(3);
        }
        else if(getX() >=1200 && getY() >= 400){
            setSpeedY(0);
            setSpeedX(-3);
        }
        else if(getX() <= 50 && getY() >= 400){
            setSpeedX(0);
            setSpeedY(-3);
        }
    }
    //Metod för att ändra riktningen på motståndare bild.
    public void changeDirection(){
        if(getX() >= 1200 && getY() == 100){
            getSprite().setRotation(90);
        }
        else if(getX() >= 1200 && getY() >=400){
            getSprite().setRotation(180);
        }
        else if(getX() <= 50 && getY() >= 400){
            getSprite().setRotation(270);
        }
        else if(getX() <= 50 && getY() <= 100){
            getSprite().setRotation(360);
        }

    }
}
