package com.mygdx.game;

public class Player extends Racer{

    public Player(String image, float x, float y, float sizeX, float sizeY){
        super(image, x, y, sizeX, sizeY);
        getSprite().setOriginCenter();
    }

    public void accelerate(){
        setSpeedX(2);
        setSpeedY(0);

            if(getSprite().getRotation() >= 90 && getSprite().getRotation() < 180){
                setSpeedX(0);
                setSpeedY(2);
            }
            else if(getSprite().getRotation() >= 180 && getSprite().getRotation() < 270){
                setSpeedX(-2);
                setSpeedY(0);
            }
            else if(getSprite().getRotation() >= 270 && getSprite().getRotation() < 360){
                setSpeedX(0);
                setSpeedY(-2);
            }
            else if(getSprite().getRotation() >= 360){
                getSprite().setRotation(0);
            }
            else if(getSprite().getRotation() <= -88 && getSprite().getRotation() > -178){
                setSpeedY(-2);
                setSpeedX(0);
            }
            else if(getSprite().getRotation() <= -178 && getSprite().getRotation() > -268){
                setSpeedY(0);
                setSpeedX(-2);
            }
            else if(getSprite().getRotation() <= -268 && getSprite().getRotation() > -358){
                setSpeedY(2);
                setSpeedX(0);
            }
            else if(getSprite().getRotation() <= -358){
                getSprite().setRotation(0);
            }

    }

    public void brake(){
        setSpeedX(0);
        setSpeedY(0);
    }

    public void turnLeft(){
        getSprite().rotate(1);

        if ((getSprite().getRotation() >= 0 && getSprite().getRotation() < 90)){
            getSprite().translateY(1);
        }
        else if(getSprite().getRotation() >= 90 && getSprite().getRotation() < 180){
            getSprite().translateX(-1);
        }
        else if(getSprite().getRotation() >= 180 && getSprite().getRotation() < 270){
            getSprite().translateY(-1);
        }
        else if(getSprite().getRotation() >= 270 && getSprite().getRotation() < 360){
            getSprite().translateX(1);
        }
        else if(getSprite().getRotation() >= 360){
            getSprite().setRotation(0);
        }
    }

    public void turnRight(){
        getSprite().rotate(-1);

        if(getSprite().getRotation() <= -1 && getSprite().getRotation() > -88){
            getSprite().translateY(-1);
        }
        else if (getSprite().getRotation() <= -88 && getSprite().getRotation() > -158){
            getSprite().translateX(-1);
        }
        else if (getSprite().getRotation() <= -158 && getSprite().getRotation() > -268){
            getSprite().translateY(1);
        }
        else if (getSprite().getRotation() <= -268 && getSprite().getRotation() > -358){
            getSprite().translateX(1);
        }
        else if(getSprite().getRotation() <= -358){
            getSprite().setRotation(0);

        }

    }

}
