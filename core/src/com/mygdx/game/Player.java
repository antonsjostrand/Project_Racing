package com.mygdx.game;

public class Player extends Racer{

    public Player(String image, float x, float y, float sizeX, float sizeY){
        super(image, x, y, sizeX, sizeY);
        getSprite().setOriginCenter();
    }

    //Metod för att föra spelaren framåt, uppåt och bakåt beroende på dess rotation.
    public void accelerate(){
            if(getSprite().getRotation() >= 0 && getSprite().getRotation() < 25){
                setSpeedX(3);
                setSpeedY(0);
            }
            else if(getSprite().getRotation() >= 25 && getSprite().getRotation() < 65){
                setSpeedX(3);
                setSpeedY(3);
            }
            else if(getSprite().getRotation() >= 65 && getSprite().getRotation() < 115){
                setSpeedX(0);
                setSpeedY(3);
            }
            else if(getSprite().getRotation() >= 115 && getSprite().getRotation() < 155){
                setSpeedX(-3);
                setSpeedY(3);
            }
            else if(getSprite().getRotation() >= 155 && getSprite().getRotation() < 205){
                setSpeedX(-3);
                setSpeedY(0);
            }
            else if(getSprite().getRotation() >= 205 && getSprite().getRotation() < 245){
                setSpeedX(-3);
                setSpeedY(-3);
            }
            else if(getSprite().getRotation() >= 245 && getSprite().getRotation() < 295){
                setSpeedX(0);
                setSpeedY(-3);
            }
            else if(getSprite().getRotation() >= 295 && getSprite().getRotation() < 335){
                setSpeedX(3);
                setSpeedY(-3);
            }
            else if(getSprite().getRotation() == 360){
                getSprite().setRotation(0);
            }
            else if(getSprite().getRotation() >= 335 && getSprite().getRotation() < 25){
                setSpeedX(3);
                setSpeedY(0);
            }
            if(getSprite().getRotation() <= 0 && getSprite().getRotation() > -25){
                 setSpeedX(3);
                 setSpeedY(0);
            }
            else if(getSprite().getRotation() <= -25 && getSprite().getRotation() > -65){
                 setSpeedX(3);
                 setSpeedY(-3);
            }
            else if(getSprite().getRotation() <= -65 && getSprite().getRotation() > -115){
                 setSpeedX(0);
                 setSpeedY(-3);
            }
            else if(getSprite().getRotation() <= -115 && getSprite().getRotation() > -155){
                 setSpeedX(-3);
                 setSpeedY(-3);
            }
            else if(getSprite().getRotation() <= -155 && getSprite().getRotation() > -205){
                 setSpeedX(-3);
                 setSpeedY(0);
            }
            else if(getSprite().getRotation() <= -205 && getSprite().getRotation() > -245){
                 setSpeedX(-3);
                 setSpeedY(3);
            }
            else if(getSprite().getRotation() <= -245 && getSprite().getRotation() > -295){
                 setSpeedX(0);
                 setSpeedY(3);
            }
            else if(getSprite().getRotation() <= -295 && getSprite().getRotation() > -335){
                 setSpeedX(3);
                 setSpeedY(3);
            }
            else if(getSprite().getRotation() == -360){
                 getSprite().setRotation(0);
            }
            else if(getSprite().getRotation() <= -335 && getSprite().getRotation() > -25){
                 setSpeedX(3);
                 setSpeedY(0);
            }
    }

    //Metod för att bromsa spelarens bil
    public void brake(){
        if(getSpeedX() > 0){
            setSpeedX(getSpeedX()-1);
        }
        else if(getSpeedX() < 0){
            setSpeedX(getSpeedX()+1);
        }
        if(getSpeedY() > 0){
            setSpeedY(getSpeedY()-1);
        }
        else if(getSpeedY() < 0){
            setSpeedY(getSpeedY()+1);
        }


    }

    //Metod för att förändra rotationen och spelarens position på Y-axlen.
    public void turnLeft(){
        getSprite().rotate(2);

        if ((getSprite().getRotation() >= 0 && getSprite().getRotation() < 90)){
            getSprite().translateY(0.1f);
        }
        else if(getSprite().getRotation() >= 90 && getSprite().getRotation() < 180){
            getSprite().translateX(-0.1f);
        }
        else if(getSprite().getRotation() >= 180 && getSprite().getRotation() < 270){
            getSprite().translateY(-0.1f);
        }
        else if(getSprite().getRotation() >= 270 && getSprite().getRotation() < 360){
            getSprite().translateX(0.1f);
        }
        else if(getSprite().getRotation() >= 360){
            getSprite().setRotation(0);
        }
    }

    //Metod för att förändra rotationen och spelarens plats på Y-axlen.
    public void turnRight(){
        getSprite().rotate(-2);

        if(getSprite().getRotation() <= -1 && getSprite().getRotation() > -88){
            getSprite().translateY(-0.1f);
        }
        else if (getSprite().getRotation() <= -88 && getSprite().getRotation() > -158){
            getSprite().translateX(-0.1f);
        }
        else if (getSprite().getRotation() <= -158 && getSprite().getRotation() > -268){
            getSprite().translateY(0.1f);
        }
        else if (getSprite().getRotation() <= -268 && getSprite().getRotation() > -358){
            getSprite().translateX(0.1f);
        }
        else if(getSprite().getRotation() <= -358){
            getSprite().setRotation(0);

        }

    }

}
